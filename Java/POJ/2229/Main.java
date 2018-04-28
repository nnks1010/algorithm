import java.util.Scanner;

public class Main {
	final int MOD = 1000000000;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int logN;
		for (logN = 0; (1 << logN) <= n; logN++);
		
		int[][] dp = new int[logN][n + 1];
		for (int i = 0; i < logN; i++)
			dp[i][0] = 1;
		for (int i = 0; i <= n; i++)
			dp[0][i] = 1;
		
		for (int i = 1; i < logN; i++) {
			for (int j = 0; j <= n; j++) {
//				System.out.println(j + " < " + (1 << i));
				if (j < (1 << i))
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = (dp[i - 1][j] + dp[i][j - (1 << i)]) % MOD;
			}
		}
//		for (int i = 0; i < logN; i++) {
//			for (int j = 0; j <= n; j++)
//				System.out.print(dp[i][j] + " ");
//			System.out.println();
//		}
		System.out.println(dp[logN - 1][n]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
