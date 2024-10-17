package strings

import (
	"fmt"
	"strings"
)

func SplittingString() {
	fmt.Println("\n====Splitting a String in Golang====")

	// Creating and initializing the strings
	str1 := "Welcome, to the, online portal, of GolangforGolang"
	str2 := "My dog name is Dollar"
	str3 := "I like to play Ludo"
	fmt.Println("String 1: ", str1)
	fmt.Println("String 2: ", str2)
	fmt.Println("String 3: ", str3)

	// Splitting the given strings. Using Split() function
	res1 := strings.Split(str1, ",")
	res2 := strings.Split(str2, "")
	res3 := strings.Split(str3, "!")
	res4 := strings.Split("", "GolangforGolang, golang")
	fmt.Println("\nResult 1: ", res1)
	fmt.Println("Result 2: ", res2)
	fmt.Println("Result 3: ", res3)
	fmt.Println("Result 4: ", res4)

	fmt.Println("\nEx2: SplitAfter")
	str01 := "Welcome, to the, online portal, of GolangforGolang"
	str02 := "My dog name is Dollar"
	str03 := "I like to play Ludo"
	fmt.Println("String 1: ", str01)
	fmt.Println("String 2: ", str02)
	fmt.Println("String 3: ", str03)

	// Splitting the given strings. Using SplitAfter() function
	res01 := strings.SplitAfter(str01, ",")
	res02 := strings.SplitAfter(str02, "")
	res03 := strings.SplitAfter(str03, "!")
	res04 := strings.SplitAfter("", "GolangforGolang, geeks")
	fmt.Println("\nResult 1: ", res01)
	fmt.Println("Result 2: ", res02)
	fmt.Println("Result 3: ", res03)
	fmt.Println("Result 4: ", res04)

	fmt.Println("\nEx3: SplitAfterN")
	str001 := "Welcome, to the, online portal, of GolangforGolang"
	str002 := "My dog name is Dollar"
	str003 := "I like to play Ludo"
	fmt.Println("String 1: ", str001)
	fmt.Println("String 2: ", str002)
	fmt.Println("String 3: ", str003)

	// Splitting the given strings. Using SplitAfterN() function
	res001 := strings.SplitAfterN(str001, ",", 2)
	res002 := strings.SplitAfterN(str002, "", 4)
	res003 := strings.SplitAfterN(str003, "!", 1)
	res004 := strings.SplitAfterN("", "GolangforGolang, geeks", 3)
	fmt.Println("\nResult 1: ", res001)
	fmt.Println("Result 2: ", res002)
	fmt.Println("Result 3: ", res003)
	fmt.Println("Result 4: ", res004)
}
