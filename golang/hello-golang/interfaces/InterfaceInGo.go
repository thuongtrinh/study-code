package interfaces

import "fmt"

func InterfaceInGo() {
	fmt.Println("\n===InterfaceInGo===")

	// Accessing elements of the tank interface
	var t tank
	t = myvalue{10, 14}
	fmt.Println("Area of tank :", t.Tarea())
	fmt.Println("Volume of tank:", t.Volume())

	var tdynamic tank
	fmt.Println("Value of the tank interface is: ", tdynamic)
	fmt.Printf("Type of the tank interface is: %T ", tdynamic)

	// Interface Types
	fmt.Println("\n\nExample 2: Interface Types")
	var val interface {
	} = "Hello interface"
	myfun(val)

	// Type Assertions
	fmt.Println("\nExample 3: Type Assertions")
	var a1 interface {
	} = 98.09

	myfun2(a1)

	var a2 interface {
	} = "Hello Assertions"

	myfun2(a2)

	// Type Switch
	fmt.Println("\nExample 3: Type Switch")
	myfun3("Hello Switch")
	myfun3(67.9)
	myfun3(true)
}

// Creating an interface
type tank interface {
	Tarea() float64
	Volume() float64
}

type myvalue struct {
	radius float64
	height float64
}

// Implementing methods of the tank interface
func (m myvalue) Tarea() float64 {
	return 2*m.radius*m.height + 2*3.14*m.radius*m.radius
}

func (m myvalue) Volume() float64 {
	return 3.14 * m.radius * m.radius * m.height
}

// ----
func myfun(a interface{}) {
	// Extracting the value of a
	val := a.(string)
	fmt.Println("Value: ", val)
}

// ----
func myfun2(a interface{}) {
	value, ok := a.(float64)
	fmt.Println(value, ok)
}

// ----
func myfun3(a interface{}) {
	switch a.(type) { // Using type switch
	case int:
		fmt.Println("Type: int, Value:", a.(int))
	case string:
		fmt.Println("Type: string, Value: ", a.(string))
	case float64:
		fmt.Println("Type: float64, Value: ", a.(float64))
	default:
		fmt.Println("Type not found")
	}
}
