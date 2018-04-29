import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	class Milk {
		int s, e, ef;
		Milk(int s, int e, int ef) {
			this.s = s;
			this.e = e;
			this.ef = ef;
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int r = scan.nextInt();
		Milk[] milk = new Milk[m];
		for (int i = 0; i < m; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			int ef = scan.nextInt();
			milk[i] = new Milk(s, e, ef);
		}
		Arrays.sort(milk, new Comparator<Milk>() {
			@Override
			public int compare(Milk m1, Milk m2) {
				return m1.e - m2.e;
			}
		});
//		for (int i = 0; i < m; i++)
//			System.out.println(milk[i].s + " " + milk[i].e + " " + milk[i].ef);
//		System.out.println();
		
		int[] dp = new int[n + 1];
		for (int i = 1, milkIndex = 0; i <= n || milkIndex == m; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			if (i == milk[milkIndex].e) {
				int prevIndex = milk[milkIndex].s - r;
				if (prevIndex >= 0)
					dp[i] = Math.max(dp[i], milk[milkIndex].ef + dp[prevIndex]);
				else
					dp[i] = Math.max(dp[i], milk[milkIndex].ef);
				if (milkIndex == m - 1)
					break;
				milkIndex++;
				if (i == milk[milkIndex].e)
					i--;
			}
		}

//		for (int i = 0; i <= n; i++)
//			System.out.print(dp[i] + " ");
//		System.out.println();

		int ans = 0;
		for (int i = 0; i <= n; i++)
			ans = Math.max(ans, dp[i]);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
