package strings

import (
	"fmt"
	"strings"
)

func TrimmingString() {
	fmt.Println("\n====Trimming a String in Golang====")

	// Creating and initializing string. Using shorthand declaration
	str1 := "!!Welcome to GolangsforGolangs !!"
	str2 := "@@This is the tutorial of Golang$$"
	fmt.Println("Strings before trimming:")
	fmt.Println("String 1: ", str1)
	fmt.Println("String 2:", str2)
	res1 := strings.Trim(str1, "!") // Using Trim() function
	res2 := strings.Trim(str2, "@$")
	fmt.Println("\nStrings after trimming:")
	fmt.Println("Result 1: ", res1)
	fmt.Println("Result 2:", res2)

	fmt.Println("\nEx2: TrimLeft")
	str01 := "!!Welcome to GolangforGolang **"
	str02 := "@@This is the tutorial of Golang$$"
	fmt.Println("Strings before trimming:")
	fmt.Println("String 1: ", str01)
	fmt.Println("String 2:", str02)
	res01 := strings.TrimLeft(str01, "!*") // Using TrimLeft() function
	res02 := strings.TrimLeft(str02, "@")
	fmt.Println("\nStrings after trimming:")
	fmt.Println("Result 1: ", res01)
	fmt.Println("Result 2:", res02)

	fmt.Println("\nEx3: TrimRight")
	str001 := "!!Welcome to GolangforGolang **"
	str002 := "@@This is the tutorial of Golang$$"
	fmt.Println("Strings before trimming:")
	fmt.Println("String 1: ", str001)
	fmt.Println("String 2:", str002)
	res001 := strings.TrimRight(str001, "!*") // Using TrimRight() function
	res002 := strings.TrimRight(str002, "$")
	fmt.Println("\nStrings after trimming:")
	fmt.Println("Result 1: ", res001)
	fmt.Println("Result 2:", res002)

	fmt.Println("\nEx4: TrimSpace")
	str_1 := "   **Welcome to GolangforGolang**   "
	str_2 := "  ##This is the tutorial of Golang##  "
	fmt.Println("Strings before trimming:")
	fmt.Println(str_1, str_2)
	res_1 := strings.TrimSpace(str_1) // Using TrimSpace() function
	res_2 := strings.TrimSpace(str_2)
	fmt.Println("\nStrings after trimming:")
	fmt.Println(res_1, res_2)

	fmt.Println("\nEx5: TrimSuffix")
	str_01 := "Welcome, GolangforGolang"
	str_02 := "This is the, tutorial of Golang"
	fmt.Println("Strings before trimming:")
	fmt.Println("String 1: ", str_01)
	fmt.Println("String 2:", str_02)

	// Trimming suffix string from the given strings. Using TrimSuffix() function
	res_01 := strings.TrimSuffix(str_01, "GolangforGolang")
	res_02 := strings.TrimSuffix(str_02, "Hello")
	fmt.Println("\nStrings after trimming:")
	fmt.Println("Result 1: ", res_01)
	fmt.Println("Result 2:", res_02)

	fmt.Println("\nEx6: TrimPrefix")
	str_001 := "Welcome, GolangforGolang"
	str_002 := "This is the, tutorial of Golang"
	fmt.Println("Strings before trimming:")
	fmt.Println("String 1: ", str_001)
	fmt.Println("String 2: ", str_002)

	// Trimming prefix string from the given strings. Using TrimPrefix() function
	res_001 := strings.TrimPrefix(str_001, "Welcome")
	res_002 := strings.TrimPrefix(str_002, "Hello")
	fmt.Println("\nStrings after trimming:")
	fmt.Println("Result 1: ", res_001)
	fmt.Println("Result 2: ", res_002)
}
