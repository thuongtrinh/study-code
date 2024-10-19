package interfaces

import "fmt"

func EmbeddingInterfaces() {
	fmt.Println("\n===Embedding Interfaces===")

	// Assigning values to the structure
	values := authority{
		a_name:    "Mickey",
		branch:    "Computer science",
		college:   "XYZ",
		year:      2024,
		salary:    50000,
		particles: 209,
		tarticles: 309,
	}

	// Accessing the methods of the interface 1 and 2
	// Using Final_Details interface
	var f Final_Details = values
	f.details()
	f.articles()
}

// Author_Details Interface 1
type Author_Details interface {
	details()
}

// Author_Articles Interface 2
type Author_Articles interface {
	articles()
}

// Final_Details Interface 3 embedded with interface 1 and 2
type Final_Details interface {
	AuthorDetails
	AuthorArticles
}

// Structure
type authority struct {
	a_name    string
	branch    string
	college   string
	year      int
	salary    int
	particles int
	tarticles int
}

// Implementing method of the interface 1
func (a authority) details() {
	fmt.Printf("Author Name: %s", a.a_name)
	fmt.Printf("\nBranch: %s and passing year: %d", a.branch, a.year)
	fmt.Printf("\nCollege Name: %s", a.college)
	fmt.Printf("\nSalary: %d", a.salary)
	fmt.Printf("\nPublished articles: %d", a.particles)
}

// Implementing method of the interface 2
func (a authority) articles() {
	pendingarticles := a.tarticles - a.particles
	fmt.Printf("\nPending articles: %d", pendingarticles)
}
