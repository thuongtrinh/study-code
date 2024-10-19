package decision

import "fmt"

func SwitchStatement() {
	fmt.Println("\n===SwitchStatement===")

	// Switch statement with both optional statement, i.e, day:=4 and expression, i.e, day
	switch day := 4; day {
	case 1:
		fmt.Println("Monday")
	case 2:
		fmt.Println("Tuesday")
	case 3:
		fmt.Println("Wednesday")
	case 4:
		fmt.Println("Thursday")
	case 5:
		fmt.Println("Friday")
	case 6:
		fmt.Println("Saturday")
	case 7:
		fmt.Println("Sunday")
	default:
		fmt.Println("Invalid")
	}

	// Switch statement without an optional statement and expression
	var value1 int = 2
	switch {
	case value1 == 1:
		fmt.Println("Hello")
	case value1 == 2:
		fmt.Println("Bonjour")
	case value1 == 3:
		fmt.Println("Namstay")
	default:
		fmt.Println("Invalid")
	}

	// Switch statement without default statement. Multiple values in case statement
	var value2 string = "five"
	switch value2 {
	case "one":
		fmt.Println("C#")
	case "two", "three":
		fmt.Println("Go")
	case "four", "five", "six":
		fmt.Println("Java")
	}

	// illustrate the concept of Type switch statement
	var value interface{}
	switch q := value.(type) {
	case bool:
		fmt.Println("value is of boolean type")
	case float64:
		fmt.Println("value is of float64 type")
	case int:
		fmt.Println("value is of int type")
	default:
		fmt.Printf("value is of type: %T", q)
	}
}
