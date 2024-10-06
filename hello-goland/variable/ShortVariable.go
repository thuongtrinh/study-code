package variable

import "fmt"

func ShortVariable() {
	fmt.Println("\n===ShortVariable===")

	// Using short variable declaration
	myvar1 := 39
	myvar2 := "ShortVariable"
	myvar3 := 34.67

	// Display the value and type of the variables
	fmt.Printf("The value of myvar1 is : %d\n", myvar1)
	fmt.Printf("The type of myvar1 is : %T\n", myvar1)

	fmt.Printf("\nThe value of myvar2 is : %s\n", myvar2)
	fmt.Printf("The type of myvar2 is : %T\n", myvar2)

	fmt.Printf("\nThe value of myvar3 is : %f\n", myvar3)
	fmt.Printf("The type of myvar3 is : %T\n", myvar3)

	fmt.Println("\n===Using short variable declaration Multiple variables===")
	// Using short variable declaration Multiple variables of same types are declared and initialized in the single line
	myvarsame1, myvarsame2, myvarsame3 := 800, 34, 56

	// Display the value and type of the variables
	fmt.Printf("The value of myvarsame1 is : %d\n", myvarsame1)
	fmt.Printf("The type of myvarsame1 is : %T\n", myvarsame1)

	fmt.Printf("\nThe value of myvarsame2 is : %d\n", myvarsame2)
	fmt.Printf("The type of myvarsame2 is : %T\n", myvarsame2)

	fmt.Printf("\nThe value of myvarsame3 is : %d\n", myvarsame3)
	fmt.Printf("The type of myvarsame3 is : %T\n", myvarsame3)

	fmt.Println("\n===Using short variable declaration acts as an assignment for myvar02 variable===")
	// Using short variable declaration
	// Here, short variable declaration acts as an assignment for myvar02 variable
	// because same variable present in the same block so the value of myvar02 is changed from 45 to 100
	myvar01, myvar02 := 39, 45
	myvar03, myvar02 := 45, 100

	// If you try to run the commented lines, then compiler will gives error because these variables are already defined
	// myvar01, myvar02 := 43, 47
	// myvar02:= 200

	// Display the values of the variables
	fmt.Printf("The value of myvar1 and myvar2 is : %d %d\n", myvar01, myvar02)
	fmt.Printf("The value of myvar3 and myvar2 is : %d %d\n", myvar03, myvar02)

	fmt.Println("\n===Multiple variables of different types are declared and initialized in the single line===")
	// Using short variable declaration
	// Multiple variables of different types are declared and initialized in the single line
	myvar001, myvar002, myvar003 := 800, "Multiple", 47.56

	// Display the value and type of the variables
	fmt.Printf("The value of myvar001 is : %d\n", myvar001)
	fmt.Printf("The type of myvar001 is : %T\n", myvar001)

	fmt.Printf("\nThe value of myvar002 is : %s\n", myvar002)
	fmt.Printf("The type of myvar002 is : %T\n", myvar002)

	fmt.Printf("\nThe value of myvar003 is : %f\n", myvar003)
	fmt.Printf("The type of myvar003 is : %T\n", myvar003)
}
