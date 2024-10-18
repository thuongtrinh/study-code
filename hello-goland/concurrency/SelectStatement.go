package concurrency

import (
	"fmt"
	"time"
)

func SelectStatement() {
	fmt.Println("\n===Select Statement===")

	// Creating channels
	R1 := make(chan string)
	R2 := make(chan string)

	// calling function 1 and function 2 in goroutine
	go portal1(R1)
	go portal2(R2)

	select {
	// case 1 for portal 1
	case op1 := <-R1:
		fmt.Println(op1)

	// case 2 for portal 2
	case op2 := <-R2:
		fmt.Println(op2)
	}

	// Ex2: Select statement  without any case
	/*
		select {}  // fatal error: all goroutines are asleep - deadlock!
	*/

	// Ex3:  there is no case statement is ready, channel is not ready and no default case
	// fatal error: all goroutines are asleep - deadlock!
	/*
		mychannel0 := make(chan int)
		select {
			case <-mychannel0:
		}
	*/

	// Ex4: default statement to protect select statement from blocking
	mychannel1 := make(chan int) // creating channel
	select {
	case <-mychannel1:
	default:
		fmt.Println("Not found")
	}
}

// function 1
func portal1(channel1 chan string) {
	time.Sleep(3 * time.Second)
	channel1 <- "Welcome to channel 1"
}

// function 2
func portal2(channel2 chan string) {
	time.Sleep(9 * time.Second)
	channel2 <- "Welcome to channel 2"
}
