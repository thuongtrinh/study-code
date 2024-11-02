package strings

import (
	"fmt"
	"strings"
)

func FindingIndexString() {
	fmt.Println("\n====Finding the index value of specified string====")

	str1 := "Welcome to the online portal of GolangforGolang"
	str2 := "My dog name is Dollar"
	str3 := "I like to play Ludo"

	fmt.Println("String 1: ", str1)
	fmt.Println("String 2: ", str2)
	fmt.Println("String 3: ", str3)

	// Finding the index value of the given strings. Using Index() function
	res1 := strings.Index(str1, "Golang")
	res2 := strings.Index(str2, "do")
	res3 := strings.Index(str3, "chess")
	res4 := strings.Index("GolangforGolang, golang", "ks")

	fmt.Println("\nIndex values:")
	fmt.Println("Result 1: ", res1)
	fmt.Println("Result 2: ", res2)
	fmt.Println("Result 3: ", res3)
	fmt.Println("Result 4: ", res4)

	fmt.Println("\nEx2: IndexAny")
	str01 := "Welcome to the online portal of GolangforGolang"
	str02 := "My dog name is Dollar"
	str03 := "I like to play Ludo"
	fmt.Println("String 1: ", str01)
	fmt.Println("String 2: ", str02)
	fmt.Println("String 3: ", str03)

	// Finding the index value of the given strings. Using IndexAny() function
	res01 := strings.IndexAny(str1, "G")
	res02 := strings.IndexAny(str2, "do")
	res03 := strings.IndexAny(str3, "lqxa")
	res04 := strings.IndexAny("GolangforGolang, golang", "uywq")
	fmt.Println("\nIndex values:")
	fmt.Println("Result 1: ", res01)
	fmt.Println("Result 2: ", res02)
	fmt.Println("Result 3: ", res03)
	fmt.Println("Result 4: ", res04)

	fmt.Println("\nEx3: IndexByte")
	str001 := "Welcome to the online portal of GolangforGolang"
	str002 := "My dog name is Dollar"
	str003 := "I like to play Ludo"
	fmt.Println("String 1: ", str001)
	fmt.Println("String 2: ", str002)
	fmt.Println("String 3: ", str003)

	// Finding the index value of the given bytes. Using IndexByte() function
	res001 := strings.IndexByte(str001, 'c')
	res002 := strings.IndexByte(str002, 'o')
	res003 := strings.IndexByte(str003, 'q')
	res004 := strings.IndexByte("GolangforGolang, geeks", 'G')

	fmt.Println("\nIndex values:")
	fmt.Println("Result 1: ", res001)
	fmt.Println("Result 2: ", res002)
	fmt.Println("Result 3: ", res003)
	fmt.Println("Result 4: ", res004)
}
