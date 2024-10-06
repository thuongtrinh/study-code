package variable

import "fmt"

func DeclareVariable() {
	fmt.Println("\n===DeclareVariable===")

	// Variable declared and initialized without expression
	var myvariable1 int
	var myvariable2 string
	var myvariable3 float64

	// Display the zero-value of the variables
	fmt.Printf("The value of myvariable1 is : %d\n", myvariable1)
	fmt.Printf("The value of myvariable2 is : %s\n", myvariable2)
	fmt.Printf("The value of myvariable3 is : %f", myvariable3)

	fmt.Println("\n\n===Multiple variables of the same type===")

	// Multiple variables of the same type are declared and initialized in the single line
	var myvarsame1, myvarsame2, myvarsame3 int = 2, 454, 67

	// Display the values of the variables
	fmt.Printf("The value of myvarsame1 is : %d\n", myvarsame1)
	fmt.Printf("The value of myvarsame2 is : %d\n", myvarsame2)
	fmt.Printf("The value of myvarsame3 is : %d", myvarsame3)

	fmt.Println("\n\n===Multiple variables of different types===")

	// Multiple variables of different types are declared and initialized in the single line
	var myvardif1, myvardif2, myvardif3 = 2, "GFG", 67.56

	// Display the value and type of the variables
	fmt.Printf("The value of myvardif1 is : %d\n", myvardif1)
	fmt.Printf("The type of myvardif1 is : %T\n", myvardif1)
	fmt.Printf("\nThe value of myvardif2 is : %s\n", myvardif2)
	fmt.Printf("The type of myvardif2 is : %T\n", myvardif2)
	fmt.Printf("\nThe value of myvardif3 is : %f\n", myvardif3)
	fmt.Printf("The type of myvardif3 is : %T\n", myvardif3)
}
