package errors

import (
	"fmt"
	"os"
)

func ErrorAndDefer() {
	fmt.Println("\n===ErrorAndDefer===")
	err := readFile("example.txt")
	if err != nil {
		fmt.Println("Error:", err)
	}
}

func readFile(filename string) error {
	file, err := os.Open(filename)
	if err != nil {
		return err
	}
	defer file.Close()

	buf := make([]byte, 1024)
	_, err = file.Read(buf)
	if err != nil {
		return err
	}

	fmt.Println("File read successfully")
	return nil
}
