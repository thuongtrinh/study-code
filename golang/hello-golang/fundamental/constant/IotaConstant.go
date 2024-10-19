package constant

import "fmt"

const (
	A = iota // A = 0
	B        // B = 1
	C        // C = 2
	D = iota // D = 3
	E        // E = 4
)

func IotaConstant() {
	fmt.Println(A, B, C, D, E) // Output: 0 1 2 3 4
}
