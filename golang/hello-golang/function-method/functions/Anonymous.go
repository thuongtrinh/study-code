package functions

import "fmt"

func Anonymous() {
	fmt.Println("\n===Anonymous function ===")

	// Anonymous function
	func() {
		fmt.Println("Welcome! to anonymous function")
	}()

	// Assigning an anonymous function to a variable
	value := func() {
		fmt.Println("Welcome! to assign an anonymous function")
	}
	value()

	// Passing arguments in anonymous function
	func(ele string) {
		fmt.Println(ele)
	}("Passing arguments in anonymous function")

	// Passing anonymous function as an argument
	value1 := func(p, q string) string {
		return p + q + "Passing"
	}
	GFG(value1)

	// Returning anonymous function
	value2 := GFG1()
	fmt.Println(value2("Welcome ", "to "))
}

func GFG(i func(p, q string) string) {
	fmt.Println(i("Passing", "for"))
}

func GFG1() func(i, j string) string {
	myf := func(i, j string) string {
		return i + j + "Returning anonymous"
	}
	return myf
}
