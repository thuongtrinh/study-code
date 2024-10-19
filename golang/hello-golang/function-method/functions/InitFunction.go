package functions

import (
	"fmt"
	"sort"
	"strings"
	"time"
)

// Multiple init() function
func init() {
	fmt.Println("Welcome to init() function")
}

func init() {
	fmt.Println("Hello! init() function")
}

func InitFunction() {
	fmt.Println("\n===InitFunction function ===")
	// Sorting the given slice
	s := []int{345, 78, 123, 10, 76, 2, 567, 5}
	sort.Ints(s)
	fmt.Println("Sorted slice: ", s)

	// Finding the index
	fmt.Println("Index value: ", strings.Index("InitFunction", "ks"))
	fmt.Println("Index value: ", strings.Index("InitFunction", "Fu"))

	// Finding the time
	fmt.Println("Time: ", time.Now().Unix())
}
