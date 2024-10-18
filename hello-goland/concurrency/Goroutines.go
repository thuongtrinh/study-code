package concurrency

import (
	"fmt"
	"time"
)

func Goroutines() {
	fmt.Println("\n===Goroutines – Concurrency ignores in Golang===")

	// Calling Goroutine
	go display2("Welcome Goroutine")

	// Calling normal function
	display2("Calling normal")
}

func display2(str string) {
	for w := 0; w < 6; w++ {
		time.Sleep(1 * time.Second)
		fmt.Println(str)
	}
}
