package constant

import "fmt"

func CompareString() {
	fmt.Println("\n===CompareString===")

	const A = "GFG"
	var B = "GoConstant"

	// Concat strings.
	var helloWorld = A + " " + B
	helloWorld += "!"
	fmt.Println(helloWorld)

	// Compare strings.
	fmt.Println(A == "GFG")
	fmt.Println(B < A)
}
