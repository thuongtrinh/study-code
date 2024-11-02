package fundamental

import (
	"fmt"
	"hello-golang/fundamental/constant"
	data_type "hello-golang/fundamental/data-type"
	go_rune "hello-golang/fundamental/go-rune"
	"hello-golang/fundamental/operator"
	"hello-golang/fundamental/variable"
)

func MainFundamental() {
	fmt.Println("\n\n==@@@==MainFundamental==@@@==")

	data_type.MainDataType()
	variable.MainVariable()
	constant.MainConstant()
	go_rune.MainRuneGo()
	operator.MainOperator()
}
