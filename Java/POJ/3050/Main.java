import java.util.Scanner;

public class Main {
	static final int LENGTH = 5;
	static final int MAX_NUM = 999999;

	int[][] line;
	boolean[] pattern;
	int[] dy = { 1, 0, -1,  0 };
	int[] dx = { 0, 1,  0, -1 };

	void run() {
		Scanner scan = new Scanner(System.in);
		line = new int[LENGTH][LENGTH];
		pattern = new boolean[MAX_NUM + 1];
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				line[i][j] = scan.nextInt();
			}
		}
		int ans = 0;
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				ans += dfs(i, j, 0, 0);
			}
		}
		System.out.println(ans);
	}
	
	int dfs(int y, int x, int n, int d) {
		if (y < 0 || x < 0 || y >= 5 || x >= 5)
			return 0;
		if (d == 6) {
			if (pattern[n]) {
				return 0;
			} else {
				pattern[n] = true;
				return 1;
			}
		}
		n += line[y][x] * Math.pow(10, d);
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count += dfs(y + dy[i], x + dx[i], n, d + 1);
		}
		return count;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
