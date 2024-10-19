package concurrency

import "fmt"

func SelectStatementMultipleCases() {
	fmt.Println("\n===Select Statement, multiple cases===")

	// Creating channels
	R1 := make(chan string)
	R2 := make(chan string)

	// calling function 1 and function 2 in goroutine
	go portal01(R1)
	go portal02(R2)

	// the choice of selection of case is random
	select {
	case op1 := <-R1:
		fmt.Println(op1)
	case op2 := <-R2:
		fmt.Println(op2)
	}
}

// function 1
func portal01(channel1 chan string) {
	for i := 0; i <= 3; i++ {
		fmt.Printf("\n%d", i)
		channel1 <- "Welcome, multiple to channel 1"
	}
}

// function 2
func portal02(channel2 chan string) {
	channel2 <- "Welcome, multiple to channel 2"
}
