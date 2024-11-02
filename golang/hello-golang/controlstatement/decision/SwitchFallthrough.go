package decision

import "fmt"

func SwitchFallthrough() {
	fmt.Println("\n===Switch Fallthrough ===")

	dayOfWeek := 3

	switch dayOfWeek {
	case 1:
		fmt.Println("Sunday")
		fallthrough
	case 2:
		fmt.Println("Monday")
		fallthrough
	case 3:
		fmt.Println("Tuesday")
		fallthrough
	case 4:
		fmt.Println("Wednesday")
		fallthrough
	case 5:
		fmt.Println("Thursday")
		fallthrough
	case 6:
		fmt.Println("Friday")
		fallthrough
	case 7:
		fmt.Println("Saturday")
	default:
		fmt.Println("Invalid day")
	}
}
