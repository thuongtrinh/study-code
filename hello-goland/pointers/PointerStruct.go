package pointers

import "fmt"

func PointerStruct() {
	fmt.Println("\n====Pointer to a Struct====")

	// Employee struct type
	emp := Employee{"ABC", 19078}

	// Here, it is the pointer to the struct
	pts := &emp

	fmt.Println(pts)
	fmt.Println(*pts)

	// accessing the struct fields(liem employee's name)
	// using a pointer but here we are not using dereferencing explicitly
	fmt.Println(pts.name)

	// same as above by explicitly using dereferencing concept means the result will be the same
	fmt.Println((*pts).name)

	fmt.Println("\nExample 2:")
	emp1 := Employee{"ABC", 19078}

	// Here, it is the pointer to the struct
	pts1 := &emp1
	fmt.Println(pts1)

	// updating the value of name
	pts1.name = "XYZ"
	fmt.Println(pts1)
}

type Employee struct {
	name  string
	empid int
}
