package data_type

import "fmt"

func BooleanType() {
	fmt.Println("\n\n===BooleanType===")

	// variables
	str1 := "DataforBoolean"
	str2 := "dataForbooleans"
	str3 := "DataforBoolean"
	result1 := str1 == str2
	result2 := str1 == str3

	// Display the result
	fmt.Println(result1)
	fmt.Println(result2)

	// Display the type of
	// result1 and result2
	fmt.Printf("The type of result1 is %T and "+"the type of result2 is %T", result1, result2)
}
