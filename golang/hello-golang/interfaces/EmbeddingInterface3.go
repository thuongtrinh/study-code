package interfaces

import "fmt"

func EmbeddingInterface3() {
	fmt.Println("\n===Embedding Interfaces 3===")

	// Assigning values to the structure
	values := author_3{
		a_name:    "Mickey",
		branch:    "Computer science",
		college:   "XYZ",
		year:      2012,
		salary:    50000,
		particles: 209,
		tarticles: 309,
		cid:       3087,
		post:      "Technical content writer",
		pick:      58,
	}

	// Accessing the methods of the interface 1 and 2
	// Using FinalDetails interface
	var f FinalDetails3 = values
	f.details()
	f.articles()
	f.picked()
	f.cdeatils()
}

// AuthorDetails3 Interface 1
type AuthorDetails3 interface {
	details()
}

// AuthorArticles3 Interface 2
type AuthorArticles3 interface {
	articles()
	picked()
}

// FinalDetails3 Interface 3 embedded with interface1's method and interface 2 And also contain its own method
type FinalDetails3 interface {
	details()
	AuthorArticles3
	cdeatils()
}

// Structure
type author_3 struct {
	a_name    string
	branch    string
	college   string
	year      int
	salary    int
	particles int
	tarticles int
	cid       int
	post      string
	pick      int
}

// Implementing method of the interface 1
func (a author_3) details() {
	fmt.Printf("***details***")
	fmt.Printf("\nAuthor Name: %s", a.a_name)
	fmt.Printf("\nBranch: %s and passing year: %d", a.branch, a.year)
	fmt.Printf("\nCollege Name: %s", a.college)
	fmt.Printf("\nSalary: %d", a.salary)
	fmt.Printf("\nPublished articles: %d", a.particles)
}

// Implementing methods of the interface 2
func (a author_3) articles() {
	fmt.Printf("\n\n***articles***")
	pendingarticles := a.tarticles - a.particles
	fmt.Printf("\nPending articles: %d", pendingarticles)
}

func (a author_3) picked() {
	fmt.Printf("\n\n***picked***")
	fmt.Printf("\nTotal number of picked articles: %d", a.pick)
}

// Implementing the method of the embedded interface
func (a author_3) cdeatils() {
	fmt.Printf("\n\n***cdeatils***")
	fmt.Printf("\nAuthor Id: %d", a.cid)
	fmt.Printf("\nPost: %s", a.post)
}
