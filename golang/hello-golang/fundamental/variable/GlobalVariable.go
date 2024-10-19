package variable

import "fmt"

// global variable declaration
var myvariable1 int = 100

// global variable declaration
var myvariable3 int = 300

func GlobalVariable() { // from here local level scope starts
	fmt.Println("\n===GlobalVariable===")

	// local variables inside the main function
	var myvariable2 int = 200

	// Display the value of global variable
	fmt.Printf("The value of Global myvariable1 is : %d\n", myvariable1)

	// Display the value of local variable
	fmt.Printf("The value of Local myvariable2 is : %d\n", myvariable2)

	var myvariable3 int = 3000

	// Display the value
	fmt.Printf("The value of myvariable3 is : %d\n", myvariable3)

	// calling the function
	display()
} // here local level scope ends

// taking a function
func display() { // local level starts

	// Display the value of global variable
	fmt.Printf("The value of Global myvariable1 is : %d\n", myvariable1)
	fmt.Printf("The value of Global myvariable3 is : %d\n", myvariable3)

} // local scope ends here
