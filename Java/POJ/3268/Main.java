import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	final int INF = Integer.MAX_VALUE / 3;
	class Edge {
		int b, t;
		Edge(int to, int cost) {
			this.b = to; this.t = cost;
		}
	}
	class Pair implements Comparable<Pair> {
		int f, s;
		Pair(int cost, int to) {
			this.f = cost; this.s = to;
		}
		public int compareTo(Pair p) {
			return this.f - p.f;
		}
	}
	class Graph {
		LinkedList<Edge> edges = new LinkedList<Edge>();
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int x = scan.nextInt();
		Graph[] g = new Graph[n + 1];
		for (int i = 0; i <= n; i++)
			g[i] = new Graph();
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int t = scan.nextInt();
			g[a].edges.add(new Edge(b, t));
		}
		int[][] d = new int[n+1][n+1];
		
		PriorityQueue<Pair> que = new PriorityQueue<Pair>();

		for (int t = 1; t <= n; t++) {
			for (int i = 0; i <= n; i++)
				d[t][i] = INF;
			que.clear();
			d[t][t] = 0;
			que.add(new Pair(0, t));
		
			while(!que.isEmpty()) {
				Pair p = que.poll();
				int v = p.s;
				if (d[t][v] < p.f) continue;
				for (int i = 0; i < g[v].edges.size(); i++) {
					Edge e = g[v].edges.get(i);
					if (d[t][e.b] > d[t][v] + e.t) {
						d[t][e.b] = d[t][v] + e.t;
						que.add(new Pair(d[t][e.b], e.b));
					}
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++)
			ans = Math.max(ans, d[i][x] + d[x][i]);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
