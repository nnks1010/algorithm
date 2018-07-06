import java.util.Scanner;

public class Main {
	final int INF = Integer.MAX_VALUE;
	void prim() {
		Scanner scan = new Scanner(System.in);
		int V = scan.nextInt();
		int E = scan.nextInt();
		int[][] cost = new int[V][V];
		int[] mincost = new int[V];
		boolean[] used = new boolean[V];
		
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				cost[i][j] = INF;

		for (int i = 0; i < E; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			int c = scan.nextInt();
			cost[from][to] = c;
			cost[to][from] = c;
		}
		for (int i = 0; i < V; i++) {
			mincost[i] = INF;
			used[i] = false;
		}
		mincost[0] = 0;
		int res = 0;
		
		while (true) {
			int v = -1;
			for (int u = 0; u < V; u++)
				if (!used[u] && (v == -1 || mincost[u] < mincost[v]))
					v = u;
			
			if (v == -1)
				break;
			used[v] = true;
			res += mincost[v];
			
			for (int u = 0; u < V; u++)
				mincost[u] = Math.min(mincost[u], cost[v][u]);
		}
		System.out.println(res);
	}

	class Edge {
		int u, v, cost;
		Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}

	void kruskal() {
		Scanner scan = new Scanner(System.in);
		int V = scan.nextInt();
		int E = scan.nextInt();
	}

	public static void main(String[] args) {
		new Main().prim();
//		new Main().kruskal();
	}
}
