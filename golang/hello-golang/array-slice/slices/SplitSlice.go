package slices

import (
	"bytes"
	"fmt"
)

func SplitSlice() {
	fmt.Println("\n====Split a slice of bytes====")

	// Creating and initializing the slice of bytes. Using shorthand declaration
	slice_1 := []byte{'!', '!', 'G', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'G', 'e', 'e', 'k', 's', '#', '#'}
	slice_2 := []byte{'A', 'p', 'p', 'l', 'e'}
	slice_3 := []byte{'%', 'g', '%', 'e', '%', 'e', '%', 'k', '%', 's', '%'}
	fmt.Println("Original Slice:")
	fmt.Printf("Slice 1: %s", slice_1)
	fmt.Printf("\nSlice 2: %s", slice_2)
	fmt.Printf("\nSlice 3: %s", slice_3)
	res1 := bytes.Split(slice_1, []byte("eek")) // Splitting the slice of bytes. Using Split function
	res2 := bytes.Split(slice_2, []byte(""))
	res3 := bytes.Split(slice_3, []byte("%"))
	fmt.Printf("\n\nAfter splitting:")
	fmt.Printf("\nSlice 1: %s", res1)
	fmt.Printf("\nSlice 2: %s", res2)
	fmt.Printf("\nSlice 3: %s", res3)

	// Creating and Splitting the slice of bytes. Using Split function
	fmt.Println("\n\nEx2:")
	res01 := bytes.Split([]byte("****Welcome, to, GeeksforGeeks****"), []byte(","))
	res02 := bytes.Split([]byte("Learning x how x to x trim x a x slice of bytes"), []byte("x"))
	res03 := bytes.Split([]byte("GeeksforGeeks, Geek"), []byte(""))
	res04 := bytes.Split([]byte(""), []byte(","))
	fmt.Printf("Final Value:")
	fmt.Printf("\nSlice 1: %s", res01)
	fmt.Printf("\nSlice 2: %s", res02)
	fmt.Printf("\nSlice 3: %s", res03)
	fmt.Printf("\nSlice 4: %s", res04)
}
