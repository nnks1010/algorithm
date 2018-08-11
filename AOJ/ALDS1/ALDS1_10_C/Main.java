import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		for (int t = 0; t < q; t++) {
			char[] x = scan.next().toCharArray();
			char[] y = scan.next().toCharArray();

			int[][] dp = new int[x.length + 1][y.length + 1];
			
			for (int i = 1; i <= x.length; i++) {
				for (int j = 1; j <= y.length; j++) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					if (x[i - 1] == y[j - 1])
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
			System.out.println(dp[x.length][y.length]);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
