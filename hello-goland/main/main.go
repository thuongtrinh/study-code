package main

import (
	"fmt"
	"hello-goland/constant"
	data_type "hello-goland/data-type"
	"hello-goland/variable"
)

func main() {
	// Here, a is a valid identifier
	var a = "hello world"
	fmt.Println(a)

	var Lname = "Go Language"
	var Cname = "Keywords"
	fmt.Printf("Language name: %s", Lname)
	fmt.Printf("\nChapter name: %s", Cname)

	data_type.MainDataType()
	variable.MainVariable()
	constant.MainConstant()
}
