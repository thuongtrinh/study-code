package pointers

import "fmt"

func ReturningPointerFunction() {
	fmt.Println("\n====Returning Pointer from a Function====")
	n := rpf()
	fmt.Println("Value of n is: ", *n)

	// Pointer to an Array as Function Argument
	arr := [5]int{78, 89, 45, 56, 14}
	updateArray(&arr) // passing pointer to an array to function updateArray
	fmt.Println(arr)  // array after updating

	// passing slice to the function updateSlice
	s := [5]int{78, 89, 45, 56, 14}
	updateSlice(s[:])
	fmt.Println(s)
}

// defining function having integer pointer as return type
func rpf() *int {
	lv := 100
	return &lv
}

func updateArray(funarr *[5]int) {
	// updating the array value at specified index
	(*funarr)[4] = 750
	// you can also write the above line of code funarr[4] = 750
}

func updateSlice(funarr []int) {
	// updating the value at specified index
	funarr[4] = 850
}
