/*
 * Reference: https://gist.github.com/amoshyc/6a1a79e8dabea056e136
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	final int MAX_N = 2000;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		int[] s = new int[n]; // sort to a
		for (int i = 0; i < n; i++)
			a[i] = s[i] = scan.nextInt();
		Arrays.sort(s);
//		int[][] dp = new int[MAX_N + 1][MAX_N + 1];
		int[][] dp = new int[2][MAX_N + 1];
		int[] cur = dp[0], pre = dp[1], tmp;
//		for (int i = 0; i <= MAX_N; i++) {
//			for (int j = 0; j <= MAX_N; j++)
//				dp[i][j] = Long.MAX_VALUE;
//		}
		for (int i = 0; i <= MAX_N; i++) {
			pre[i] = Integer.MAX_VALUE;
			cur[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++)
			cur[i] = Math.abs(s[i] - a[0]);
		for (int i = 0; i < n; i++)
			System.out.print(cur[i] + " ");
		System.out.println();

		tmp = cur;
		cur = pre;
		pre = tmp;
		for (int i = 1; i < n; i++) {
			int min = pre[0];
			for (int j = 0; j < n; j++) {
				min = Math.min(min, pre[j]);
				cur[j] = min + Math.abs(s[j] - a[i]);
			}
			for (int t = 0; t < n; t++)
				System.out.print(cur[t] + " ");
			System.out.println();
			tmp = cur;
			cur = pre;
			pre = tmp;
		}

		tmp = cur;
		cur = pre;
		pre = tmp;
		int ans = cur[0];
//		for (int i = 1; i < cur.length; i++)
//			ans = Math.min(ans, cur[i]);
//		System.out.println(ans);

//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= n; j++)
//				System.out.print(dp[i][j] + " ");
//			System.out.println();
//		}
//		System.out.println(dp[n][n]);
//		int ans = dp[n][n - 1];

//		int[] tmp = new int[n];
//		for (int i = 0; i < n; i++)
//			tmp[i] = a[a.length - i - 1];
//		a = tmp;
//
//		for (int i = 0; i <= MAX_N; i++) {
//			for (int j = 0; j <= MAX_N; j++)
//				dp[i][j] = Integer.MAX_VALUE;
//		}
//		dp[0][0] = 0;
//		for (int i = 0; i < n; i++) {
//			int min = dp[i][0];
//			for (int j = 0; j < n; j++) {
//				min = Math.min(min, dp[i][j]);
//				dp[i + 1][j] = min + Math.abs(s[j] - a[i]);
//			}
//		}
//		System.out.println(Math.min(ans, dp[n][n - 1]));
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
