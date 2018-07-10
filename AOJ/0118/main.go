package main

import (
	"fmt"
)

var h, w, f int
var field [][]int

const (
	Check = 0
	Ringo = 1
	Kaki  = 2
	Mikan = 3
)

func main() {
	for true {
		fmt.Scan(&h)
		fmt.Scan(&w)
		if h + w == 0 {
			break
		}
		field = make([][]int, h)
		for i := 0; i < h; i++ {
			field[i] = make([]int, w)
			var f string
			fmt.Scan(&f)
			for j := 0; j < w; j++ {
				if string(f[j]) == "@" {
					field[i][j] = Ringo
				} else if string(f[j]) == "#" {
					field[i][j] = Kaki
				} else {
					field[i][j] = Mikan
				}
			}
		}
		var ans int = 0
		for i := 0; i < h; i++ {
			for j := 0; j < w; j++ {
				if field[i][j] != Check {
					f = field[i][j]
					ans++
					bfs(i, j)
				}
			}
		}
		fmt.Println(ans)
	}
}

func bfs(y, x int) {
	if y < 0 || x < 0 || y >= h || x >= w {
		return
	} else if field[y][x] != f {
		return
	}
	field[y][x] = Check
	bfs(y+1, x)
	bfs(y-1, x)
	bfs(y, x+1)
	bfs(y, x-1)
}
