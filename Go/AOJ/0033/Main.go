package main

import (
	"fmt"
	"container/list"
)

type Pair struct {
	Y int
	X int
}

func main() {
	var h, w, n int
	var field, ans [][]int
	fmt.Scan(&h)
	fmt.Scan(&w)
	fmt.Scan(&n)
	field = make([][]int, h)
	ans = make([][]int, h)
	var sy, sx int
	for i := 0; i < h; i++ {
		field[i] = make([]int, w)
		ans[i] = make([]int, w)
		var str string
		fmt.Scan(&str)
		for j := 0; j < w; j++ {
			field[i][j] = int(str[j])
			if str[j] == int("S"[0]) {
				sy, sx = i, j
			}
		}
	}
	q := list.New()
	q.PushFront(Pair{sy, sx})
	var l int = 1

	for q.Len() != 0 {
		p := q.Remove(q.Front())
		if field[p.Y][p.X] == string(n + int("0"[0])) && l - 1 == n {
			fmt.Println(field[p.Y][p.X])
			break
		}
		dy := []int{ 1, 0, -1,  0 }
		dx := []int{ 0, 1,  0, -1 }
		for i := 0; i < 4; i++ {
			ny, nx := p.Y + dy[i], p.X + dx[i]
			if ny < 0 || nx < 0 || ny >= h || nx >= w {
				continue
			}
			if ans[ny][nx] != 0 {
				continue
			}
			if field[ny][nx] == "#" {
				continue
			}
			t := ans[ny][nx] + 1
			if field[ny][nx] == l + int("0"[0]) {
				l++
				field = make([][]int, h)
				for j := 0; j < h; j++ {
					field[j] = make([]int, w)
				}
				ans[ny][nx] = t
				q.Init()
				q.PushFront(Pair{ny, nx})
				break
			} else {
				ans[ny][nx] = t
				q.PushFront(Pair{ny, nx})
			}
		}
	}
}
