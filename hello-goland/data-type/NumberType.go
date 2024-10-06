package data_type

import "fmt"

func NumberType() {
	fmt.Println("\n\n===NumberType===")

	// Using 8-bit unsigned int
	var X uint8 = 225
	fmt.Println(X, X-3)

	// Using 16-bit signed int
	var Y int16 = 32767
	fmt.Print(Y+2, Y-2)
}
