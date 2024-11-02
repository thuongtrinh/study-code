package variable

import (
	"fmt"
	"math"
)

func GoVariables() {
	fmt.Println("\n===GoVariables var key===")

	// Variable declared and initialized without the explicit type
	var myvariable1 = 20
	var myvariable2 = "GoVariables"
	var myvariable3 = 34.80

	// Display the value and the type of the variables
	fmt.Printf("The value of myvariable1 is : %d\n", myvariable1)
	fmt.Printf("The type of myvariable1 is : %T\n", myvariable1)
	fmt.Printf("The value of myvariable2 is : %s\n", myvariable2)
	fmt.Printf("The type of myvariable2 is : %T\n", myvariable2)
	fmt.Printf("The value of myvariable3 is : %f\n", myvariable3)
	fmt.Printf("The type of myvariable3 is : %T\n", myvariable3)

	// Go is a strongly typed language as you cannot assign a value of another type to the declared variable.
	z := 50
	fmt.Printf("Value of z is %d\n", z)
	//z := "Golang" ==> reassigning the value of string type it will give an error

	i := math.Max(11, 33)
	fmt.Printf("Value of i is %f\n", i)

}
