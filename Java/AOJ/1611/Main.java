import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				return;
			int[] w = new int[n];
			for (int i = 0; i < n; i++)
				w[i] = scan.nextInt();
			int[][] dp = new int[n][n];
//			int count = 1;
			for (int j = 1; j < n; j++) {
				for (int i = 0; i + j < n; i++) {

//					for (int _i = 0; _i < n; _i++) for (int _j = 0; _j < n; _j++) dp[_i][_j] = 0;
//					dp[i][i + j] = count++;
//					int count2 = 1;

					// 区間(i + 1, i + j - 1)のブロックが全て落とされている場合，ブロック i とブロック i + j が落とせるか判定
//					System.out.println((dp[i + 1][i + j - 1]) + " == " + ((i + j) - i - 1));
					if (dp[i + 1][i + j - 1] == (i + j) - i - 1) {
						if (Math.abs(w[i] - w[i + j]) <= 1) {
							dp[i][i + j] = dp[i + 1][i + j - 1] + 2;
						}
					}
					for (int k = i; k < i + j; k++) {
//						dp[i][k] = dp[k + 1][i + j] = count2++;
						// 区間(i, k)と区間(k + 1, i + j)で落とされたブロックをマージする
						dp[i][i + j] = Math.max(dp[i][i + j], dp[i][k] + dp[k + 1][i + j]);
					}

//					for (int _i = 0; _i < n; _i++) {
//						for (int _j = 0; _j < n; _j++) System.out.print(dp[_i][_j] + " ");
//						System.out.println();
//					}
//					System.out.println();
				}
			}
//			for (int _i = 0; _i < n; _i++) {
//				for (int _j = 0; _j < n; _j++) System.out.print(dp[_i][_j] + " ");
//				System.out.println();
//			}
//			System.out.println();
			System.out.println(dp[0][n - 1]);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
