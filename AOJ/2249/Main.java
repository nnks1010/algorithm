import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Edge {
		int to, dist, cost;
		Edge(int to, int dist, int cost) {
			this.to = to; this.dist = dist; this.cost = cost;
		}
	}
	class Pair {
		int f, s;
		Pair(int f, int s) {
			this.f = f; this.s = s;
		}
	}
	class Graph {
		 LinkedList<Edge> edges = new LinkedList<Edge>();
	}

	final int MAX_V = 10000;
	
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			if (n + m == 0)
				break;
//			List<Edge>[] g = new LinkedList[MAX_V];
//			for (int i = 0; i < MAX_V; i++)
//				g[i] = new LinkedList<Edge>();
			
			Graph[] g = new Graph[MAX_V];
			for (int i = 0; i < MAX_V; i++)
				g[i] = new Graph();

			for (int i = 0; i < m; i++) {
				int u = scan.nextInt();
				int v = scan.nextInt();
				int d = scan.nextInt();
				int c = scan.nextInt();
				g[u].edges.add(new Edge(v, d, c));
				g[v].edges.add(new Edge(u, d, c));
			}
			int[] dist = new int[MAX_V + 1];
			int[] cost = new int[MAX_V + 1];
			for (int i = 0; i < MAX_V; i++)
				dist[i] = Integer.MAX_VALUE;
			Queue<Pair> que = new PriorityQueue<Pair>(new Comparator<Pair>() {
	            @Override
	            public int compare(Pair p1, Pair p2) {
	                return p1.f - p2.f;
	            }
	        });
			dist[1] = 0;
			que.add(new Pair(0, 1));

			while (!que.isEmpty()) {
				Pair p = que.poll();
				int v = p.s;
//				System.out.println("p.s: " + p.s + ", p.f: " + p.f);
				if (dist[v] < p.f) continue;
//				System.out.println("g[v].size:" + g[v].size());
				for (int i = 0; i < g[v].edges.size(); i++) {
					Edge e = g[v].edges.get(i);
					if (dist[e.to] > dist[v] + e.dist) {
						dist[e.to] = dist[v] + e.dist;
						cost[e.to] = e.cost;
//						System.out.println("que.add: " + dist[e.to] + ", " + e.to);
						que.add(new Pair(dist[e.to], e.to));
					} else if (dist[e.to] == dist[v] + e.dist) {
						cost[e.to] = Math.min(cost[e.to], e.cost);
					}
				}
//				for (int i = 0; i < n; i++)
//					System.out.print(dist[i] + " ");
//				System.out.println("dist");
//				for (int i = 0; i < n; i++)
//					System.out.print(cost[i] + " ");
//				System.out.println("cost");
//				System.out.println();
			}
			int ans = 0;
			for (int i = 0; i <= MAX_V; i++)
				if (cost[i] != Integer.MAX_VALUE) ans += cost[i];
			System.out.println(ans);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
