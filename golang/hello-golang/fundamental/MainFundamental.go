package fundamental

import (
	"fmt"
	"hello-goland/fundamental/constant"
	data_type "hello-goland/fundamental/data-type"
	go_rune "hello-goland/fundamental/go-rune"
	"hello-goland/fundamental/operator"
	"hello-goland/fundamental/variable"
)

func MainFundamental() {
	fmt.Println("\n\n==@@@==MainFundamental==@@@==")

	data_type.MainDataType()
	variable.MainVariable()
	constant.MainConstant()
	go_rune.MainRuneGo()
	operator.MainOperator()
}
