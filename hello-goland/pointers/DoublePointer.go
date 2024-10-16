package pointers

import "fmt"

func DoublePointer() {
	fmt.Println("\n====Go Pointer to Pointer (Double Pointer)====")

	var V int = 100

	// taking a pointer of integer type
	var pt1 *int = &V

	// taking pointer to pointer to pt1 storing the address of pt1 into pt2
	var pt2 **int = &pt1

	fmt.Println("The Value of Variable V is = ", V)
	fmt.Println("Address of variable V is = ", &V)
	fmt.Println("The Value of pt1 is = ", pt1)
	fmt.Println("Address of pt1 is = ", &pt1)
	fmt.Println("The value of pt2 is = ", pt2)

	// Dereferencing the pointer to pointer
	fmt.Println("Value at the address of pt2 is or *pt2 = ", *pt2)

	// double pointer will give the value of variable V
	fmt.Println("*(Value at the address of pt2 is) or **pt2 = ", **pt2)

	var v1 int = 100
	var pt01 *int = &v1
	var pt02 **int = &pt1

	fmt.Println("\nThe Value of Variable v is = ", v1)
	fmt.Println("Value stored in v after changing pt01 = ", pt01)
	fmt.Println("Value stored in v after changing *pt01 = ", *pt01)
	fmt.Println("Value stored in v after changing pt02 = ", pt02)
	fmt.Println("Value stored in v after changing *pt02 = ", *pt02)
	fmt.Println("Value stored in v after changing **pt02 = ", **pt02)

	// changing the value of v by assigning the new value to the pointer pt01
	*pt01 = 200
	fmt.Println("\nValue stored in v after changing *pt01 = ", *pt01)

	// changing the value of v by assigning the new value to the pointer pt02
	**pt02 = 300
	fmt.Println("Value stored in v after changing **pt02 = ", **pt02)
}
