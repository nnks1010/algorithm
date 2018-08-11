import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean[][] g = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			int u = scan.nextInt();
			int k = scan.nextInt();
			for (int j = 0; j < k; j++) {
				int v = scan.nextInt();
				g[u - 1][v - 1] = true;
			}
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				System.out.print((g[i][j] ? 1 : 0) + (j == n - 1 ? "\n" : " "));
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
