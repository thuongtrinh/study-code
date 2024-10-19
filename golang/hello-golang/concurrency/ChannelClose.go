package concurrency

import "fmt"

func ChannelClose() {
	fmt.Println("\n===Closing a Channel===")

	// Creating a channel
	c := make(chan string)

	// calling Goroutine
	go myfun2(c)

	// When the value of ok is set to true means the channel is open And it can send or receive data
	// When the value of ok is set to false means the channel is closed
	for {
		res, ok := <-c
		if ok == false {
			fmt.Println("Channel Close ", ok)
			break
		}
		fmt.Println("Channel Open ", res, ok)
	}
}

// Function
func myfun2(mychnl chan string) {
	for v := 0; v < 4; v++ {
		mychnl <- "Channel"
	}
	close(mychnl)
}
