import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++)
				dp[i][j] = scan.nextInt();
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				dp[i][j] = Math.max(dp[i][j] + dp[i + 1][j], dp[i][j] + dp[i + 1][j + 1]);
			}
		}
		System.out.println(dp[0][0]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
