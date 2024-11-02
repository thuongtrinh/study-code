package methods

import "fmt"

type value_1 string
type value_2 int

func MethodSameName() {
	fmt.Println("\n===MethodSameName===")

	// Initializing values of the structures
	val1 := student{"Rohit", "EEE"}
	val2 := teacher{"Java", 50}
	val1.show()
	val2.show()

	// Initializing the values
	res1 := value_1("Geeks")
	res2 := value_2(234)
	fmt.Println("Result 1: ", res1.display())
	fmt.Println("Result 2: ", res2.display())
}

// Creating structures
type student struct {
	name   string
	branch string
}

type teacher struct {
	language string
	marks    int
}

// Same name methods, but with different type of receivers
func (s student) show() {
	fmt.Println("Name of the Student:", s.name)
	fmt.Println("Branch: ", s.branch)
}

func (t teacher) show() {
	fmt.Println("Language:", t.language)
	fmt.Println("Student Marks: ", t.marks)
}

// Creating same name function with different types of non-struct receivers
func (a value_1) display() value_1 {
	return a + "forGeeks"
}

func (p value_2) display() value_2 {
	return p + 298
}
