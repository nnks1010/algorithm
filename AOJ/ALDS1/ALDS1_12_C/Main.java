import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Edge {
		int to, dist;
		Edge(int to, int dist) {
			this.to = to; this.dist = dist;
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

	final int INF = Integer.MAX_VALUE;
	final int MAX_V = 10000;

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		Graph[] g = new Graph[MAX_V];
		for (int i = 0; i < MAX_V; i++)
			g[i] = new Graph();
		
		for (int i = 0; i < n; i++) {
			int u = scan.nextInt();
			int k = scan.nextInt();
			for (int j = 0; j < k; j++) {
				int v = scan.nextInt();
				int c = scan.nextInt();
				g[u].edges.add(new Edge(v, c));
			}
		}

		int[] dist = new int[MAX_V];
		for (int i = 0; i < MAX_V; i++)
			dist[i] = INF;

		Queue<Pair> que = new PriorityQueue<Pair>(new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.f - p2.f;
			}
		});
		
		dist[0] = 0;
		que.add(new Pair(0, 0));
		
		while (!que.isEmpty()) {
			Pair p = que.poll();
			int v = p.s;
			if (dist[v] < p.f) continue;
			for (int i = 0; i < g[v].edges.size(); i++) {
				Edge e = g[v].edges.get(i);
				if (dist[e.to] > dist[v] + e.dist) {
					dist[e.to] = dist[v] + e.dist;
					que.add(new Pair(dist[e.to], e.to));
				}
			}
		}
		for (int i = 0; i < n; i++)
			System.out.println(i + " " + dist[i]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
