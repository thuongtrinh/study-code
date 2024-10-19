package functions

import "fmt"

func FunctionInGo() {
	fmt.Println("\n===Function Calling===")
	fmt.Printf("Area of rectangle is : %d", area(12, 10))

	fmt.Println("\n\n===Function Arguments===")
	var p int = 10
	var q int = 20
	fmt.Printf("p = %d and q = %d", p, q)
	swap(p, q) // call by values
	fmt.Printf("\np = %d and q = %d", p, q)

	fmt.Println("\n\n===Function call by reference===")
	var p1 int = 10
	var q1 int = 20
	fmt.Printf("p1 = %d and q1 = %d", p1, q1)
	swapReference(&p1, &q1) // call by reference
	fmt.Printf("\np1 = %d and q1 = %d", p1, q1)
}

func area(length, width int) int {
	Ar := length * width
	return Ar
}

// function which swap values
func swap(a, b int) int {
	var o int
	o = a
	a = b
	b = o
	return o
}

// function which swap call by reference
func swapReference(a, b *int) int {
	var o int
	o = *a
	*a = *b
	*b = o
	return o
}
