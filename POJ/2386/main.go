package main

import (
	"fmt"
)

var n, m int
var field [][]int

func main() {
	fmt.Scan(&n)
	fmt.Scan(&m)
	field = make([][]int, n)
	for i := 0; i < n; i++ {
		field[i] = make([]int, m)
		var str string
		fmt.Scan(&str)
		for j := 0; j < m; j++ {
			if string(str[j]) == "W" {
				field[i][j] = 1;
			}
		}
	}
	cnt := 0
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if field[i][j] == 1 {
				cnt++
				Solve(i, j);
			}
		}
	}
	fmt.Println(cnt)
}

func Solve(y, x int) {
	if y < 0 || x < 0 || y >= n || x >= m {
		return
	}
	if field[y][x] != 1 {
		return
	}
	field[y][x] = 0
	dy := []int { -1, -1, -1,  0, 0,  1, 1, 1 }
	dx := []int { -1,  0,  1, -1, 1, -1, 0, 1 }
	for i := 0; i < 8; i++ {
		Solve(y + dy[i], x + dx[i])
	}
}
