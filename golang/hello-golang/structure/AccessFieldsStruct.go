package structure

import "fmt"

func AccessFieldsStruct() {
	fmt.Println("\n\n====AccessFieldsStruct====")

	c := Car{Name: "Ferrari", Model: "GTC4", Color: "Red", WeightInKg: 1920}

	// Accessing struct fields using the dot operator
	fmt.Println("Car Name: ", c.Name)
	fmt.Println("Car Color: ", c.Color)

	// Assigning a new value to a struct field
	c.Color = "Black"

	// Displaying the result
	fmt.Println("Car: ", c)
}

// defining the struct
type Car struct {
	Name, Model, Color string
	WeightInKg         float64
}
