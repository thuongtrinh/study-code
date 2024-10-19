package functions

import "fmt"

func ReturningMultipleValues() {
	fmt.Println("\n===ReturningMultipleValues ===")
	var myvar1, myvar2, myvar3 = myfunc(4, 2)
	fmt.Printf("Result is: %d", myvar1)
	fmt.Printf("\nResult is: %d", myvar2)
	fmt.Printf("\nResult is: %d", myvar3)

	// The return values are assigned into two different variables
	var area1, area2 = myfunc1(2, 4)
	fmt.Printf("\nArea of the rectangle is: %d", area1)
	fmt.Printf("\nArea of the square is: %d", area2)
}

// myfunc return 3 values of int type
func myfunc(p, q int) (int, int, int) {
	return p - q, p * q, p + q
}

// myfunc1 return 2 values of int type here, the return value name is rectangle and square
func myfunc1(u, v int) (rectangle int, square int) {
	rectangle = u * v
	square = u * u
	return
}
