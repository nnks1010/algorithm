import java.util.Scanner;

public class Main {
	final int MAX_M = 100 * 1000;
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				return;
			int[] p = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = scan.nextInt();
			
			int[][] dp = new int[n + 1][MAX_M];
			int[][] ans = new int[n + 1][MAX_M];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < MAX_M; j++) {
					dp[i][j] = -1;
					ans[i][j] = MAX_M;
				}
			}

			dp[0][0] = 0;
			ans[0][0] = 0;
			
			for (int i = 0; i < n; i++) {
				// 商品を買わない
				for (int j = 0; j < MAX_M; j++) {
					dp[i + 1][j] = dp[i][j];
					ans[i + 1][j] = ans[i][j];
				}

				// 商品を買う
				int change = (p[i] % 1000 == 0) ? 0 : (1000 - p[i] % 1000);
				for (int j = 0; j < MAX_M; j++) {
					if (dp[i][j] == -1) continue;

					int get500Coin = j + change < 500 ? 0 : 1;
					int nextMoney = j + change - (500 * get500Coin);
					if (dp[i + 1][nextMoney] < dp[i][j] + get500Coin) {
						dp[i + 1][nextMoney] = dp[i][j] + get500Coin;
						ans[i + 1][nextMoney] = ans[i][j] + p[i];
					} else if (dp[i + 1][nextMoney] == dp[i][j] + get500Coin) {
						ans[i + 1][nextMoney] = Math.min(ans[i + 1][nextMoney], ans[i][j] + p[i]);
					}
				}
			}
			
			int maxMAX_MCoin = 0;
			int minPay = 0;
			for (int i = 0; i < MAX_M; i++) {
				if (maxMAX_MCoin < dp[n][i]) {
					maxMAX_MCoin = dp[n][i];
					minPay = ans[n][i];
				} else if (maxMAX_MCoin == dp[n][i]) {
					minPay = Math.min(minPay, ans[n][i]);
				}
			}
			System.out.println(maxMAX_MCoin + " " + minPay);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
