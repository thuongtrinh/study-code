package data_type

import "fmt"

func FloatNumber() {
	fmt.Println("\n\n===FloatNumber===")

	a := 20.45
	b := 34.89

	// Subtraction of two
	// floating-point number
	c := b - a

	// Display the result
	fmt.Printf("Result is: %f", c)

	// Display the type of c variable
	fmt.Printf("\nThe type of c is : %T", c)
}
