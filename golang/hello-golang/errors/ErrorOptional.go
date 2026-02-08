package errors

import "fmt"

func ErrorOptional() {
	fmt.Println("\n===ErrorOptional===")

	result, err := divide2(4, 2)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Result:", result)
	}

	result, err = divide(4, 0)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Result:", result)
	}
}

type MyError struct {
	Msg string
}

func (e *MyError) Error() string {
	return e.Msg
}

func divide2(a, b float64) (float64, error) {
	if b == 0 {
		return 0, &MyError{Msg: "division by zero"}
	}
	return a / b, nil
}
