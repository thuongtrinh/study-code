package main

import (
	"fmt"
	array_slice "hello-golang/array-slice"
	"hello-golang/concurrency"
	"hello-golang/controlstatement"
	"hello-golang/errors"
	function_method "hello-golang/function-method"
	"hello-golang/fundamental"
	"hello-golang/interfaces"
	"hello-golang/pointers"
	"hello-golang/strings"
	"hello-golang/structure"
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
	errors.MainErrors()
}
