package structure

import (
	"fmt"
	"reflect"
)

func StructureEquality() {
	fmt.Println("\n\n====StructureEquality====")

	// Creating variables of Author structure
	a1 := Author{
		name:      "Moana",
		branch:    "CSE",
		language:  "Python",
		Particles: 38,
	}

	a2 := Author{
		name:      "Moana",
		branch:    "CSE",
		language:  "Python",
		Particles: 38,
	}

	a3 := Author{
		name:      "Dona",
		branch:    "CSE",
		language:  "Python",
		Particles: 38,
	}

	// Checking if a1 is equal to a2 or not Using == operator
	if a1 == a2 {
		fmt.Println("Variable a1 is equal to variable a2")
	} else {
		fmt.Println("Variable a1 is not equal to variable a2")
	}

	// Checking if a1 is equal to a2 or not Using == operator
	if a2 == a3 {
		fmt.Println("Variable a2 is equal to variable a3")
	} else {
		fmt.Println("Variable a2 is not equal to variable a3")
	}

	// Comparing a1 with a2 Using DeepEqual() method
	fmt.Println("Is a1 equal to a2: ", reflect.DeepEqual(a1, a2))

	// Comparing a2 with a3 Using DeepEqual() method
	fmt.Println("Is a2 equal to a3: ", reflect.DeepEqual(a2, a3))
}

type Author struct {
	name      string
	branch    string
	language  string
	Particles int
}
