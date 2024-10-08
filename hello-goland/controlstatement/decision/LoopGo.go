package decision

import "fmt"

func LoopGo() {
	fmt.Println("\n===simple for loop===")
	for i := 0; i < 4; i++ {
		fmt.Printf("Loop for in Go %d\n", i)
	}

	fmt.Println("\n===for loop as while Loop===")
	i := 0
	for i < 3 { // while loop for loop executes till i < 3 condition is true
		fmt.Printf("\nwhile loop %d", i)
		i += 1
	}

	fmt.Println("\n===Simple range in for loop===")
	rvariable := []string{"GFG", "LoopGo", "LoopforLoop"}
	// i and j stores the value of rvariable
	// i store index number of individual string
	// j store individual string of the given array
	for i, j := range rvariable {
		fmt.Println(i, j)
	}

	fmt.Println("\n===Using for loop for strings===")
	for i, j := range "XabCd" { // String as a range in the for loop
		fmt.Printf("The index number of %U is %d\n", j, i)
	}

	fmt.Println("\n===For Maps===")
	mmap := map[int]string{ // using maps
		22: "ForMaps",
		33: "GFG",
		44: "MapsForMaps",
	}
	for key, value := range mmap {
		fmt.Println(key, value)
	}

	fmt.Println("\n==For Channel===")
	chnl := make(chan int) // using channel
	go func() {
		chnl <- 100
		chnl <- 1000
		chnl <- 10000
		chnl <- 100000
		close(chnl)
	}()
	for i := range chnl {
		fmt.Println(i)
	}
}
