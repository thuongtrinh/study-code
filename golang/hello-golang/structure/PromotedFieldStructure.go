package structure

import "fmt"

func PromotedFieldStructure() {
	fmt.Println("\n\n====Promoted Fields in Structure====")

	// Initializing the fields of the studentPro structure
	values := studentPro{
		branch: "CSE",
		year:   2010,
		details: details{
			name:   "Sumit",
			age:    28,
			gender: "Male",
		},
	}

	// Promoted fields of the studentPro structure
	fmt.Println("Name: ", values.name)
	fmt.Println("Age: ", values.age)
	fmt.Println("Gender: ", values.gender)

	// Normal fields of the studentPro structure
	fmt.Println("Year: ", values.year)
	fmt.Println("Branch : ", values.branch)
}

type details struct {
	name   string
	age    int
	gender string
}

// Nested structure
type studentPro struct {
	branch string
	year   int
	details
}
