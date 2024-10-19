package data_type

import "fmt"

func ComplexNumber() {
	fmt.Println("\n\n===ComplexNumber===")

	var a complex128 = complex(6, 2)
	var b complex64 = complex(9, 2)
	fmt.Println(a)
	fmt.Println(b)

	// Display the type
	fmt.Printf("The type of a is %T and "+"the type of b is %T", a, b)
}
