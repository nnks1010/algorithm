import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = scan.nextInt();

		int[][] max = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int[][] dp = new int[n][n];
				for (int k = i; k < n; k++) {
					for (int l = j; l < n; l++) {
						if (k == i && l == j) {
							dp[k][l] = a[k][l];
						} else if (k == i) {
							dp[k][l] = dp[k][l - 1] + a[k][l];
						} else if (l == j) {
							dp[k][l] = dp[k - 1][l] + a[k][l];
						} else {
							dp[k][l] = dp[k - 1][l] + dp[k][l - 1] - dp[k - 1][l - 1] + a[k][l];
						}
					}
				}
				int m = dp[0][0];
				for (int k = 0; k < n; k++)
					for (int l = 0; l < n; l++)
						m = Math.max(m, dp[k][l]);
				max[i][j] = m;
			}
		}
		int ans = max[0][0];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				ans = Math.max(ans, max[i][j]);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
