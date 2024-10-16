package pointers

import "fmt"

func ComparingPointer() {
	fmt.Println("\n====Comparing Pointers====")

	val1 := 2345
	val2 := 567

	// Creating and initializing pointers
	var p1 *int
	p1 = &val1
	p2 := &val2
	p3 := &val1

	// Comparing pointers with each other Using == operator
	res1 := &p1 == &p2
	fmt.Println("Is p1 pointer is equal to p2 pointer: ", res1)

	res2 := p1 == p2
	fmt.Println("Is p1 pointer is equal to p2 pointer: ", res2)

	res3 := p1 == p3
	fmt.Println("Is p1 pointer is equal to p3 pointer: ", res3)

	res4 := p2 == p3
	fmt.Println("Is p2 pointer is equal to p3 pointer: ", res4)

	res5 := &p3 == &p1
	fmt.Println("Is p3 pointer is equal to p1 pointer: ", res5)

	fmt.Println("\nExample 2:")
	val01 := 2345
	val02 := 567

	// Creating and initializing pointers
	var p01 *int
	p01 = &val01
	p02 := &val02
	p03 := &val01

	// Comparing pointers with each other Using != operator
	res01 := &p01 != &p02
	fmt.Println("Is p1 pointer not equal to p2 pointer: ", res01)

	res02 := p01 != p02
	fmt.Println("Is p1 pointer not equal to p2 pointer: ", res02)

	res03 := p01 != p03
	fmt.Println("Is p1 pointer not equal to p3 pointer: ", res03)

	res04 := p02 != p03
	fmt.Println("Is p2 pointer not equal to p3 pointer: ", res04)

	res05 := &p03 != &p01
	fmt.Println("Is p3 pointer not equal to p1 pointer: ", res05)
}
