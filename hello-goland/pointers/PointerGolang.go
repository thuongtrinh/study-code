package pointers

import "fmt"

func PointerGolang() {
	fmt.Println("\n====Pointers in Golang====")

	// storing the hexadecimal values in variables
	x := 0xFF
	y := 0x9C

	fmt.Printf("Type of variable x is %T\n", x)
	fmt.Printf("Value of x in hexadecimal is %X\n", x)
	fmt.Printf("Value of x in decimal is %v\n", x)

	fmt.Printf("Type of variable y is %T\n", y)
	fmt.Printf("Value of y in hexadecimal is %X\n", y)
	fmt.Printf("Value of y in decimal is %v\n", y)

	// taking a normal variable
	var z int = 5748

	// declaration of pointer
	var p *int

	// initialization of pointer
	p = &z

	// displaying the result
	fmt.Println("\nValue stored in z = ", z)
	fmt.Println("Address of z = ", &z)
	fmt.Println("Value stored in variable p, address = ", p)
	fmt.Println("Value of *p = ", *p)

	// taking a pointer
	var s *int
	fmt.Println("s = ", s)

	// using var keyword we are not defining any type with variable
	var y1 = 458

	// taking a pointer variable using var keyword without specifying the type
	var p1 = &y1

	fmt.Println("\nValue stored in y1 = ", y1)
	fmt.Println("Address of y1 = ", &y1)
	fmt.Println("Value stored in pointer variable p1 = ", p1)

	// using := operator to declare and initialize the variable
	y2 := 458

	// taking a pointer variable using := by assigning it with the address of variable y
	p2 := &y2

	fmt.Println("\nValue stored in y2 = ", y2)
	fmt.Println("Address of y2 = ", &y2)
	fmt.Println("Value stored in pointer variable p2 = ", p2)

	var y3 = 458
	var p3 = &y3

	fmt.Println("\nValue stored in y3 = ", y3)
	fmt.Println("Address of y3 = ", &y3)
	fmt.Println("Value stored in pointer variable p3 = ", p3)

	// this is dereferencing a pointer using * operator before a pointer
	// variable to access the value stored at the variable at which it is pointing
	fmt.Println("Value stored in y(*p3) = ", *p3)

	var y4 = 458
	var p4 = &y

	fmt.Println("\nValue stored in y4 before changing = ", y4)
	fmt.Println("Address of y4 = ", &y4)
	fmt.Println("Value stored in pointer variable p4 = ", p4)

	// this is dereferencing a pointer using * operator before a pointer
	// variable to access the value stored at the variable at which it is pointing
	fmt.Println("Value stored in y(*p4) Before Changing = ", *p4)

	// changing the value of y by assigning the new value to the pointer
	*p = 500

	fmt.Println("Value stored in y(*p4) after Changing = ", y4)

}
