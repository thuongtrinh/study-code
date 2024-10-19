package arrays

import "fmt"

func CopyingArray() {
	fmt.Println("\n\n====Copying an Array into Another Array in Golang====")

	// Copy by value then the changes original array do not reflect in the copy of that array
	cp_arr1 := [5]string{"Scala", "Perl", "Java", "Python", "Go"}
	cp_arr2 := cp_arr1 // Copying elements are passed by value
	fmt.Println("Array_1: ", cp_arr1)
	fmt.Println("Array_2:", cp_arr2)
	cp_arr1[0] = "C++"
	fmt.Println("\nArray_1: ", cp_arr1)
	fmt.Println("Array_2: ", cp_arr2)

	// Copy by reference then the changes made in original array will reflect in the copy of that array
	cp_arr3 := [6]int{12, 456, 67, 65, 34, 34}
	cp_arr4 := &cp_arr3 // Copying elements are passed by reference
	fmt.Println("\nArray_3: ", cp_arr3)
	fmt.Println("Array_4:", *cp_arr4)
	cp_arr3[5] = 1000000
	fmt.Println("\nArray_3: ", cp_arr3)
	fmt.Println("Array_4:", *cp_arr4)

	// Using a loop
	originalArray := []int{1, 2, 3, 4, 5}
	copyArray := make([]int, len(originalArray))
	for i, value := range originalArray {
		copyArray[i] = value
	}
	fmt.Println("\nOriginal Array: ", originalArray)
	fmt.Println("Copy Array: ", copyArray)

	//  Using the copy function
	originalArray1 := []int{1, 2, 3, 4, 5}
	copyArray1 := make([]int, len(originalArray1))
	copy(copyArray1, originalArray1)
	fmt.Println("\nOriginal Array: ", originalArray1)
	fmt.Println("Copy Array: ", copyArray1)

	// Using the append function
	originalArray2 := []int{1, 2, 3, 4, 5}
	copyArray2 := make([]int, 0, len(originalArray2))
	copyArray2 = append(copyArray2, originalArray2...)
	fmt.Println("\nOriginal Array: ", originalArray2)
	fmt.Println("Copy Array: ", copyArray2)

	// Passing an Array to a Function Creating and initializing an array
	var arr = [6]int{67, 59, 29, 35, 4, 34}
	var res int
	res = myAverage(arr, 6) // Passing an array as an argument
	fmt.Printf("\nFinal result is: %d ", res)
}

func myAverage(a [6]int, size int) int {
	var k, val, r int

	for k = 0; k < size; k++ {
		val += a[k]
	}

	r = val / size
	return r
}
