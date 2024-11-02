package errors

import "fmt"

func HandleByErrorf() {
	fmt.Println("\n===Handle By Errorf===")

	result, err := divide3(4, 2)
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

func divide3(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("cannot divide %f by zero", a)
	}
	return a / b, nil
}
