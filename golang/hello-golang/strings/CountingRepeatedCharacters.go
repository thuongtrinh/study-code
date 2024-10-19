package strings

import (
	"fmt"
	"strings"
)

func CountingRepeatedCharacters() {
	fmt.Println("\n====Counting the Number of Repeated Characters in String====")

	str1 := "Welcome to the online portal of GolangforGolang"
	str2 := "My dog name is Dollar"
	str3 := "I like to play Ludo"

	fmt.Println("String 1: ", str1)
	fmt.Println("String 2: ", str2)
	fmt.Println("String 3: ", str3)

	// Counting the elements of the strings. Using Count() function
	res1 := strings.Count(str1, "o")
	res2 := strings.Count(str2, "do")

	// Here, it also counts white spaces
	res3 := strings.Count(str3, "")
	res4 := strings.Count("GolangforGolang, golang", "as")

	fmt.Println("\nResult 1: ", res1)
	fmt.Println("Result 2: ", res2)
	fmt.Println("Result 3: ", res3)
	fmt.Println("Result 4: ", res4)
}
