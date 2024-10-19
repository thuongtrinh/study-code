package slices

import (
	"bytes"
	"fmt"
)

func CheckEqualitySlice() {
	fmt.Println("\n====Check equality of slices of bytes ====")
	slice1 := []byte{1, 2, 3, 4, 5}
	slice2 := []byte{1, 2, 3, 4, 5}
	slice3 := []byte{5, 4, 3, 2, 1}
	fmt.Println("slice1:", slice1)
	fmt.Println("slice2:", slice2)
	fmt.Println("slice2:", slice3)
	fmt.Println(bytes.Equal(slice1, slice2)) // true
	fmt.Println(bytes.Equal(slice1, slice3)) // false

	// Creating and initializing slices of bytes Using shorthand declaration
	slice_1 := []byte{'A', 'N', 'M', 'A', 'P', 'A', 'A', 'W'}
	slice_2 := []byte{'A', 'N', 'M', 'A', 'P', 'A', 'A', 'W'}
	res := bytes.Equal(slice_1, slice_2) // Checking the equality of the slices Using Equal function
	if res == true {
		fmt.Println("\nEx2:\nSlice_1 is equal to Slice_2")
	} else {
		fmt.Println("Slice_1 is not equal to Slice_2")
	}

	fmt.Println("\nEx3:\nSlice_1 is equal to Slice_2")
	slice_01 := []byte{'A', 'N', 'M', 'A', 'P', 'A', 'A', 'W'}
	slice_02 := []byte{'g', 'e', 'e', 'k', 's'}
	slice_3 := []byte{'A', 'N', 'M', 'A', 'P', 'A', 'A', 'W'}
	// Checking the equality of the slices Using Equal function
	res1 := bytes.Equal(slice_01, slice_02)
	res2 := bytes.Equal(slice_01, slice_3)
	res3 := bytes.Equal(slice_02, slice_3)
	res4 := bytes.Equal([]byte("GforG"), []byte("GforG"))
	res5 := bytes.Equal([]byte("gfg"), []byte("GFG"))
	res6 := bytes.Equal(slice_01, []byte("P"))
	fmt.Println("Result 1:", res1)
	fmt.Println("Result 2:", res2)
	fmt.Println("Result 3:", res3)
	fmt.Println("Result 4:", res4)
	fmt.Println("Result 5:", res5)
	fmt.Println("Result 6:", res6)
}
