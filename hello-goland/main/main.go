package main

import (
	"fmt"
	variable "hello-goland/fundamental"
)

func main() {
	// Here, a is a valid identifier
	var a = "hello world"
	fmt.Println(a)

	var Lname = "Go Language"
	var Cname = "Keywords"
	fmt.Printf("Language name: %s", Lname)
	fmt.Printf("\nChapter name: %s", Cname)

	variable.MainFundamental()
}
