package errors

import "fmt"

func DeferCreateLog() {
	fmt.Println("\n===DeferCreateLog===\n")

	logStartEnd("main DeferCreateLog")
	fmt.Println("Doing some work in main")
}

func logStartEnd(name string) {
	fmt.Printf("Start %s\n", name)
	defer fmt.Printf("End %s\n", name)
}
