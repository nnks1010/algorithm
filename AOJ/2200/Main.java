import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	final int INF = 100000000;
	final int MAX_N = 200;
	final int MAX_R = 1000;
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			if (n + m == 0)
				return;

			int[][] land = new int[MAX_N + 1][MAX_N + 1];
			int[][] sea  = new int[MAX_N + 1][MAX_N + 1];
			for (int i = 0; i <= MAX_N; i++) {
				for (int j = 0; j <= MAX_N; j++)
					land[i][j] = sea[i][j] = INF;
			}
			for (int i = 0; i <= MAX_N; i++)
				land[i][i] = sea[i][i] = 0;

			for (int i = 0; i < m; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				int t = scan.nextInt();
				char sl = scan.next().charAt(0);
				if (sl == 'L')
					land[x][y] = land[y][x] = t;
				else
					sea[x][y] = sea[y][x] = t;
			}
		
			int r = scan.nextInt();
			int[] z = new int[MAX_R];
			for (int i = 0; i < r; i++)
				z[i] = scan.nextInt();
		
			for (int k = 1; k <= MAX_N; k++) for (int i = 1; i <= MAX_N; i++) for (int j = 1; j <= MAX_N; j++) {
				land[i][j] = Math.min(land[i][j], land[i][k] + land[k][j]);
				sea[i][j]  = Math.min(sea[i][j], sea[i][k] + sea[k][j]);
			}

			if (DEBUG) {
				System.out.println("land");
				for (int i = 1; i <= n; i++)
					for (int j = 1; j <= n; j++)
						System.out.print((land[i][j] == INF ? "X" : land[i][j]) + (j == n ? "\n" : " "));
				System.out.println("sea");
				for (int i = 1; i <= n; i++)
					for (int j = 1; j <= n; j++)
						System.out.print((sea[i][j] == INF ? "X" : sea[i][j]) + (j == n ? "\n" : " "));
			}

			int[][] dp = new int[MAX_R][MAX_N + 1];
			for (int i = 0; i < MAX_R; i++)
				for (int j = 0; j <= MAX_N; j++)
					dp[i][j] = INF;

			dp[0][z[0]] = 0;
			for (int i = 0; i < r - 1; i++) {
				for (int j = 1; j <= n; j++) {
					if (land[z[i]][z[i + 1]] != INF)
						dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + land[z[i]][z[i + 1]]);
					for (int k = 1; k <= n; k++)
						dp[i + 1][k] = Math.min(dp[i + 1][k], dp[i][j] + land[z[i]][j] + sea[j][k] + land[k][z[i + 1]]);
				}
			}

			if (DEBUG) {
				System.out.println("dp");
				for (int i = 0; i < r; i++)
					for (int j = 0; j <= n; j++)
						System.out.print((dp[i][j] == INF ? "X" : dp[i][j]) + (j == n ? "\n" : " "));
			}

			int ans = INF;
			for (int i = 0; i <= n; i++)
				ans = Math.min(ans, dp[r - 1][i]);
			System.out.println(ans);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
