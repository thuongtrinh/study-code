package functions

import "fmt"

func FunctionConstructor() {
	fmt.Println("\n===FunctionConstructor ===")

	// Using constructor to init Person object
	p := NewPerson("Alice", 30)
	fmt.Printf("Name: %s, Age: %d\n", p.Name, p.Age)

	fmt.Printf("\nEx2: Hàm Tạo với Kiểm Tra Giá Trị\n")
	p1, err := NewPerson2("Bob", -5)
	if err != nil {
		fmt.Println("Error:", err)
		//return
	} else {
		fmt.Printf("Name: %s, Age: %d\n", p1.Name, p1.Age)
	}

	fmt.Printf("\nEx3: Sử dụng từ khóa new để khởi tạo đối tượng Person\n")
	p2 := new(Person)
	p2.Name = "Charlie"
	p2.Age = 25
	fmt.Printf("Name: %s, Age: %d\n", p2.Name, p2.Age)
}

// Person define struct
type Person struct {
	Name string
	Age  int
}

// NewPerson function constructor for Person struct
func NewPerson(name string, age int) *Person {
	return &Person{
		Name: name,
		Age:  age,
	}
}

// NewPerson2 function constructor with check value
func NewPerson2(name string, age int) (*Person, error) {
	if age < 0 {
		return nil, fmt.Errorf("age cannot be negative")
	}
	return &Person{
		Name: name,
		Age:  age,
	}, nil
}
