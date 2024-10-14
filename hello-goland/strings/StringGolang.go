package strings

import (
	"fmt"
	"unicode/utf8"
)

func StringGolang() {
	fmt.Println("\n====Strings in Golang====")

	My_value_1 := "Welcome to GolangforGolang"
	var My_value_2 string
	fmt.Println("String 2: ", My_value_2) // String can be empty, but they are not nil.
	My_value_2 = "GolangforGolang"
	fmt.Println("String 1: ", My_value_1)
	fmt.Println("String 2: ", My_value_2)

	fmt.Println("\nEx2: String Literals")
	My_value_3 := "Welcome!\nGolang" // Adding escape character
	My_value_4 := `Hello!Golang`     // Using backticks
	My_value_5 := `Hello!\nGolang`   // Adding escape character in raw literals
	fmt.Println("String 3: ", My_value_3)
	fmt.Println("String 4: ", My_value_4)
	fmt.Println("String 5: ", My_value_5)

	fmt.Println("\nEx3:Strings are immutable\n")
	mystr := "Welcome to Golang"
	fmt.Println("String:", mystr)
	/*
		// if you trying to change the value of the string then the compiler will throw an error, i.e, cannot assign to mystr[1]
		mystr[1] = 'G'
		fmt.Println("String:", mystr)
	*/

	fmt.Println("\nEx4: Iterate over a string")
	for index, s := range "GolangforGolang" { // String as a range in the for loop
		fmt.Printf("The index number of %c is %d\n", s, index)
	}

	fmt.Println("\nEx5: Access the individual byte of the string")
	str := "Welcome to GolangforGolang"
	for c := 0; c < len(str); c++ { // Accessing the bytes of the given string
		fmt.Printf("Character = %c Bytes = %x\n", str[c], str[c])
	}

	fmt.Println("\nEx6: Create a string form the slice")
	myslice1 := []byte{0x47, 0x65, 0x65, 0x6b, 0x73} // Creating and initializing a slice of byte
	mystring1 := string(myslice1)                    // Creating a string from the slice
	fmt.Println("String 1: ", mystring1)
	myslice2 := []rune{0x0047, 0x0065, 0x0065, 0x006b, 0x0073} // Creating and initializing a slice of rune
	mystring2 := string(myslice2)
	fmt.Println("String 2: ", mystring2)

	fmt.Println("\nEx7: Find the length of the string")
	mystr01 := "Welcome to Golang ??????"
	length1 := len(mystr01)                    // Using len() function
	length2 := utf8.RuneCountInString(mystr01) // Using RuneCountInString() function
	fmt.Println("string:", mystr01)
	fmt.Println("Length 1:", length1)
	fmt.Println("Length 2:", length2)
}
