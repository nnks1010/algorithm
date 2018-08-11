import java.util.Scanner;

public class Main {
	final int INF = Integer.MAX_VALUE / 2;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] g = new int[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				g[i][j] = INF;
		for (int i = 0; i < n; i++)
				g[i][i] = 0;

		for (int i = 0; i < n; i++) {
			int u = scan.nextInt();
			int k = scan.nextInt();
			for (int j = 0; j < k; j++) {
				int v = scan.nextInt();
				int c = scan.nextInt();
				g[u][v] = c;
			}
		}
		
		for (int k = 0; k < n; k++) for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
			g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(i + " " + g[0][i]);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
