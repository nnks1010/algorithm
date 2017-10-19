import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    class Pair {
        int y, x;
        Pair(int y,int x) {
            this.y = y;
            this.x = x;
        }
    }

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] field = new int[m][];
		int[][] ans = new int[m][];
		int sx = 0, sy = 0;
		int gx = 0, gy = 0;
		for (int i = 0; i < m; i++) {
			field[i] = new int[n];
			ans[i] = new int[n];
			char[] data = scan.next().toCharArray();
			for (int j = 0; j < n; j++) {
				if (data[j] == '#')
					field[i][j] = 1;
				else if (data[j] == '.')
					field[i][j] = 0;
				else if (data[j] == 'S') {
					sx = j;
					sy = i;
					field[i][j] = 0;
				} else {
					gx = j;
					gy = i;
					field[i][j] = 0;
				}
			}
		}
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(field[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(sy + " " + sx);
//		System.out.println(gy + " " + gx);

//		Pair pair = ;
//		System.out.println(pair.y + " " + pair.x);

        Queue<Pair> que = new ArrayDeque<Pair>();
        que.add(new Pair(sy, sx));
        while (!que.isEmpty()) {
        		Pair pair = que.poll();
        		if (pair.y == gy && pair.x == gx) {
        			System.out.println(ans[pair.y][pair.x]);
        			return;
        		}
        		int[] dx = { 1, 0, -1,  0 };
        		int[] dy = { 0, 1,  0, -1 };
        		for (int i = 0; i < 4; i++) {
        			int ny = pair.y + dy[i];
        			int nx = pair.x + dx[i];
        			if (ny < 0 || nx < 0 || ny >= m || nx >= n)
        				continue;
        			if (ans[ny][nx] != 0)
        				continue;
        			if (field[ny][nx] != 0)
        				continue;
        			ans[ny][nx] = ans[pair.y][pair.x] + 1;
        		}
        }
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
