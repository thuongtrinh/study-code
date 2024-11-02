package slices

import (
	"fmt"
	"sort"
)

func SortSliceInts() {
	fmt.Println("\n====Sort a slice of ints====")
	intSlice := []int{5, 2, 6, 3, 1, 4}
	sort.Ints(intSlice)
	fmt.Println(intSlice)

	// Creating and initializing slices Using shorthand declaration
	scl1 := []int{400, 600, 100, 300, 500, 200, 900}
	scl2 := []int{-23, 567, -34, 67, 0, 12, -5}
	fmt.Println("\nEx2:\nSlices(Before):")
	fmt.Println("Slice 1: ", scl1)
	fmt.Println("Slice 2: ", scl2)
	sort.Ints(scl1) // Sorting the slice of ints Using Ints function
	sort.Ints(scl2)
	fmt.Println("\nSlices(After):")
	fmt.Println("Slice 1 : ", scl1)
	fmt.Println("Slice 2 : ", scl2)

	fmt.Println("\n====IntsAreSorted====")
	// Creating and initializing slices. Using shorthand declaration
	scl_1 := []int{100, 200, 300, 400, 500, 600, 700}
	scl_2 := []int{-23, 567, -34, 67, 0, 12, -5}
	fmt.Println("Slices:")
	fmt.Println("Slice 1: ", scl_1)
	fmt.Println("Slice 2: ", scl_2)

	// Checking the slice is in sorted form or not. Using IntsAreSorted function
	res1 := sort.IntsAreSorted(scl_1)
	res2 := sort.IntsAreSorted(scl_2)
	fmt.Println("\nResult:")
	fmt.Println("Is Slice 1 is sorted?: ", res1)
	fmt.Println("Is Slice 2 is sorted?: ", res2)
}
