package structure

import "fmt"

func PointerToStruct() {
	fmt.Println("\n\n====PointerToStruct====")

	// passing the address of struct variable emp8 is a pointer to the Employee struct
	emp8 := &Employee{"Sam", "Anderson", 55, 6000}

	// (*emp8).firstName is the syntax to access the firstName field of the emp8 struct
	fmt.Println("First Name:", (*emp8).firstName)
	fmt.Println("Age:", (*emp8).age)

	// OR: emp8.firstName is used to access the field firstName
	fmt.Println("First Name: ", emp8.firstName)
	fmt.Println("Age: ", emp8.age)
}

type Employee struct {
	firstName, lastName string
	age, salary         int
}
