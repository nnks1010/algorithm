import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;

	int h, w, c;
	int[] colors;
	int[][] tmp;
	int[] dy = { 1, 0, -1, 0 };
	int[] dx = { 0, 1, 0, -1 };
	int bColor, aColor;
	int sum;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			h = scan.nextInt();
			w = scan.nextInt();
			c = scan.nextInt();
			if (h + w + c == 0)
				return;

			int[][] panel = new int[h][w];
			tmp = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++)
					panel[i][j] = scan.nextInt();
			}
			colors = new int[6];
			int ans = 0;
			for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 6; j++) {
					for (int k = 1; k <= 6; k++) {
						for (int l = 1; l <= 6; l++) {
							colors[0] = i;
							colors[1] = j;
							colors[2] = k;
							colors[3] = l;
							colors[4] = c;
							for (int _i = 0; _i < h; _i++) {
								for (int _j = 0; _j < w; _j++)
									tmp[_i][_j] = panel[_i][_j];
							}
							paint();
							sum = 0;
							count(0, 0);
							ans = Math.max(ans, sum);
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	void paint() {
		for (int i = 0; i < 5; i++) {
			bColor = tmp[0][0];
			aColor = colors[i];
			if (bColor == aColor)
				continue;
			dfs(0, 0);
		}
	}
	void dfs(int y, int x) {
		if (DEBUG)
			System.out.println(y + " " + x);
		if (y < 0 || x < 0 || y >= h || x >= w)
			return;
		if (tmp[y][x] != bColor)
			return;
		tmp[y][x] = aColor;
		for (int i = 0; i < 4; i++)
			dfs(y + dy[i], x + dx[i]);
	}
	void count(int y, int x) {
		if (y < 0 || x < 0 || y >= h || x >= w)
			return;
		if (tmp[y][x] != c)
			return;
		tmp[y][x] = 0;
		sum++;
		for (int i = 0; i < 4; i++)
			count(y + dy[i], x + dx[i]);
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}
