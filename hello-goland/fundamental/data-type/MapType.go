package data_type

import "fmt"

func MapType() {
	fmt.Println("\n\n===MapType===")

	var m map[string]int = map[string]int{"one": 1, "two": 2, "three": 3}
	fmt.Println(m)

	// access value of map
	fmt.Println(m["two"])

	// add new map of key,value
	m["four"] = 4
	fmt.Println(m)

	// Ex2
	fmt.Println("\nEx2: make")
	myMap := make(map[string]int)
	myMap["Alice"] = 25
	myMap["Bob"] = 30
	fmt.Println(myMap)              // Output: map[Alice:25 Bob:30]
	for key, value := range myMap { // Duyệt qua các cặp khóa-giá trị
		fmt.Printf("%s: %d\n", key, value)
	}

	// Ex3
	fmt.Println("\nEx3: Add, delete")
	myMap2 := map[string]int{
		"Alice": 25,
		"Bob":   30,
		"Carol": 35,
	}
	delete(myMap2, "Bob") // Xóa cặp khóa-giá trị
	fmt.Println(myMap2)   // Output: map[Alice:25 Carol:35]

	// Ex4: Kiểm tra sự tồn tại của khóa
	fmt.Println("\nEx4: Kiểm tra sự tồn tại của khóa")
	myMap3 := map[string]int{
		"Alice": 25,
		"Bob":   30,
	}
	value, exists := myMap3["Alice"]
	if exists {
		fmt.Println("Alice exists with value:", value) // Output: Alice exists with value: 25
	} else {
		fmt.Println("Alice does not exist")
	}

	value, exists = myMap3["Carol"]
	if exists {
		fmt.Println("Carol exists with value:", value)
	} else {
		fmt.Println("Carol does not exist") // Output: Carol does not exist
	}

	// Ex5: Maps Lồng Nhau
	fmt.Println("\nEx5: Maps Lồng Nhau")
	myMap4 := map[string]map[string]int{
		"Group1": {
			"Alice": 25,
			"Bob":   30,
		},
		"Group2": {
			"Carol": 35,
			"Dave":  40,
		},
	}
	for group, members := range myMap4 { // Duyệt qua các maps lồng nhau
		fmt.Println("Group:", group)
		for name, age := range members {
			fmt.Printf("  %s: %d\n", name, age)
		}
	}

	// Ex6: Maps và Structs
	fmt.Println("\nEx6: Maps và Structs")
	myMap5 := map[string]Person{
		"Alice": {25, "New York"},
		"Bob":   {30, "San Francisco"},
	}
	// Duyệt qua các cặp khóa-giá trị
	for name, person := range myMap5 {
		fmt.Printf("%s: Age=%d, City=%s\n", name, person.Age, person.City)
	}

	// Ex7: Truyền Maps vào Hàm
	fmt.Println("\nEx7: Truyền Maps vào Hàm")
	myMap6 := map[string]int{
		"Alice": 25,
		"Bob":   30,
	}
	printMap(myMap6)

	// Ex8: Trả Về Maps từ Hàm
	fmt.Println("\nEx8: Trả Về Maps từ Hàm")
	myMap7 := createMap()
	fmt.Println(myMap7) // Output: map[Alice:25 Bob:30]
}

type Person struct {
	Age  int
	City string
}

func printMap(m map[string]int) {
	for key, value := range m {
		fmt.Printf("%s: %d\n", key, value)
	}
}

func createMap() map[string]int {
	return map[string]int{
		"Alice": 25,
		"Bob":   30,
	}
}
