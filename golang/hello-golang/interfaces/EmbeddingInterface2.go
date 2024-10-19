package interfaces

import "fmt"

func EmbeddingInterface2() {
	fmt.Println("\n===Embedding Interfaces 2===")

	// Assigning values to the structure
	values := author_2{
		a_name:    "Mickey",
		branch:    "Computer science",
		college:   "XYZ",
		year:      2025,
		salary:    50000,
		particles: 209,
		tarticles: 309,
	}

	// Accessing the methods of the interface 1 and 2
	// Using FinalDetails interface
	var f FinalDetails = values
	f.details()
	f.articles()
}

// AuthorityDetails Interface 1
type AuthorityDetails interface {
	details()
}

// AuthorityArticles Interface 2
type AuthorityArticles interface {
	articles()
}

// FinalDetails embedded with interface 1 and 2's methods
type FinalDetails interface {
	details()
	articles()
}

// Structure
type author_2 struct {
	a_name    string
	branch    string
	college   string
	year      int
	salary    int
	particles int
	tarticles int
}

// Implementing method of the interface 1
func (a author_2) details() {
	fmt.Printf("1. details")

	fmt.Printf("\nAuthor Name: %s", a.a_name)
	fmt.Printf("\nBranch: %s and passing year: %d", a.branch, a.year)
	fmt.Printf("\nCollege Name: %s", a.college)
	fmt.Printf("\nSalary: %d", a.salary)
	fmt.Printf("\nPublished articles: %d", a.particles)
}

// Implementing method of the interface 2
func (a author_2) articles() {
	fmt.Printf("\n2. articles")

	pendingarticles := a.tarticles - a.particles
	fmt.Printf("\nPending articles: %d", pendingarticles)
}
