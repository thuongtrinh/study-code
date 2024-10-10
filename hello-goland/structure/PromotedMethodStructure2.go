package structure

import "fmt"

func PromotedMethodStructure2() {
	fmt.Println("\n\n====Promoted Methods in Structure 2====")

	// Initializing the fields of the employeeInfo structure
	values := employeeInfo{
		post:     "HR",
		eid:      4567,
		particle: 5,
		detailInfo: detailInfo{
			name:    "Sumit",
			age:     28,
			gender:  "Male",
			psalary: 890,
		},
	}

	// Normal fields of the employeeInfo structure
	fmt.Println("Post: ", values.post)
	fmt.Println("Employee id: ", values.eid)
	fmt.Println("Particle: ", values.particle)
	fmt.Println("Total Articles: ", values.promotmethod(20))

	// Promoted fields of the employeeInfo structure
	fmt.Println("\nName: ", values.name)
	fmt.Println("Age: ", values.age)
	fmt.Println("Gender: ", values.gender)
	fmt.Println("Per day salary: ", values.psalary)

	// Promoted method of the employee structure
	fmt.Println("Total Salary: ", values.detailInfo.promotmethod(30))
}

type detailInfo struct {
	name    string
	age     int
	gender  string
	psalary int
}

// Nested structure
type employeeInfo struct {
	post     string
	particle int
	eid      int
	detailInfo
}

// Method 1
func (e employeeInfo) promotmethod(tarticle int) int {
	return e.particle * tarticle
}

// Method 2
func (d detailInfo) promotmethod(tsalary int) int {
	return d.psalary * tsalary
}
