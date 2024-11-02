package decision

import "fmt"

func LoopControl() {
	fmt.Println("\n===LoopControl: Break, Goto, Continue===")

	fmt.Println("\n===Break Statement===")
	for i := 0; i < 5; i++ {
		fmt.Println(i)
		if i == 3 { // For loop breaks when the value of i = 3
			break
		}
	}

	fmt.Println("\n===Goto Statement===")
	var x int = 0
Label1:
	for x < 8 { // for loop work as a while loop
		if x == 5 {
			x = x + 1
			goto Label1 // using goto statement
		}
		fmt.Printf("value is: %d\n", x)
		x++
	}

	fmt.Println("\n===Continue  Statement===")
	var y int = 0
	for y < 8 { // for loop work as a while loop
		if y == 5 {
			y = y + 2 // skip two iterations
			continue
		}
		fmt.Printf("value is: %d\n", y)
		y++
	}
}
