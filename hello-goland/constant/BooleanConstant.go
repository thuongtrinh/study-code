package constant

import "fmt"

func BooleanConstant() {
	fmt.Println("\n===BooleanConstant===")

	const trueConst = true

	// Type definition using type keyword
	type myBool bool
	var defaultBool = trueConst       // allowed
	var customBool myBool = trueConst // allowed

	//  defaultBool = customBool // not allowed
	fmt.Println(defaultBool)
	fmt.Println(customBool)
}
