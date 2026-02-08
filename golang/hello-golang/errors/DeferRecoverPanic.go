package errors

import "fmt"

func DeferRecoverPanic() {
	fmt.Println("\n===DeferRecoverPanic===")

	safeDivide(4, 2)
	safeDivide(4, 0)
	fmt.Println("Program continues...")
}

func safeDivide(a, b int) {
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("Recovered from panic:", r)
		}
	}()
	fmt.Println(a / b)
}
