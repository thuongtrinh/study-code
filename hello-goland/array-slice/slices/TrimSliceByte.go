package slices

import (
	"bytes"
	"fmt"
)

func TrimSliceByte() {
	fmt.Println("\n====Trim a slice of bytes====")

	// Creating and initializing the slice of bytes. Using shorthand declaration
	slice_1 := []byte{'!', '!', 'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G', 'e', 'e', 'k', 's', '#', '#'}
	slice_2 := []byte{'*', '*', 'A', 'p', 'p', 'l', 'e', '^', '^'}
	slice_3 := []byte{'%', 'g', 'e', 'e', 'k', 's', '%'}
	fmt.Println("Original Slice:")
	fmt.Printf("Slice 1: %s", slice_1)
	fmt.Printf("\nSlice 2: %s", slice_2)
	fmt.Printf("\nSlice 3: %s", slice_3)

	// Trimming specified leading and trailing Unicodes points from the given slice of bytes. Using Trim function
	res1 := bytes.Trim(slice_1, "!#")
	res2 := bytes.Trim(slice_2, "*^")
	res3 := bytes.Trim(slice_3, "@")
	fmt.Printf("\nNew Slice:")
	fmt.Printf("\nSlice 1: %s", res1)
	fmt.Printf("\nSlice 2: %s", res2)
	fmt.Printf("\nSlice 3: %s", res3)

	// Creating and trimming the slice of bytes. Using Trim function
	fmt.Printf("\n\nEx2:")
	res01 := bytes.Trim([]byte("****Welcome to GeeksforGeeks****"), "*")
	res02 := bytes.Trim([]byte("!!!!Learning how to trim a slice of bytes@@@@"), "!@")
	res03 := bytes.Trim([]byte("^^Geek&&"), "$")
	fmt.Printf("\nFinal Slice:")
	fmt.Printf("\nSlice 1: %s", res01)
	fmt.Printf("\nSlice 2: %s", res02)
	fmt.Printf("\nSlice 3: %s", res03)

	fmt.Printf("\n\nEx3: TrimSpace\n")
	byteSlice := []byte("  Hello, World!  ")
	trimmed := bytes.TrimSpace(byteSlice)
	fmt.Println(string(trimmed)) // "Hello, World!"
}
