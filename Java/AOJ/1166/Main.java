import java.util.Scanner;

public class Main {
	static boolean DEBUG = false;
	boolean[][] m1;
	boolean[][] m2;
	int[][] map;
	int w, h;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			w = scan.nextInt();
			h = scan.nextInt();
			if (w + h == 0)
				return;
			
			m1 = new boolean[h][w - 1];
			m2 = new boolean[h - 1][w];
			map = new int[h][w];

			for (int i = 0; i < 2 * h - 1; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < w - 1; j++)
						m1[i / 2][j] = scan.nextInt() == 1;
				} else {
					for (int j = 0; j < w; j++)
						m2[i / 2][j] = scan.nextInt() == 1;
				}
			}

			if (DEBUG) {
				for (int i = 0; i < 2 * h - 1; i++) {
					if (i % 2 == 0) {
						for (int j = 0; j < w - 1; j++)
							System.out.print(" " + (m1[i / 2][j] ? 1 : 0));
					} else {
						for (int j = 0; j < w; j++)
							System.out.print((m2[i / 2][j] ? 1 : 0) + " ");
					}
					System.out.println();
				}
			}
			map[0][0] = 0;
			bfs(0, 0, 0);
			if (map[h - 1][w - 1] == 0)
				System.out.println(0);
			else
				System.out.println(map[h - 1][w - 1] + 1);
		}
	}
	void bfs(int y, int x, int deep) {
		if (map[y][x] != 0 && map[y][x] <= deep)
			return;
		if (y < 0 || x < 0 || y >= h || x >= w)
			return;

		map[y][x] = deep;
		if (y != h - 1 && !m2[y][x])
			bfs(y + 1, x, deep + 1);
		if (y != 0 && !m2[y - 1][x])
			bfs(y - 1, x, deep + 1);
		if (x != w - 1 && !m1[y][x])
			bfs(y, x + 1, deep + 1);
		if (x != 0 && !m1[y][x - 1])
			bfs(y, x - 1, deep + 1);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
