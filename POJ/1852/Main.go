package main

import (
	"fmt"
	"math"
)

func main() {
	var t int
	fmt.Scan(&t)
	for i := 0; i < t; i++ {
		var l float64
		var n int
		fmt.Scan(&l)
		fmt.Scan(&n)
		var max, min float64 = 0, 0
		for j := 0; j < n; j++ {
			var x, m float64
			fmt.Scan(&x)
			m = math.Min(l - x, x)
			min = math.Max(min, m)
			m = math.Max(l - x, x)
			max = math.Max(max, m)
		}
		fmt.Printf("%d %d", int(min), int(max))
	}
}

