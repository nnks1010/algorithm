import java.util.Scanner;

public class Main {
	final static boolean DEBUG = false;
	final static int INF = Integer.MAX_VALUE;
	class Pair {
		int r, c;
		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			int r = scan.nextInt();
			int c = scan.nextInt();
			pairs[i] = new Pair(r, c);
		}
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				dp[i][j] = INF;

		for (int i = 0; i < n; i++)
				dp[i][i] = 0;

		for (int j = 1; j < n; j++) {
			for (int i = 0; i < n - j; i++) {
				for (int k = i; k < i + j; k++) {
					dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + (pairs[i].r * pairs[k].c * pairs[i + j].c));
				}
			}
		}
		if (DEBUG) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print((dp[i][j] == INF ? "X" : dp[i][j]) + " ");
				System.out.println();
			}
			System.out.println();
		}
		System.out.println(dp[0][n - 1]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
