package decision

import "fmt"

func SelectAndDeadlock() {
	fmt.Println("\n===SelectAndDeadlock===")

	//Deadlock()
	ResolveDeadlock()
	executionDefaultCase()
}

func Deadlock() {
	// Creating a channel. Here deadlock arises because no goroutine is writing to this channel,
	// so the select statement has been blocked forever
	c := make(chan int)
	select {
	case <-c:
	}
}

func ResolveDeadlock() {
	fmt.Println("\n===ResolveDeadlock===")
	c := make(chan int) // Creating a channel
	select {
	case <-c:
	default:
		fmt.Println("!.. Default case..!")
	}
}

func executionDefaultCase() {
	var c chan int // Creating a channel
	select {
	case x1 := <-c:
		fmt.Println("Value: ", x1)
	default:
		fmt.Println("Default case..!")
	}
}
