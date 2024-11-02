package array_slice

import (
	"fmt"
	"hello-golang/array-slice/arrays"
	"hello-golang/array-slice/slices"
)

func MainArrayAndSlice() {
	fmt.Println("\n\n==@@@==MainArrayAndSlice==@@@==")
	arrays.ArrayInGo()
	arrays.CopyingArray()
	slices.SliceInGo()
	slices.SliceCompositeLiteralAndCopying()
	slices.PassingSliceFunction()
	slices.CompareTwoSlices()
	slices.CheckEqualitySlice()
	slices.SortSliceInts()
	slices.TrimSliceByte()
	slices.SplitSlice()
}
