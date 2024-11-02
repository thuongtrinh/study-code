package slices

import "fmt"

func PassingSliceFunction() {
	// Passing a Slice to Function
	fmt.Println("\n====Passing a Slice to Function====")

	slc := []string{"C#", "Python", "C", "Perl"}
	fmt.Println("Initial slice: ", slc)
	myfun(slc) // Passing the slice to the function
	fmt.Println("Final slice:", slc)

	// Creating a slice
	slc2 := []string{"C#", "Python", "C", "Perl"}
	fmt.Println("\nEx2:\nInitial slice: ", slc2)
	myfun2(slc2)
	fmt.Println("Final slice: ", slc2)
}

func myfun(element []string) {
	element[2] = "Java" // Modifying the given slice
	fmt.Println("Modified slice: ", element)
}

func myfun2(element []string) {
	// Here we only modify the slice, Using append function
	// Here, this function only modifies the copy of the slice present in the function not the original slice
	element = append(element, "Java")
	fmt.Println("Modified slice: ", element)
}
