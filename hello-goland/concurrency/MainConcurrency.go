package concurrency

import "fmt"

func MainConcurrency() {
	fmt.Println("\n\n==@@@==MainConcurrency==@@@==")
	GoroutineIgnore()
	Goroutines()
	AnonymousGoroutine()
	SelectStatement()
	SelectStatementMultipleCases()
}
