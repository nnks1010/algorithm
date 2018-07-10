package main

import (
	"fmt"
)

var h, w int
var field [][]int

func main() {
	for true {
		fmt.Scan(&w)
		fmt.Scan(&h)
		if w + h == 0 {
			break
		}
		field = make([][]int, h)
		var sy, sx int = 0, 0
		for i := 0; i < h; i++ {
			field[i] = make([]int, w)
			var str string
			fmt.Scan(&str)
			for j := 0; j < w; j++ {
				if string(str[j]) == "." {
					field[i][j] = 1
				} else if string(str[j]) == "#" {
					field[i][j] = 0
				} else {
					sy = i
					sx = j
					field[i][j] = 1
				}
			}
		}
		fmt.Println(bfs(sy, sx))
	}
}

func bfs(y, x int) int {
	if y < 0 || x < 0 || y >= h || x >= w {
		return 0
	}
	if field[y][x] != 1 {
		return 0
	}
	field[y][x] = 0
	return 1 + bfs(y+1, x) + bfs(y-1, x) + bfs(y, x+1) + bfs(y, x-1)
}
