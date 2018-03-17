import java.util.Arrays;
import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			if (n + m == 0)
				break;
			int[] a = new int[n + 1];
			int[] c = new int[n + 1];
			for (int i = 1; i <= n; i++)
				a[i] = scan.nextInt();
			for (int i = 1; i <= n; i++)
				c[i] = scan.nextInt();
			int[] dp = new int[m+1];
			for (int i = 0; i <= m; i++) {
				dp[i] = -1;
			}
			dp[0] = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					if (dp[j] >= 0)
						dp[j] = c[i];
				}
				for (int j = 0; j <= m; j++) {
					if (j - a[i] >= 0 && dp[j - a[i]] - 1 > dp[j]) {
						dp[j] = dp[j - a[i]] - 1;
					}
				}
			}
//			System.out.println("a: " + Arrays.toString(a));
//			System.out.println("c: " + Arrays.toString(c));
//			System.out.println(Arrays.toString(dp));
			int ans = 0;
			for (int i = m; i > 0; i--) {
				if (dp[i] != -1)
					ans++;
			}
			System.out.println(ans);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
