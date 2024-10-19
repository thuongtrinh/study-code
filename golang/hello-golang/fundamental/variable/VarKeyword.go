package variable

import "fmt"

var (
	geek01x = 100
	geek02x = 200.57
	geek03x bool
	geek04x string = "VarKeyword"
)

var geek1x, geek2x, geek3x, geek4x int
var geek11x, geek22x, geek33x, geek44x int = 10, 20, 30, 40
var geek111x, geek222x, geek333x, geek444x = 10, 20, 30.30, true

func VarKeyword() {
	fmt.Println("\n===VarKeyword===")

	var geek1x, geek2x, geek3x int = 232, 784, 854
	var geek4x, geek5x, geek6x = 100, "GFG", 7896.46

	// Display the values of the variables
	fmt.Printf("The value of geek1x is : %d\n", geek1x)
	fmt.Printf("The value of geek2x is : %d\n", geek2x)
	fmt.Printf("The value of geek3x is : %d\n", geek3x)
	fmt.Printf("The value of geek4x is : %d\n", geek4x)
	fmt.Printf("The value of geek5x is : %s\n", geek5x)
	fmt.Printf("The value of geek6x is : %f\n", geek6x)

	fmt.Printf("The value of geek01x is : %d\n", geek01x)
	fmt.Printf("The value of geek02x is : %f\n", geek02x)
	fmt.Printf("The value of geek03x is : %t\n", geek03x)
	fmt.Printf("The type of geek03x is : %T\n", geek03x)
	fmt.Printf("The value of geek04x is : %s\n", geek04x)
}
