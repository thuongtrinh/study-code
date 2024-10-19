package structure

import "fmt"

func FunctionAsFieldStructure() {
	fmt.Println("\n\n====Function as a Field in Structure====")

	// Initializing the fields of the structure
	result := Author3{
		name:      "Sonia",
		language:  "Java",
		Marticles: 120,
		Pay:       500,
		salary: func(Ma int, pay int) int {
			return Ma * pay
		},
	}
	fmt.Println("Author's Name: ", result.name)
	fmt.Println("Language: ", result.language)
	fmt.Println("Total number of articles published in May: ", result.Marticles)
	fmt.Println("Per article pay: ", result.Pay)
	fmt.Println("Total salary: ", result.salary(result.Marticles, result.Pay))

	// Initializing the fields of the structure
	result2 := Author4{
		name:      "Sonia",
		language:  "Java",
		Tarticles: 340,
		Particles: 259,
		Pending: func(Ta int, Pa int) int {
			return Ta - Pa
		},
	}
	fmt.Println("\nAuthor's Name: ", result2.name)
	fmt.Println("Language: ", result2.language)
	fmt.Println("Total number of articles: ", result2.Tarticles)
	fmt.Println("Total number of published articles: ", result2.Particles)
	fmt.Println("Pending articles: ", result2.Pending(result2.Tarticles, result2.Particles))
}

// FinalSalary of function type
type FinalSalary func(int, int) int

type Author3 struct {
	name      string
	language  string
	Marticles int
	Pay       int

	// Function as a field
	salary FinalSalary
}

//----------------

type Author4 struct {
	name      string
	language  string
	Tarticles int
	Particles int
	Pending   func(int, int) int
}
