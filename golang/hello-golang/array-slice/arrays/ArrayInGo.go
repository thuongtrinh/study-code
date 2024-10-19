package arrays

import "fmt"

func ArrayInGo() {
	fmt.Println("\n\n====Arrays in Golang====")

	// Shorthand declaration of array
	arr := [4]string{"array", "gfg", "Array1231", "ArrayforArray"}
	fmt.Println("\nElements of the array:", arr)
	for i := 0; i < len(arr); i++ {
		fmt.Println(arr[i])
	}

	// Creating and initializing 2-dimensional array. Using shorthand declaration. Here the (,) Comma is necessary
	arr1 := [3][3]string{{"C #", "C", "Python"}, {"Java", "Scala", "Perl"}, {"C++", "Go", "HTML"}}
	fmt.Println("\nElements of Array 1")
	for x := 0; x < 3; x++ {
		for y := 0; y < 3; y++ {
			fmt.Println(arr1[x][y])
		}
	}

	// Creating a 2-dimensional array using var keyword and initializing a multi-dimensional array using index
	var arr2 [2][2]int
	arr2[0][0] = 100
	arr2[0][1] = 200
	arr2[1][0] = 300
	arr2[1][1] = 400
	fmt.Println("\nElements of array 2")
	for p := 0; p < 2; p++ {
		for q := 0; q < 2; q++ {
			fmt.Println(arr2[p][q])
		}
	}

	// Creating an array of int type which stores two elements. Here, we do not initialize the array so the value of the array is zero
	var myarr [2]int
	fmt.Println("\nElements of the myarr: ", myarr)

	// Finding the length of the array using len method
	arr3 := [3]int{9, 7, 6}
	arr4 := [...]int{9, 7, 6, 4, 5, 3, 2, 4}
	arr5 := [3]int{9, 3, 5}
	fmt.Println("\nLength of the array 3 is:", len(arr3))
	fmt.Println("Length of the array 4 is:", len(arr4))
	fmt.Println("Length of the array 5 is:", len(arr5))

	// Creating an array whose size is determined by the number of elements present in it Using ellipsis
	myarray := [...]string{"GFG", "gfg", "arrays", "ArrayforArray", "ARRAY"}
	fmt.Println("\nElements of the array: ", myarray)
	fmt.Println("Length of the array is:", len(myarray))

	// Creating an array whose size is represented by the ellipsis
	myarrayRepeat := [...]int{29, 79, 49, 39, 20, 49, 48, 49}
	fmt.Println("\nElements of the myarrayRepeat: ")
	for x := 0; x < len(myarrayRepeat); x++ {
		fmt.Printf("%d\n", myarrayRepeat[x])
	}

	// Creating an array whose size is represented by the ellipsis
	fmt.Println("\nAn array is of value type not of reference type")
	my_array := [...]int{100, 200, 300, 400, 500}
	fmt.Println("Original array(Before):", my_array)
	new_array := my_array
	fmt.Println("New array(before):", new_array)
	new_array[0] = 500 // Change the value at index 0 to 500
	fmt.Println("New array(After):", new_array)
	fmt.Println("Original array(After):", my_array)

	// Arrays
	arr6 := [3]int{9, 7, 6}
	arr7 := [...]int{9, 7, 6}
	arr8 := [3]int{9, 5, 3}
	fmt.Println("\nComparing arrays using == operator ")
	fmt.Println(arr6 == arr7)
	fmt.Println(arr7 == arr8)
	fmt.Println(arr6 == arr8)

	/*
		arr9 := [4]int{9, 7, 6, 1}
		fmt.Println(arr6 == arr9) // This will give and error because the type of arr6 and arr9 is a mismatch
	*/
}
