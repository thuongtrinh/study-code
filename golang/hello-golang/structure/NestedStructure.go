package structure

import "fmt"

func NestedStructure() {
	fmt.Println("\n\n====NestedStructure====")
	// Initializing the fields of the HR structure
	result_1 := HR{
		details: AuthorBasic{"Sona", "ECE", 2013},
	}
	fmt.Println("\nDetails of Author")
	fmt.Println(result_1)

	// Initializing the fields of the Teacher structure
	result_2 := Teacher{
		name:    "Suman",
		subject: "Java",
		exp:     5,
		details: Student{"Bongo", "CSE", 2},
	}
	fmt.Println("\nDetails of the Teacher")
	fmt.Println("Teacher's name: ", result_2.name)
	fmt.Println("Subject: ", result_2.subject)
	fmt.Println("Experience: ", result_2.exp)

	fmt.Println("\nDetails of Student")
	fmt.Println("Student's name: ", result_2.details.name)
	fmt.Println("Student's branch name: ", result_2.details.branch)
	fmt.Println("Year: ", result_2.details.year)
}

type AuthorBasic struct {
	name   string
	branch string
	year   int
}

// HR Creating nested structure
type HR struct {
	// structure as a field
	details AuthorBasic
}

//---------------

type Student struct {
	name   string
	branch string
	year   int
}

// Teacher Creating nested structure
type Teacher struct {
	name    string
	subject string
	exp     int
	details Student
}
