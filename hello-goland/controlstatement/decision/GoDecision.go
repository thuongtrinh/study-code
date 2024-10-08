package decision

import "fmt"

func GoDecision() {
	fmt.Println("\n===GoDecision===")

	ifStatement()
	nestedIfStatement()
}

func ifStatement() {
	var v int = 700
	if v < 1000 {
		fmt.Printf("v is less than 1000\n")
	} else {
		fmt.Printf("v is greater than 1000\n")
	}
	fmt.Printf("Value of v is : %d\n", v)
}

func nestedIfStatement() {
	var v1 int = 700

	if v1 == 100 {
		fmt.Printf("Value of v1 is 100\n")
	} else if v1 == 200 {
		fmt.Printf("Value of a is 20\n")
	} else if v1 == 300 {
		fmt.Printf("Value of a is 300\n")
	} else {
		fmt.Printf("None of the values is matching\n")
		if v1 == 700 {
			fmt.Printf("Value of v1 is 700\n")
		}
	}
}
