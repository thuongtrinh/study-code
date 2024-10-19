package concurrency

import "fmt"

func UnidirectionalChannel() {
	fmt.Println("\n===Unidirectional Channel in Golang===")

	// Only for receiving
	mychanl1 := make(<-chan string)

	// Only for sending
	mychanl2 := make(chan<- string)

	// Display the types of channels
	fmt.Printf("%T", mychanl1)
	fmt.Printf("\n%T", mychanl2)

	// Converting Bidirectional Channel into the Unidirectional Channel
	fmt.Printf("\n\nEx2: Converting Bidirectional Channel into the Unidirectional Channel\n")
	mychanl := make(chan string) // Creating a bidirectional channel

	// Here, sending() function convert the bidirectional channel into send only channel
	go sending(mychanl)

	// Here, the channel is sent only inside the goroutine outside the goroutine the channel is bidirectional
	// So, it print "Hello Channel"
	fmt.Println(<-mychanl)
}

func sending(s chan<- string) {
	s <- "Hello Channel"
}
