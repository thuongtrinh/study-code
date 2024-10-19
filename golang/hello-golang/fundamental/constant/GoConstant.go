package constant

import (
	"fmt"
	"math"
)

const PI = 3.14

func GoConstant() {
	fmt.Println("\n===GoConstant===")

	const GFG = "GoConstant"
	fmt.Println("Hello", GFG)

	fmt.Println("Happy", PI, "Day")

	const Correct = true
	fmt.Println("Go rules?", Correct)

	const n = 5
	const d = 3e10 / n
	fmt.Println(d)
	fmt.Println(int64(d))
	fmt.Println(math.Sin(n))
}
