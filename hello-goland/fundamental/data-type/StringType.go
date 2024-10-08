package data_type

import "fmt"

func StringType() {
	fmt.Println("\n\n===StringType===")

	// str variable which stores strings
	str := "StringType"

	// Display the length of the string
	fmt.Printf("Length of the string is:%d", len(str))

	// Display the string
	fmt.Printf("\nString is: %s", str)

	// Display the type of str variable
	fmt.Printf("\nType of str is: %T", str)
}
