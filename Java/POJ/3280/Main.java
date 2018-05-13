import java.util.Scanner;

class Main {
	final int INF = Integer.MAX_VALUE/2;

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		char[] str = scan.next().toCharArray();
		int[] cost = new int[26];
		for (int i = 0; i < n; i++) {
			char c = scan.next().charAt(0);
			int add = scan.nextInt();
			int del = scan.nextInt();
			cost[c - 'a'] = Math.min(add, del);
		}
		int[][] dp = new int[m][m + 1];
		for (int i = 0; i < m; i++)
			for (int j = 0; j <= m; j++)
				dp[i][j] = INF;
		for (int i = 0; i < m; i++)
			dp[i][i] = dp[i][i + 1] = 0;
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < m; i++) {
				int index = i + j;
				if (index > m) continue;
				if (i > 0)
					dp[i - 1][index] = Math.min(dp[i - 1][index], dp[i][index] + cost[str[i - 1] - 'a']);
				if (index < m)
					dp[i][index + 1] = Math.min(dp[i][index + 1], dp[i][index] + cost[str[index] - 'a']);
				if (i > 0 && index < m && str[i - 1] == str[index])
					dp[i - 1][index + 1] = Math.min(dp[i - 1][index + 1], dp[i][index]);
			}
		}
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j <= m; j++)
//				System.out.print((dp[i][j] != INF ? dp[i][j] : "x") + " ");
//			System.out.println();
//		}
		System.out.println(dp[0][m]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}