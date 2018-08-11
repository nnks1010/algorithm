import java.util.Scanner;

public class Main {
	final int INF = Integer.MAX_VALUE;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] cost = new int[n][n];
		int[] minCost = new int[n];
		boolean[] isUsed = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int a = scan.nextInt();
				cost[i][j] = a != -1 ? a : INF;
			}
		}
		for (int i = 0; i < n; i++)
			minCost[i] = INF;
		
		minCost[0] = 0;
		int res = 0;
		
		while (true) {
			int v = -1;
			for (int u = 0; u < n; u++)
				if (!isUsed[u] && (v == -1 || minCost[u] < minCost[v]))
					v = u;
			
			if (v == -1)
				break;
			isUsed[v] = true;
			res += minCost[v];
			
			for (int u = 0; u < n; u++)
				minCost[u] = Math.min(minCost[u], cost[v][u]);
		}
		System.out.println(res);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
