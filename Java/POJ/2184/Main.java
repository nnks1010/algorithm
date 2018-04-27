import java.util.Scanner;

public class Main {
	final int MAX_RANGE = 1000 * 2 * 100;
	final int INF = Integer.MAX_VALUE;
	final int MID = (1000 * 2 * 100) / 2;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] c = new int[n][2];
		for (int i = 0; i < n; i++) {
			c[i][0] = scan.nextInt();
			c[i][1] = scan.nextInt();
		}
		int[][] dp = new int[2][MAX_RANGE + 1];
		for (int i = 0; i <= MAX_RANGE; i++)
			dp[0][i] = dp[1][i] = INF;

		dp[0][MID] = 0;

		for (int i = 0; i < n; i++) {
			int cur = i % 2;
			int next = (i + 1) % 2;
			for (int j = 0; j <= MAX_RANGE; j++) {
				if (dp[cur][j] == INF) continue;
				dp[next][j + c[i][0]] = dp[next][j + c[i][0]] == INF ? dp[cur][j] + c[i][1] : Math.max(dp[next][j + c[i][0]], dp[cur][j] + c[i][1]);
				dp[next][j] = dp[next][j] == INF ? dp[cur][j] : Math.max(dp[cur][j], dp[next][j]);
//				System.out.println(((j+c[i][0]) - MID) + " " + (dp[cur][j] + c[i][1]));
//				System.out.println((j - MID) + " " + dp[next][j]);
			}
//			System.out.println();
		}
		int ans = 0;
		for (int j = MID; j <= MAX_RANGE; j++) {
			if (dp[n % 2][j] == INF || dp[n % 2][j] < 0) continue;
			ans = Math.max(ans, dp[n % 2][j] + (j - MID));
		}

		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
