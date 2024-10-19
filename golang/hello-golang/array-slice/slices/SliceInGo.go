package slices

import (
	"fmt"
	"reflect"
	"sort"
)

func SliceInGo() {
	fmt.Println("\n\n====Slices in Golang====")

	// create a slice in Go
	array := [5]int{1, 2, 3, 4, 5}
	slice := array[1:4]
	fmt.Println("Array: ", array)
	fmt.Println("Create a Slice: ", slice)

	// add elements to a slice
	slice_append := []int{1, 2, 3}
	slice_append = append(slice_append, 4, 5, 6)
	fmt.Println("\nSlice append: ", slice_append)

	// Components of Slice
	arr := [7]string{"This", "is", "the", "tutorial", "of", "Go", "language"}
	fmt.Println("\nComponents of Slice\nArray:", arr)
	myslice := arr[1:6]
	fmt.Println("Slice:", myslice)
	fmt.Printf("Length of the slice: %d", len(myslice))
	fmt.Printf("\nCapacity of the slice: %d", cap(myslice))

	// Using slice literal
	var my_slice_1 = [33]string{"Slice", "for", "Slice"}
	fmt.Println("\n\nUsing slice literal\nMy Slice 1:", my_slice_1)
	my_slice_2 := []int{12, 45, 67, 56, 43, 34, 45}
	fmt.Println("My Slice 2:", my_slice_2)

	// Using an Array
	arr1 := [4]string{"Slice", "for", "Slice", "GFG"}
	var my_slice_3 = arr1[1:2]
	my_slice_4 := arr1[0:]
	my_slice_5 := arr1[:2]
	my_slice_6 := arr1[:]
	fmt.Println("\nUsing an Array\nMy Array: ", arr1)
	fmt.Println("My Slice [1:2]: ", my_slice_3)
	fmt.Println("My Slice [0:]: ", my_slice_4)
	fmt.Println("My Slice [:2]: ", my_slice_5)
	fmt.Println("My Slice [:]: ", my_slice_6)

	// Using already Existing Slice
	oRignAl_slice := []int{90, 60, 40, 50, 34, 49, 30}
	var my_slice_7 = oRignAl_slice[1:5] // Creating slices from the given slice
	my_slice_8 := oRignAl_slice[0:]
	my_slice_9 := oRignAl_slice[:6]
	my_slice_10 := oRignAl_slice[:]
	my_slice_11 := my_slice_9[2:4]
	fmt.Println("\nUsing already Existing Slice\nOriginal Slice:", oRignAl_slice)
	fmt.Println("New Slice from oRignAl_slice[1:5]:", my_slice_7)
	fmt.Println("New Slice from oRignAl_slice[0:]:", my_slice_8)
	fmt.Println("New Slice from oRignAl_slice[:6]:", my_slice_9)
	fmt.Println("New Slice from oRignAl_slice[:]:", my_slice_10)
	fmt.Println("New Slice from my_slice_9[2:4]:", my_slice_11)

	// Using make function
	fmt.Println("\nUsing make function")
	var my_slice_12 = make([]int, 4, 7)
	fmt.Printf("Slice 1 = %v, length = %d, capacity = %d\n", my_slice_12, len(my_slice_12), cap(my_slice_12))
	var my_slice_13 = make([]int, 7) // Creating another array of size 7 and return the reference of the slice Using make function
	fmt.Printf("Slice 2 = %v, length = %d, capacity = %d\n", my_slice_13, len(my_slice_13), cap(my_slice_13))

	// Iterate over a slice using for loop
	fmt.Println("\nIterate over a slice using for loop")
	myslice_loop := []string{"This", "is", "the", "tutorial", "of", "Go", "language"}
	for e := 0; e < len(myslice_loop); e++ {
		fmt.Println(myslice_loop[e])
	}

	// Iterate slice using range in for loop
	fmt.Println("\nIterate slice using range in for loop")
	for index, ele := range myslice_loop {
		fmt.Printf("Index = %d and element = %s\n", index, ele)
	}

	// Using a blank identifier in for loop
	fmt.Println("\nUsing a blank identifier in for loop")
	mysliceblank := []string{"This", "is", "the", "tutorial", "of", "Go", "language"}
	for _, ele := range mysliceblank { // Iterate slice using range in for loop without index
		fmt.Printf("Element = %s\n", ele)
	}

	// Important points about Slice
	fmt.Println("\nZero value slice")
	var myslicezero []string // Creating a zero value slice
	fmt.Printf("Length = %d\n", len(myslicezero))
	fmt.Printf("Capacity = %d ", cap(myslicezero))

	// Modifying Slice
	fmt.Println("\nModifying  slice")
	arr_001 := [6]int{55, 66, 77, 88, 99, 22}
	slc_001 := arr_001[0:4]
	fmt.Println("Original_Array: ", arr_001)
	fmt.Println("Original_Slice: ", slc_001)
	slc_001[0] = 100 // modification
	slc_001[1] = 1000
	slc_001[2] = 1000
	fmt.Println("New_Array: ", arr_001)
	fmt.Println("New_Slice: ", slc_001)

	// Comparison of Slice:
	fmt.Println("\nComparison of slice")
	s1 := []int{12, 34, 56}
	var s2 []int
	s3 := []int{23, 45, 66}
	fmt.Println(s1 == nil) // Checking if the given slice is nil or not
	fmt.Println(s2 == nil)
	//fmt.Println(s1 == s3)  // Compare two slices with the help of == operator then it will give you an error
	fmt.Println(reflect.DeepEqual(s1, s3)) // use DeepEqual or loop

	// Multi-Dimensional Slice
	fmt.Println("\nMulti-Dimensional Slice")
	s4 := [][]int{{12, 34},
		{56, 47},
		{29, 40},
		{46, 78},
	}
	fmt.Println("Slice 4 : ", s4)
	s5 := [][]string{ // Creating multi-dimensional slice
		[]string{"Slices", "for"},
		[]string{"Slices", "GFG"},
		[]string{"gfg", "slice"},
	}
	fmt.Println("Slice 5 : ", s5)

	// Sorting of Slice
	fmt.Println("\nSorting of Slice")
	slc1 := []string{"Python", "Java", "C#", "Go", "Ruby"}
	slc2 := []int{45, 67, 23, 90, 33, 21, 56, 78, 89}
	fmt.Println("Before sorting:")
	fmt.Println("Slice 1: ", slc1)
	fmt.Println("Slice 2: ", slc2)
	sort.Strings(slc1) // Performing sort operation on the slice using sort function
	sort.Ints(slc2)
	fmt.Println("\nAfter sorting:")
	fmt.Println("Slice 1: ", slc1)
	fmt.Println("Slice 2: ", slc2)
}
