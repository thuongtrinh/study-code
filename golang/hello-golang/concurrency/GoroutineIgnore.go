package concurrency

import "fmt"

func GoroutineIgnore() {
	fmt.Println("\n===Goroutines ignores – Concurrency in Golang===")

	// Calling Goroutine: ignores
	go display("Welcome Goroutine ignores")

	// Calling normal function
	display("Hello normal function")
}

func display(str string) {
	for w := 0; w < 6; w++ {
		fmt.Println(str)
	}
}
