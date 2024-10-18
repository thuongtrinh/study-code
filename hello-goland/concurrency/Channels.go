package concurrency

import "fmt"

func Channels() {
	fmt.Println("\n===Channel in Golang===")

	// Creating a channel using var keyword
	var mychannel chan int
	fmt.Println("Value of the channel: ", mychannel)
	fmt.Printf("Type of the channel: %T ", mychannel)

	// Creating a channel using make() function
	mychannel1 := make(chan int)
	fmt.Println("\nValue of the channel1: ", mychannel1)
	fmt.Printf("Type of the channel1: %T ", mychannel1)

	// Send and Receive Data From a Channel
	fmt.Println("\n\nnEx2: Send and Receive Data From a Channel")
	fmt.Println("start Main method")

	// Creating a channel
	ch := make(chan int)

	go myfunc(ch)
	ch <- 23
	fmt.Println("End Main method")
}

func myfunc(ch chan int) {
	fmt.Println(234 + <-ch)
}
