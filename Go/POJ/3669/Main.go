package main

import (
	"fmt"
	"math"
	"container/list"
)

type Pair struct {
	Y, X int
}


func main() {
	const goal = 50001
	var m int
	var field [303][303]int
	var dist [303][303]int
	field = fill(field, 50001)
	dx := []int{0, 1, 0, -1,  0}
	dy := []int{0, 0, 1,  0, -1}
	fmt.Scan(&m)
	for i := 0; i < m; i++ {
		var x, y, t int
		fmt.Scan(&x)
		fmt.Scan(&y)
		fmt.Scan(&t)
		for j := 0; j < 5; j++ {
			ny, nx := y + dy[j], x + dx[j]
			if ny < 0 || nx < 0 || ny >= 300 || nx >= 300 {
				continue
			}
			field[ny][nx] = int(math.Min(float64(t), float64(field[ny][nx])))
		}
	}
	que := list.New()
	que.PushFront(Pair{0, 0})
	for que.Len() != 0 {
		p := que.Remove(que.Front()).(Pair)
		if dist[p.Y][p.X] >= field[p.Y][p.X] {
			continue
		}
		if field[p.Y][p.X] == goal {
			fmt.Println(dist[p.Y][p.X])
			return
		}
		for i := 0; i < 5; i++ {
			ny, nx := p.Y + dy[i], p.X + dx[i]
			if ny < 0 || nx < 0 || ny >= 300 || nx >= 300 {
				continue
			}
			if dist[ny][nx] != 0 {
				continue
			}
			if i != 0 {
				dist[ny][nx] = dist[p.Y][p.X] + 1
			}
			que.PushFront(Pair{ny, nx})
		}
	}
	fmt.Println(-1)
}

func fill(array [303][303]int, val int) [303][303]int {
	for i := 0; i < len(array); i++ {
		for j := 0; j < len(array[i]); j++ {
			array[i][j] = val
		}
	}
	return array
}
