package structure

import "fmt"

func PromotedMethodStructure() {
	fmt.Println("\n\n====Promoted Methods in Structure====")

	// Initializing the fields of the employee structure
	values := employee{
		post: "HR",
		eid:  4567,
		infoDetail: infoDetail{
			name:    "Sumit",
			age:     28,
			gender:  "Male",
			psalary: 890,
		},
	}

	// Normal fields of the employee structure
	fmt.Println("Post: ", values.post)
	fmt.Println("Employee id: ", values.eid)

	// Promoted fields of the employee structure
	fmt.Println("Name: ", values.name)
	fmt.Println("Age: ", values.age)
	fmt.Println("Gender: ", values.gender)
	fmt.Println("Per day salary: ", values.psalary)

	// Promoted method of the employee structure
	fmt.Println("Total Salary: ", values.promotedMethod(30))
}

type infoDetail struct {
	name    string
	age     int
	gender  string
	psalary int
}

// Nested structure
type employee struct {
	post string
	eid  int
	infoDetail
}

// Method
func (d infoDetail) promotedMethod(tsalary int) int {
	return d.psalary * tsalary
}
