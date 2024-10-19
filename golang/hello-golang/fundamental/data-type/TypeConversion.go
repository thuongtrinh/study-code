package data_type

import "fmt"

func TypeConversion() {
	fmt.Println("\n\n===Type Casting or Type Conversion in Golang===")

	// taking the required data into variables
	var totalsum int = 846
	var number int = 19
	var avg float32

	// explicit type conversion
	avg = float32(totalsum) / float32(number)

	// Displaying the result
	fmt.Printf("Average = %f\n", avg)

	var geek1 int64 = 875
	//var geek2 int = geek1  => Cannot use 'geek1' (type int64) as the type int
	var geek3 int = 100
	//var addition = geek1 + geek3  => Invalid operation: geek1 + geek3 (mismatched types int64 and int)
	fmt.Print(geek1, geek3)
}
