package slices

import (
	"bytes"
	"fmt"
)

func CompareTwoSlices() {
	fmt.Println("\n====Compare two slices of bytes====")

	fmt.Println("\nEx1:")
	slice_1 := []byte{'G', 'E', 'E', 'K', 'S'}
	slice_2 := []byte{'G', 'E', 'e', 'K', 'S'}
	res := bytes.Compare(slice_1, slice_2) // Comparing slice Using Compare function
	if res == 0 {
		fmt.Println("!..Slices are equal..!")
	} else {
		fmt.Println("!..Slice are not equal..!")
	}

	// Creating and initializing slices of bytes Using shorthand declaration
	fmt.Println("\nEx3:")
	slice_01 := []byte{'A', 'N', 'M', 'O', 'P', 'Q'}
	slice_02 := []byte{'a', 'g', 't', 'e', 'q', 'm'}
	slice_3 := []byte{'A', 'N', 'M', 'O', 'P', 'Q'}
	slice_4 := []byte{'A', 'n', 'M', 'o', 'p', 'Q'}

	// Displaying slices
	fmt.Println("Slice 1: ", slice_01)
	fmt.Println("Slice 2: ", slice_02)
	fmt.Println("Slice 3: ", slice_3)
	fmt.Println("Slice 4: ", slice_4)

	// Comparing slices Using Compare function
	res1 := bytes.Compare(slice_01, slice_02)
	res2 := bytes.Compare(slice_01, slice_3)
	res3 := bytes.Compare(slice_01, slice_4)
	res4 := bytes.Compare(slice_02, slice_3)
	res5 := bytes.Compare(slice_02, slice_4)
	res6 := bytes.Compare(slice_02, slice_01)
	res7 := bytes.Compare(slice_3, slice_01)
	res8 := bytes.Compare(slice_3, slice_02)
	res9 := bytes.Compare(slice_3, slice_4)
	res10 := bytes.Compare(slice_4, slice_01)
	res11 := bytes.Compare(slice_4, slice_02)
	res12 := bytes.Compare(slice_4, slice_3)
	res13 := bytes.Compare(slice_4, slice_4)

	// Displaying results
	fmt.Println("\nResult 1, Compare(1,2):", res1)
	fmt.Println("Result 2, Compare(1,3):", res2)
	fmt.Println("Result 3, Compare(1,4):", res3)
	fmt.Println("Result 4, Compare(2,3):", res4)
	fmt.Println("Result 5, Compare(2,4):", res5)
	fmt.Println("Result 6, Compare(2,1):", res6)
	fmt.Println("Result 7, Compare(3,1):", res7)
	fmt.Println("Result 8, Compare(3,2):", res8)
	fmt.Println("Result 9, Compare(3,4):", res9)
	fmt.Println("Result 10, Compare(4,1):", res10)
	fmt.Println("Result 11, Compare(4,2):", res11)
	fmt.Println("Result 12, Compare(4,3):", res12)
	fmt.Println("Result 13, Compare(4,4):", res13)
}
