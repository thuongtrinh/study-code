package functions

import "fmt"

func BlankIdentifier() {
	fmt.Println("\n===BlankIdentifier ===")

	// function returns two values which are assigned to mul and blank identifier
	mul, _ := mul_div(105, 7)

	// only using the mul variable
	fmt.Println("105 x 7 = ", mul)
}

// function returning two values of integer type
func mul_div(n1 int, n2 int) (int, int) {
	return n1 * n2, n1 / n2
}
