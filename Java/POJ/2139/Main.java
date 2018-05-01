import java.util.Scanner;

public class Main {
	final int MAX_N = 300 + 1;
	final int INF = Integer.MAX_VALUE / 3;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] d = new int[MAX_N][MAX_N];
		for (int i = 0; i < MAX_N; i++)
			for (int j = 0; j < MAX_N; j++)
				d[i][j] = INF;
		for (int i = 0; i < MAX_N; i++)
			d[i][i] = 0;
		
		for (int i = 0; i < m; i++) {
			int mi = scan.nextInt();
			int[] c = new int[mi];
			for (int j = 0; j < mi; j++)
				c[j] = scan.nextInt();
			for (int j = 0; j < c.length; j++) {
				for (int k = 0; k < c.length; k++) {
					if (j == k) continue;
					d[c[j]][c[k]] = 1;
				}
			}
		}
		for (int k = 1; k <= n; k++) for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++)
			d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++)
//				System.out.print((d[i][j] != INF ? d[i][j] : "x") + " ");
//			System.out.println();
//		}
		double ans = INF;
		for (int i = 1; i <= n; i++) {
			double sum = 0;
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == INF) continue;
				sum += d[i][j];
			}
			ans = Math.min(ans, sum / (n - 1));
		}
		System.out.println((int)(ans * 100));
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
