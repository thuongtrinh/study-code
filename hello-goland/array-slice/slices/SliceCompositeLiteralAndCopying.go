package slices

import "fmt"

func SliceCompositeLiteralAndCopying() {
	// Slice with composite literal
	// Slice allows you to group together the values of the same type, here type of values is int
	slice := []int{23, 56, 89, 34}
	sliceStr := []string{"apple", "banana", "cherry"}
	fmt.Println("Slice int: ", slice)
	fmt.Println("Slice string: ", sliceStr)

	// Copying one Slice into another Slice
	fmt.Println("\n\n===Copying one Slice into another Slice===")
	// Creating slices
	slc1 := []int{58, 69, 40, 45, 11, 56, 67, 21, 65}
	var slc2 []int
	slc3 := make([]int, 5)
	slc4 := []int{78, 50, 67, 77}
	slc5 := []int{1, 2, 3, 4}

	fmt.Println("Before copying\nSlice_1:", slc1)
	fmt.Println("Slice_2:", slc2)
	fmt.Println("Slice_3:", slc3)
	fmt.Println("Slice_4:", slc4)

	// Copying the slices
	copy_1 := copy(slc2, slc1)
	fmt.Println("\nSlice copy(slc2, slc1), slc2:", slc2)
	fmt.Println("Slice copy(slc2, slc1), slc1:", slc1)
	fmt.Println("Total number of elements copied copy_1:", copy_1)

	copy_2 := copy(slc3, slc1)
	fmt.Println("\nSlice copy(slc3, slc1) slc3:", slc3)
	fmt.Println("Slice copy(slc3, slc1) slc1:", slc1)
	fmt.Println("Total number of elements copied copy_2:", copy_2)

	copy_3 := copy(slc4, slc1)
	fmt.Println("\nSlice copy(slc4, slc1) slc4:", slc4)
	fmt.Println("Slice copy(slc4, slc1) slc1:", slc4)
	fmt.Println("Total number of elements copied copy_3:", copy_3)

	// Don't confuse here, because in above line of code the slc4 has been copied and hence modified permanently i.e. slc 4 contains [58 69 40 45]
	copy_4 := copy(slc1, slc4)
	fmt.Println("\nSlice copy(slc1, slc4) slc1:", slc1)
	fmt.Println("Slice copy(slc1, slc4) slc4:", slc4)
	fmt.Println("Total number of elements copied copy_4:", copy_4)

	copy_5 := copy(slc1, slc5)
	fmt.Println("\nSlice copy(slc1, slc5) slc1:", slc1)
	fmt.Println("Slice copy(slc1, slc5) slc5:", slc5)
	fmt.Println("Total number of elements copied copy_4:", copy_5)

	// Copy one slice into another slice
	fmt.Println("\n===Copy one slice into another slice===")
	source := []int{1, 2, 3, 4, 5}
	destination := make([]int, len(source))
	copy(destination, source)
	fmt.Println("Source: ", source)
	fmt.Println("Destination: ", destination)

	// source slice
	fmt.Println("\n\n===Copying one Slice string===")
	slice_1 := []string{"Slices", "for", "Slices", "GFG"}
	slice_2 := make([]string, 3) // creating destination slice using make function
	fmt.Println("Before Copying\nSlice_1: ", slice_1)
	fmt.Println("Slice_2: ", slice_2)
	fmt.Println("=> Do copy(slice_2, slice_1)")
	Copy_1 := copy(slice_2, slice_1) // Copying slice_1 into slice_2 using copy function
	fmt.Println("Slice_1: ", slice_1)
	fmt.Println("Slice_2: ", slice_2)
	fmt.Println("Number of elements copied: ", Copy_1)
	Copy_2 := copy(slice_1, []string{"123abc", "gfg"}) // Copying the slice using copy function see the code clearly
	fmt.Println("\nSlice_1 : ", slice_1)
	fmt.Println("Number of elements copied:", Copy_2)
}
