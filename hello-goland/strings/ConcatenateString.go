package strings

import (
	"bytes"
	"fmt"
	"strings"
)

func ConcatenateString() {
	fmt.Println("\n====Different ways to concatenate two strings====")

	// Creating and initializing strings using var keyword
	var str1 string
	str1 = "Welcome!"
	var str2 string
	str2 = "GolangsforGolangs"

	// Concatenating strings Using + operator
	fmt.Println("New string 1: ", str1+str2)

	// Creating and initializing strings. Using shorthand declaration
	str3 := "Golangs"
	str4 := "Golangs"

	// Concatenating strings. Using + operator
	result := str3 + "for" + str4
	fmt.Println("New string 2: ", result)

	// Creating and initializing strings. Using bytes.Buffer with WriteString() function
	fmt.Println("\nEx2: Using bytes.Buffer")
	var b bytes.Buffer
	b.WriteString("G")
	b.WriteString("e")
	b.WriteString("e")
	b.WriteString("k")
	b.WriteString("s")
	fmt.Println("String: ", b.String())

	b.WriteString("f")
	b.WriteString("o")
	b.WriteString("r")
	b.WriteString("G")
	b.WriteString("e")
	b.WriteString("e")
	b.WriteString("k")
	b.WriteString("s")
	fmt.Println("String: ", b.String())

	fmt.Println("\nEx3: Using Sprintf")
	str01 := "Tutorial"
	str02 := "of"
	str03 := "Go"
	str04 := "Language"
	// Concatenating strings using Sprintf() function
	result01 := fmt.Sprintf("%s%s%s%s", str01, str02, str03, str04)
	fmt.Println(result01)

	fmt.Println("\nEx4: Using += operator or String append")
	str001 := "Welcome"
	str002 := "GolangsforGolangs"
	str001 += str002 // Using += operator
	fmt.Println("String: ", str001)
	str001 += "This is the tutorial of Go language"
	fmt.Println("String: ", str001)
	str002 += "Portal"
	fmt.Println("String: ", str002)

	// Concatenating the elements present in the slice. Using join() function
	fmt.Println("\nEx5: Using Join() function")
	myslice := []string{"Welcome", "To", "GolangsforGolangs", "Portal"} // Creating and initializing slice of string
	result02 := strings.Join(myslice, "-")
	fmt.Println(result02)

	// Creating and initializing strings. Using strings.Builder with WriteString() function
	fmt.Println("\nEx6: Using strings.Builder")
	var str strings.Builder
	str.WriteString("Welcome")
	fmt.Println("String: ", str.String())
	str.WriteString(" to")
	str.WriteString(" GolangsforGolangs!")
	fmt.Println("String: ", str.String())
}
