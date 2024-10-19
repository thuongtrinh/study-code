package pointers

import "fmt"

func FindCapacityPinter() {
	fmt.Println("\n====Find the capacity of the pointer====")

	// Creating and initializing pointer to array Using var keyword
	var ptr1 [7]*int
	var ptr2 [5]*string
	var ptr3 [8]*float64

	// Finding the capacity of the pointer to array Using cap function
	fmt.Println("Capacity of ptr1: ", cap(ptr1))
	fmt.Println("Capacity of ptr2: ", cap(ptr2))
	fmt.Println("Capacity of ptr3: ", cap(ptr3))

	fmt.Println("\nExample 2:")
	arr := [8]int{200, 300, 400, 500, 600, 700, 100, 200}
	var x int
	var p [5]*int

	// Assigning the address
	for x = 0; x < len(p); x++ {
		p[x] = &arr[x]
	}

	for x = 0; x < len(p); x++ {
		fmt.Printf("Value of p[%d] = %d\n", x, *p[x])
	}

	// Finding capacity using cap() function
	fmt.Println("Capacity of arr: ", cap(arr))
	fmt.Println("Capacity of p: ", cap(p))
}
