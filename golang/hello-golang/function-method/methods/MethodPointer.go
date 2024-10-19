package methods

import "fmt"

func MethodPointer() {
	fmt.Println("\n===MethodPointer===")

	// Initializing the values of the author2 structure
	res := author2{
		name:   "Sona",
		branch: "CSE",
	}

	fmt.Println("Author's name: ", res.name)
	fmt.Println("Branch Name(Before): ", res.branch)

	// Creating a pointer
	p := &res

	// Calling the show2 method
	p.show2("ECE")
	fmt.Println("Author's name: ", res.name)
	fmt.Println("Branch Name(After): ", res.branch)
}

// author2 structure
type author2 struct {
	name      string
	branch    string
	particles int
}

// Method with a receiver of author type
func (a *author2) show2(abranch string) {
	(*a).branch = abranch
}
