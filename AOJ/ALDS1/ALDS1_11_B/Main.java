import java.util.Scanner;

public class Main {
	int n, deep;
	int[] d, f;
	boolean[][] g;
	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		g = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			int u = scan.nextInt();
			int k = scan.nextInt();
			for (int j = 0; j < k; j++) {
				int v = scan.nextInt();
				g[u - 1][v - 1] = true;
			}
		}
		deep = 0;
		d = new int[n];
		f = new int[n];
		dfs(0);
		for (int i = 0; i < n; i++)
			if (d[i] == 0)
				dfs(i);

		for (int i = 0; i < n; i++)
			System.out.println((i + 1) + " " + d[i] + " " + f[i]);
	}
	void dfs(int u) {
		if (d[u] > 0 || f[u] > 0)
			return;

		d[u] = ++deep;
		for (int i = 0; i < n; i++)
			if (g[u][i])
				dfs(i);
		f[u] = ++deep;
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
