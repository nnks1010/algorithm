import java.util.Scanner;

public class Main {
	final int INF = Integer.MAX_VALUE / 3;
	final int MAX_N = 200 + 1;
	final int MAX_M = 100000 + 1;
	final int MAX_R = 1000 + 1;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			if (n + m == 0)
				break;
			int[][] land = new int[MAX_N][MAX_N];
			int[][] sea = new int[MAX_N][MAX_N];

			for (int i = 0; i < MAX_N; i++)
				for (int j = 0; j < MAX_N; j++)
					land[i][j] = sea[i][j] = INF;
			for (int i = 0; i < MAX_N; i++)
				land[i][i] = sea[i][i] = 0;
			
			for (int i = 0; i < m; i++) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				int dist = scan.nextInt();
				char ls = scan.next().charAt(0);
				if (ls == 'L')
					land[from][to] = land[to][from] = dist;
				else
					sea[from][to] = sea[to][from] = dist;
			}
			
			// WarshallFloyd
			for (int k = 1; k <= n; k++) for(int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) {
				land[i][j] = Math.min(land[i][j], land[i][k] + land[k][j]);
				sea[i][j] = Math.min(sea[i][j], sea[i][k] + sea[k][j]);
			}
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++)
//					System.out.print((land[i][j] != INF ? land[i][j] : "x") + " ");
//				System.out.println();
//			}
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++)
//					System.out.print((sea[i][j] != INF ? sea[i][j] : "x") + " ");
//				System.out.println();
//			}
			
			// dp[配達した数][ボートのある島]
			int r = scan.nextInt();
			int[] z = new int[MAX_R];
			for (int i = 0; i < r; i++)
				z[i] = scan.nextInt();
			
			int[][] dp = new int[MAX_R][MAX_N];
			for (int i = 0; i < MAX_R; i++)
				for (int j = 0; j < MAX_N; j++)
					dp[i][j] = INF;
			
			dp[0][z[0]] = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 1; j <= n; j++) {
					if (dp[i][j] == INF) continue;
					// 現在の配達地(i, j)から，陸路のみの移動(船を使わない)で次の配達地(i + 1, j)まで行く最短距離
					dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + land[z[i]][z[i + 1]]);
					for (int k = 1; k <= n; k++) {
						// 次の配達地に行くために，ボートのある島(i, j)まで陸路で戻り，そこからボートを置きたい島までボートで移動をして(i, k)，
						// またそこから陸路を使って次の配達地(k, i + 1)まで行く最短距離
						dp[i + 1][k] = Math.min(dp[i + 1][k], dp[i][j] + land[z[i]][j] + sea[j][k] + land[k][z[i + 1]]);
					}
				}
			}
//			for (int i = 0; i < r; i++) {
//				for (int j = 1; j <= n; j++)
//					System.out.print((dp[i][j] != INF ? dp[i][j] : "x") + " ");
//				System.out.println();
//			}
			int ans = INF;
			for (int i = 1; i <= n; i++)
				ans = Math.min(ans, dp[r - 1][i]);
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
