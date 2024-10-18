package interfaces

import "fmt"

func PolymorphismInterfaces() {
	fmt.Println("\n===Polymorphism Using Interfaces===")

	res1 := team1{totalapp_1: 20, name_1: "Android"}
	res2 := team2{totalapp_2: 35, name_2: "IOS"}

	final := []employee{res1, res2}
	finaldevelop(final)
}

// Interface
type employee interface {
	develop() int
	name() string
}

// Structure 1
type team1 struct {
	totalapp_1 int
	name_1     string
}

// Methods of employee interface are implemented by the team1 structure
func (t1 team1) develop() int {
	return t1.totalapp_1
}

func (t1 team1) name() string {
	return t1.name_1
}

// Structure 2
type team2 struct {
	totalapp_2 int
	name_2     string
}

// Methods of employee interface are implemented by the team2 structure
func (t2 team2) develop() int {
	return t2.totalapp_2
}

func (t2 team2) name() string {
	return t2.name_2
}

func finaldevelop(i []employee) {
	totalproject := 0
	for _, ele := range i {
		fmt.Printf("\nProject environment = %s\n ", ele.name())
		fmt.Printf("Total number of project %d\n ", ele.develop())
		totalproject += ele.develop()
	}
	fmt.Printf("\nTotal projects completed by "+"the company = %d", totalproject)
}
