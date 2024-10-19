package methods

import "fmt"

func MethodAcceptBothPointerAndValue() {
	fmt.Println("\n===MethodAcceptBothPointerAndValue===")

	// Initializing the values of the author structure
	res := author3{
		name:   "Sona",
		branch: "CSE",
	}

	fmt.Println("Branch Name(Before): ", res.branch)

	// Calling the show_1 method (pointer method) with value
	res.show_1("ECE")
	fmt.Println("Branch Name(After): ", res.branch)

	// Calling the show_2 method (value method) with a pointer
	(&res).show_2()
	fmt.Println("Author's name(After): ", res.name)
}

// Author3 structure
type author3 struct {
	name   string
	branch string
}

// Method with a pointer receiver of author type
func (a *author3) show_1(abranch string) {
	(*a).branch = abranch
}

// Method with a value receiver of author type
func (a author3) show_2() {
	a.name = "Gourav"
	fmt.Println("Author's name(Before) : ", a.name)
}
