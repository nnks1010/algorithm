import java.util.Scanner;

public class Main {
	boolean[] pattern;
	boolean[][] osenbei;
	int c, r, max;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			c = scan.nextInt();
			r = scan.nextInt();
			if (c + r == 0)
				break;
			pattern = new boolean[c];
			osenbei = new boolean[c][r];
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < r; j++)
					osenbei[i][j] = scan.nextInt() == 1? true : false;
			}
			max = 0;
			dfs(0);
			System.out.println(max);
		}
	}

	void dfs(int d) {
		if (d == pattern.length) {
			max = Math.max(max, solve());
			return;
		}
		pattern[d] = false;
		dfs(d + 1);
		pattern[d] = true;
		dfs(d + 1);
		return;
	}

	int solve() {
		int sum = 0;
		for (int i = 0; i < r; i++) {
			int count = 0;
			for (int j = 0; j < c; j++) {
				if (pattern[j]) {
					count += osenbei[j][i]? 1 : 0;
				} else {
					count += !osenbei[j][i]? 1 : 0;
				}
			}
			sum += Math.max(count, pattern.length - count);
		}
		return sum;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
