package function_method

import (
	"fmt"
	"hello-golang/function-method/functions"
	"hello-golang/function-method/methods"
)

func MainFunctionAndMethod() {
	fmt.Println("\n\n==@@@==MainFunctionAndMethod==@@@==")
	functions.FunctionInGo()
	functions.VariadicFunction()
	functions.Anonymous()
	functions.InitFunction()
	functions.FunctionArgument()
	functions.ReturningMultipleValues()
	functions.FunctionConstructor()
	methods.DeferKeyword()
	methods.MultipleDefer()
	methods.MethodStruct()
	methods.MethodNonStruct()
	methods.MethodPointer()
	methods.MethodAcceptBothPointerAndValue()
	methods.MethodSameName()
}
