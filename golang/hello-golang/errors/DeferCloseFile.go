package errors

import (
	"fmt"
	"os"
)

func DeferCloseFile() {
	fmt.Println("\n===DeferCloseFile===")

	file, err := os.Open("example.txt")
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	defer file.Close()

	// read file
	buf := make([]byte, 1024)
	n, err := file.Read(buf)
	if err != nil {
		fmt.Println("Error:", err)
		return
	}
	fmt.Printf("Read %d bytes: %s\n", n, string(buf[:n]))
}
