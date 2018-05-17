import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	class Gang {
		int t, p, s;
	}
	final int MAX_N = 100;
	final int MAX_K = 100;
	final int MAX_T = 30000;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int t = scan.nextInt();
		Gang[] g = new Gang[n];
		boolean[] visit = new boolean[MAX_T + 1];
		for (int i = 0; i < n ; i++)
			g[i] = new Gang();
		for (int i = 0; i < n ; i++) {
			g[i].t = scan.nextInt();
			visit[g[i].t] = true; 
		}
		for (int i = 0; i < n ; i++)
			g[i].p = scan.nextInt();
		for (int i = 0; i < n ; i++)
			g[i].s = scan.nextInt();
//		for (int i = 0; i < n ; i++)
//			System.out.println(g[i].t + " " + g[i].s);
		int[][] dp = new int[2][MAX_K + 1];
		int[] pre = dp[0];
		int[] cur = dp[1];

		for (int i = 1; i <= t; i++) {
//			for (int j = 0; j <= k; j++)
//				System.out.print(cur[j] + " ");
//			System.out.println();
			for (int j = 0; j <= i && j <= k; j++) {
				int max = 0;
				for (int l = -1; l <= 1; l++) {
					if (j + l >= 0 && j + l <= k)
						max = Math.max(max, pre[j + l]);
				}
				int p = 0;
				if (visit[i]) {
					for (int m = 0; m < n ; m++)
						if (g[m].t == i && g[m].s == j) p += g[m].p;
				}
				cur[j] = max + p;
			}
			{
				int[] tmp = cur;
				cur = pre;
				pre = tmp;
			}
		}
		{
			int[] tmp = cur;
			cur = pre;
			pre = tmp;
		}
		int ans = 0;
		for (int i = 0; i < MAX_K; i++)
			ans = Math.max(ans, cur[i]);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
