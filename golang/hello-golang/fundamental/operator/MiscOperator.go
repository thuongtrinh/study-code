package operator

import "fmt"

func MiscOperator() {
	fmt.Println("\n\n===MiscOperator===")

	a := 4
	// Using address of operator(&) and pointer indirection(*) operator
	b := &a

	fmt.Printf("a  = %d", a)
	fmt.Printf("\nb := &a, *b = %d", *b)
	fmt.Printf("\n b = %d", b)
	fmt.Println("\n &a:", &a)
	fmt.Println(" &b:", &b)

	fmt.Println(" *b = 7")
	*b = 7
	fmt.Printf(" a = %d", a)
	fmt.Println()
	fmt.Println(" &a:", &a)
	fmt.Println(" &b:", &b)
}
