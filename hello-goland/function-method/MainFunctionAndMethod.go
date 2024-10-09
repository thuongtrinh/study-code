package function_method

import (
	"fmt"
	"hello-goland/function-method/functions"
	"hello-goland/function-method/methods"
)

func MainFunctionAndMethod() {
	fmt.Println("\n\n==@@@==MainFunctionAndMethod==@@@==")
	functions.FunctionInGo()
	functions.VariadicFunction()
	functions.Anonymous()
	functions.InitFunction()
	functions.FunctionArgument()
	functions.ReturningMultipleValues()
	methods.DeferKeyword()
	methods.MultipleDefer()
	methods.MethodStruct()
	methods.MethodNonStruct()
	methods.MethodPointer()
	methods.MethodAcceptBothPointerAndValue()
	methods.MethodSameName()
}
