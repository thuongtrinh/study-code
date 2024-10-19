package methods

import "fmt"

func MultipleDefer() {
	fmt.Println("\n===MultipleDefer ===")

	fmt.Println("Start")

	// Multiple defer statements Executes in LIFO order
	defer fmt.Println("End")
	defer add(34, 56)
	defer add(10, 10)
}

func add(a1, a2 int) int {
	res := a1 + a2
	fmt.Println("Result: ", res)
	return 0
}
