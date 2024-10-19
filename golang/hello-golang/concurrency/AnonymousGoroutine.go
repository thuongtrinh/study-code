package concurrency

import (
	"fmt"
	"time"
)

func AnonymousGoroutine() {
	fmt.Println("\n===Anonymous Goroutine===")

	fmt.Println("Welcome!! to Main function")

	// Creating Anonymous Goroutine
	go func() {
		fmt.Println("Welcome!! to Anonymous Goroutine")
	}()

	time.Sleep(1 * time.Second)
	fmt.Println("GoodBye!! to Main function")
}
