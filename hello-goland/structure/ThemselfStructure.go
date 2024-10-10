package structure

import "fmt"

func ThemselfStructure() {
	fmt.Println("\n\n====ThemselfStructure====")

	p := Person{
		FirstName: "John",
		LastName:  "Doe",
		Age:       30,
		Address_2: Address_2{
			Street:     "123 Main St",
			City:       "Anytown",
			State:      "CA",
			PostalCode: "12345",
		},
	}

	fmt.Println(p.FirstName, p.LastName)
	fmt.Println("Age:", p.Age)
	fmt.Println("Address:")
	fmt.Println(" Street:", p.Address_2.Street)
	fmt.Println(" City:", p.Address_2.City)
	fmt.Println(" State:", p.Address_2.State)
	fmt.Println(" Postal Code:", p.Address_2.PostalCode)
}

type Address_2 struct {
	Street     string
	City       string
	State      string
	PostalCode string
}

type Person struct {
	FirstName string
	LastName  string
	Age       int
	Address_2 Address_2
}
