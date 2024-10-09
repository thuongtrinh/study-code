package functions

import (
	"fmt"
	"strings"
)

func VariadicFunction() {
	fmt.Println("\n===VariadicFunction===")

	// zero argument
	fmt.Println(joinstr())

	// multiple arguments
	fmt.Println(joinstr("Variadic", "GFG"))
	fmt.Println(joinstr("Variadic", "for", "Variadic"))
	fmt.Println(joinstr("G", "O", "O", "D"))

	// pass a slice in variadic function
	elements := []string{"geeks", "FOR", "geeks"}
	fmt.Println(joinstr(elements...))
}

// Variadic function to join strings
func joinstr(elements ...string) string {
	return strings.Join(elements, "-")
}
