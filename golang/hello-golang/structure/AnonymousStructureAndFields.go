package structure

import "fmt"

func AnonymousStructureAndFields() {
	fmt.Println("\n\n====AnonymousStructureAndFields====")

	// Creating and initializing the anonymous structure
	Element := struct {
		name      string
		branch    string
		language  string
		Particles int
	}{
		name:      "Pikachu",
		branch:    "ECE",
		language:  "C++",
		Particles: 498,
	}
	fmt.Println(Element)

	// Assigning values to the anonymous fields of the student structure
	value := student{123, "Bud", 8900.23}
	fmt.Println("\nEnrollment number : ", value.int)
	fmt.Println("Student name : ", value.string)
	fmt.Println("Package price : ", value.float64)
}

// Creating a structure with anonymous fields
type student struct {
	int
	string
	float64
}
