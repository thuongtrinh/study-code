package main

import (
	"fmt"
	array_slice "hello-goland/array-slice"
	"hello-goland/concurrency"
	"hello-goland/controlstatement"
	function_method "hello-goland/function-method"
	"hello-goland/fundamental"
	"hello-goland/interfaces"
	"hello-goland/pointers"
	"hello-goland/strings"
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
	array_slice.MainArrayAndSlice()
	strings.MainString()
	pointers.MainPointer()
	interfaces.MainInterface()
	concurrency.MainConcurrency()
}
