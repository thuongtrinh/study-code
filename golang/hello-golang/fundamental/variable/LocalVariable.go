package variable

import "fmt"

var v1 = 900

// v2 := 200 =>  operator(:=) you can only declare the local variable

func LocalVariable() { // from here local level scope of main function starts
	fmt.Println("\n===LocalVariable===")

	// local variables inside the main function
	var myvariable1, myvariable2 int = 89, 45

	// Display the values of the variables
	fmt.Printf("The value of myvariable1 is : %d\n", myvariable1)

	fmt.Printf("The value of myvariable2 is : %d\n", myvariable2)

	// short variable declaration operator(:=) you can only declare the local variable
	v2 := 200

	fmt.Printf("The value of v1 is : %d\n", v1) //accessing v1 inside the function
	fmt.Printf("The value of v2 is : %d\n", v2) //accessing v2 inside the function
}
