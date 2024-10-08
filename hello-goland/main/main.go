package main

import (
	"fmt"
	"hello-goland/controlstatement"
	"hello-goland/fundamental"
)

func main() {
	// Here, is a valid identifier
	var a = "hello world"
	fmt.Println(a)

	var Lname = "Go Language"
	var Cname = "Keywords"
	fmt.Printf("Language name: %s", Lname)
	fmt.Printf("\nChapter name: %s", Cname)

	fundamental.MainFundamental()
	controlstatement.MainControlStatement()
}
