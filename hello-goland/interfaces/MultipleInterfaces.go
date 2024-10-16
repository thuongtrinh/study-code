package interfaces

import "fmt"

func MultipleInterfaces() {
	fmt.Println("\n===Multiple Interfaces===")

	// Assigning values to the structure
	values := author{
		a_name:    "Mickey",
		branch:    "Computer science",
		college:   "XYZ",
		year:      2012,
		salary:    50000,
		particles: 209,
		tarticles: 309,
	}

	// Accessing the method of the interface 1
	var i1 AuthorDetails = values
	i1.details()

	// Accessing the method of the interface 2
	var i2 AuthorArticles = values
	i2.articles()
}

// AuthorDetails Interface 1
type AuthorDetails interface {
	details()
}

// AuthorArticles Interface 2
type AuthorArticles interface {
	articles()
}

// Structure
type author struct {
	a_name    string
	branch    string
	college   string
	year      int
	salary    int
	particles int
	tarticles int
}

// Implementing method of the interface 1
func (a author) details() {
	fmt.Printf("1. details")
	fmt.Printf("\nAuthor Name: %s", a.a_name)
	fmt.Printf("\nBranch: %s and passing year: %d", a.branch, a.year)
	fmt.Printf("\nCollege Name: %s", a.college)
	fmt.Printf("\nSalary: %d", a.salary)
	fmt.Printf("\nPublished articles: %d", a.particles)
}

// Implementing method of the interface 2
func (a author) articles() {
	fmt.Printf("\n2. articles")
	pendingarticles := a.tarticles - a.particles
	fmt.Printf("\nPending articles: %d", pendingarticles)
}
