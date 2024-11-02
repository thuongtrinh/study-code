package functions

import "fmt"

func FunctionArgument() {
	fmt.Println("\n===FunctionArgument ===")
	var Z int = 10
	fmt.Printf("Before Function Call, value of Z is = %d", Z)
	modify(Z)
	fmt.Printf("\nAfter Function Call, value of Z is = %d", Z)

	fmt.Println("\n\n===call by Reference by passing the address of the variable Z1===")
	var Z1 int = 10
	fmt.Printf("Before Function Call, value of Z1 is = %d", Z1)
	modify1(&Z1)
	fmt.Printf("\nAfter Function Call, value of Z1 is = %d", Z1)

	fmt.Println("\n\n===call by Reference by passing the address of the variables===")
	var f int = 700
	var s int = 900
	fmt.Printf("Values Before Function Call\n")
	fmt.Printf("f = %d and s = %d\n", f, s)
	swapFS(&f, &s)
	fmt.Printf("Values After Function Call\n")
	fmt.Printf("f = %d and s = %d", f, s)
}

func modify(Z int) {
	Z = 70
}

func modify1(Z *int) {
	*Z = 70
}

func swapFS(x, y *int) int {
	var tmp int
	tmp = *x
	*x = *y
	*y = tmp
	return tmp
}
