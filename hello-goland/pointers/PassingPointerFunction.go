package pointers

import "fmt"

func PassingPointerFunction() {
	fmt.Println("\n====Passing Pointers to a Function====")

	var x = 100
	fmt.Printf("The value of x before function call is: %d\n", x)

	// taking a pointer variable and assigning the address of x to it
	var pa *int = &x

	// calling the function by passing pointer to function
	ptf(pa)
	fmt.Printf("The value of x after function call is: %d\n", x)

	// taking a normal variable
	var x1 = 100
	fmt.Printf("The value of x1 before function call is: %d\n", x1)
	ptf(&x)
	fmt.Printf("The value of x1 after function call is: %d\n", x1)
}

func ptf(a *int) {
	*a = 748 // dereferencing
}
