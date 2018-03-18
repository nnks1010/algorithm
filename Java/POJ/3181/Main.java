import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static final int MAX_N = 1000;
	static final int MAX_K = 100;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		BigInteger[][] dp = new BigInteger[MAX_K + 1][MAX_N + 1];
		for (int i = 0; i <= MAX_K; i++) {
			dp[i][0] = new BigInteger("1");
			for (int j = 1; j <= MAX_N; j++) {
				dp[i][j] = new BigInteger("0");
			}
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (j - i < 0)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j].add(dp[i][j - i]);
			}
		}
//		for (int i = 0; i <= k; i++) {
//			for (int j = 0; j <= n; j++)
//				System.out.print(dp[i][j] + " ");
//			System.out.println();
//		}
		System.out.println(dp[k][n].toString());
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
