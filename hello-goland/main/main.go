package main

import (
	"fmt"
	"hello-goland/controlstatement"
	function_method "hello-goland/function-method"
	"hello-goland/fundamental"
	"hello-goland/structure"
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
	function_method.MainFunctionAndMethod()
	structure.MainStructure()
}
