package concurrency

import "fmt"

func ChannelImportantPoints() {
	fmt.Println("\n===Important Points of Channel===")

	// Creating a channel using make() function
	mychnl := make(chan string)

	// Anonymous goroutine
	go func() {
		mychnl <- "GFG"
		mychnl <- "gfg"
		mychnl <- "Channel"
		mychnl <- "ChannelforChannel"
		close(mychnl)
	}()

	// Using for loop
	for res := range mychnl {
		fmt.Println(res)
	}

	// Finding the length of the channel using len() function
	// Creating a channel, using make() function
	fmt.Println("\nEx2: Length of the channel")

	mychnl2 := make(chan string, 4)
	mychnl2 <- "GFG"
	mychnl2 <- "gfg"
	mychnl2 <- "Channel"
	mychnl2 <- "ChannelforChannel"

	// Finding the length of the channel, using len() function
	fmt.Println("\nEx3: Length of the channel is: ", len(mychnl2))

	// Capacity of the Channel
	// Creating a channel using make() function
	mychnl3 := make(chan string, 5)
	mychnl3 <- "GFG"
	mychnl3 <- "gfg"
	mychnl3 <- "Channel"
	mychnl3 <- "ChannelforChannel"

	// Finding the capacity of the channel using cap() function
	fmt.Println("Capacity of the channel is: ", cap(mychnl3))
}
