package errors

import "fmt"

func MainErrors() {
	fmt.Println("\n\n==@@@==MainErrors==@@@==")
	HandleError()
	ErrorOptional()
	HandleByErrorf()
	ErrorAndDefer()
	DeferCloseFile()
	DeferCreateLog()
	DeferRecoverPanic()
}
