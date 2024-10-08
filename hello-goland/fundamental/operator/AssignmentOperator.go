package operator

import "fmt"

func AssignmentOperator() {
	fmt.Println("\n\n===AssignmentOperator===")
	var p int = 45
	var q int = 50

	fmt.Printf("p = %d", p)
	fmt.Printf("\nq = %d", q)
	fmt.Println()

	// “=”(Simple Assignment)
	p = q
	fmt.Println(p)

	// “+=”(Add Assignment)
	p += q
	fmt.Println(p)

	//“-=”(Subtract Assignment)
	p -= q
	fmt.Println(p)

	// “*=”(Multiply Assignment)
	p *= q
	fmt.Println(p)

	// “/=”(Division Assignment)
	p /= q
	fmt.Println(p)

	// “%=”(Modulus Assignment)
	p %= q
	fmt.Println(p)
}
