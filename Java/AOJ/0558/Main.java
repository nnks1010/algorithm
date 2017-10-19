import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int w = scan.nextInt();
		int n = scan.nextInt();
		char[][] field = new char[h][];
		int sy = 0, sx = 0;
		for (int i = 0; i < h; i++) {
			field[i] = scan.next().toCharArray();
			for (int j = 0; j < w; j++) {
				if (field[i][j] == 'S') {
					sy = i;
					sx = j;
				}
			}
		}
		
		int[][] ans = new int[h][w];
		int life = 1;
		
		Queue<Pair> que = new LinkedList<Pair>();
		que.add(new Pair(sy, sx));
		while (!que.isEmpty()) {
			Pair p = que.poll();
			if (field[p.y][p.x] - '0' == n && life - 1 == n) {
				System.out.println(ans[p.y][p.x]);
				break;
			}
			int[] dy = { 0, 1,  0, -1 };
			int[] dx = { 1, 0, -1,  0 };
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i], nx = p.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= h || nx >= w)
					continue;
				if (ans[ny][nx] != 0)
					continue;
				if (field[ny][nx] == 'X')
					continue;
				int t = ans[p.y][p.x] + 1;
				if (field[ny][nx] - '0' == life) {
					life++;
					ans = new int[h][w];
					que.clear();
					ans[ny][nx] = t;
					que.add(new Pair(ny, nx));
					break;
				} else {
					ans[ny][nx] = t;
					que.add(new Pair(ny, nx));
				}
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
