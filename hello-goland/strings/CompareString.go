package strings

import (
	"fmt"
	"strings"
)

func CompareString() {
	fmt.Println("\n====Different ways to compare Strings====")

	str1 := "Golangs"
	str2 := "Golang"
	str3 := "GolangsforGolangs"
	str4 := "Golangs"

	result1 := str1 == str2 // Checking the string are equal or not using == operator
	result2 := str2 == str3
	result3 := str3 == str4
	result4 := str1 == str4
	fmt.Println("Result 1: ", result1)
	fmt.Println("Result 2: ", result2)
	fmt.Println("Result 3: ", result3)
	fmt.Println("Result 4: ", result4)

	result5 := str1 != str2 // Checking the string are not equal using != operator
	result6 := str2 != str3
	result7 := str3 != str4
	result8 := str1 != str4
	fmt.Println("\nResult 5: ", result5)
	fmt.Println("Result 6: ", result6)
	fmt.Println("Result 7: ", result7)
	fmt.Println("Result 8: ", result8)

	// Creating and initializing slice of string
	fmt.Println("\nEx2: Comparison operator with strings")
	myslice := []string{"Geeks", "Geeks", "gfg", "GFG", "for"}
	fmt.Println("Slice: ", myslice)
	result01 := "GFG" > "Geeks"
	fmt.Println("Result 1: ", result01)
	result02 := "GFG" < "Geeks"
	fmt.Println("Result 2: ", result02)
	result03 := "Geeks" >= "for"
	fmt.Println("Result 3: ", result03)
	result04 := "Geeks" <= "for"
	fmt.Println("Result 4: ", result04)
	result05 := "Geeks" == "Geeks"
	fmt.Println("Result 5: ", result05)
	result06 := "Geeks" != "for"
	fmt.Println("Result 6: ", result06)

	fmt.Println("\nEx3: Using Compare() method")
	fmt.Println(strings.Compare("gfg", "Geeks"))
	fmt.Println(strings.Compare("GeeksforGeeks", "GeeksforGeeks"))
	fmt.Println(strings.Compare("Geeks", " GFG"))
	fmt.Println(strings.Compare("GeeKS", "GeeKs"))
}
