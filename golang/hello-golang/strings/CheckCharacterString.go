package strings

import (
	"fmt"
	"strings"
)

func CheckCharacterString() {
	fmt.Println("\n====Check if the given characters are present in String====")

	// Checking the string present or not. Using Contains() function
	str1 := "Welcome to Golang"
	str2 := "Here! we learn about go strings"
	fmt.Println("Original strings")
	fmt.Println("String 1: ", str1)
	fmt.Println("String 2: ", str2)
	res1 := strings.Contains(str1, "Golang")
	res2 := strings.Contains(str2, "GFG")
	fmt.Println("\nResult 1: ", res1)
	fmt.Println("Result 2: ", res2)

	// Checking the string present or not. Using ContainsAny() function
	fmt.Println("\nEx2: ContainsAny")
	str01 := "Welcome to Golang for Golang"
	str02 := "Here! we learn about go strings"

	res_1 := strings.ContainsAny(str01, "Golang")
	res_2 := strings.ContainsAny(str02, "GFG")
	res3 := strings.ContainsAny("GolangsforGolangs", "G & f")
	res4 := strings.ContainsAny("GolangsforGolangs", "u | e")
	res5 := strings.ContainsAny(" ", " ")
	res6 := strings.ContainsAny("GolangsforGolangs", " ")

	fmt.Println("Result 1: ", res_1)
	fmt.Println("Result 2: ", res_2)
	fmt.Println("Result 3: ", res3)
	fmt.Println("Result 4: ", res4)
	fmt.Println("Result 5: ", res5)
	fmt.Println("Result 6: ", res6)
}
