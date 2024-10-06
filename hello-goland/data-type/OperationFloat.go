package data_type

import "fmt"

func OperationFloat() {
	var x float32 = 5.00
	var y float32 = 2.25

	fmt.Println("\n\n===OperationFloat===")
	//Addition
	fmt.Printf("addition :  %g + %g = %g\n ", x, y, x+y)
	//Subtraction
	fmt.Printf("subtraction : %g - %g = %g\n", x, y, x-y)
	//Multiplication
	fmt.Printf("multiplication : %g * %g = %g\n", x, y, x*y)
	//Division
	fmt.Printf("division : %g / %g = %g\n", x, y, x/y)
}
