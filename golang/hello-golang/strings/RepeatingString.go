package strings

import (
	"fmt"
	"strings"
)

func RepeatingString() {
	fmt.Println("\n====Repeating a String for Specific Number of Times====")

	str1 := "Welcome to GolangfoGolang !.."
	str2 := "This is the tutorial of Go: "

	// Repeating the given strings. Using Repeat function
	res1 := strings.Repeat(str1, 4)
	res2 := str2 + strings.Repeat("Language..", 2)
	fmt.Println("Result 1: ", res1)
	fmt.Println("Result 2:", res2)

	/*
		// Error:  count is negative or the result of (len(str) * count) overflows.
		res3 := str2 + strings.Repeat("Language..", -2)
		fmt.Println("Result 3:", res3)
	*/

	// Repeating the given strings
	fmt.Println("\nEx2: Repeating Using for loop")
	str4 := "Welcome to GolangfoGolang !.."
	i := 0
	res4 := " "
	for i < 3 {
		res4 += str4
		i += 1
	}
	fmt.Println("Result 4: ", res4)
}
