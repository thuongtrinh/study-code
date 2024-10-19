package methods

import "fmt"

func DeferKeyword() {
	fmt.Println("\n===DeferKeyword ===")

	// function behaves like a normal function
	mul(23, 45)

	// Here the mul() function is defer function
	defer mul(23, 56)

	show()
}

func mul(a1, a2 int) int {
	res := a1 * a2
	fmt.Println("Result: ", res)
	return 0
}

func show() {
	fmt.Println("Hello!, Golang")
}
