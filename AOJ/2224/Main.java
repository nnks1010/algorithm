import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	class UnionFind {
		int[] par, rank;
		UnionFind(int n) {
			par  = new int[n + 1];
			rank = new int[n + 1];
			init(n);
		}
		void init(int n) {
			for (int i = 0; i <= n; i++) {
				par[i] = i;
				rank[i] = 0;
			}
		}
		
		int find(int x) {
			if (par[x] == x)
				return x;
			else
				return par[x] = find(par[x]);
		}
		
		void unite(int x, int y) {
			x = find(x);
			y = find(y);
			if (x == y)
				return;
			
			if (rank[x] < rank[y]) {
				par[x] = y;
			} else {
				par[y] = x;
				if (rank[x] == rank[y])
					rank[x]++;
			}
		}
		
		boolean same(int x, int y) {
			return find(x) == find(y);
		}
	}

	class Edge {
		int u, v;
		double cost;
		Edge(int u, int v, double cost) {
			this.u = u; this.v = v; this.cost = cost;
		}
	}
	class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y = y; this.x = x;
		}
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();

		Pair[] pairs = new Pair[n + 1];
		for (int i = 1; i <= n; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			pairs[i] = new Pair(y, x);
		}

		Edge[] edges = new Edge[m];
		double sum = 0;
		for (int i = 0; i < m; i++) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			int _y = Math.abs(pairs[p].y - pairs[q].y);
			int _x = Math.abs(pairs[p].x - pairs[q].x);
			double cost = Math.sqrt(_y * _y + _x * _x);
			sum += cost;
			edges[i] = new Edge(p, q, cost);
		}
		
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.cost - e2.cost > 0 ? -1 :
				       e1.cost - e2.cost < 0 ?  1 :
				    	                        0 ;
			}
		});
		UnionFind uf = new UnionFind(n);
		
		double res = 0;
		for (int i = 0; i < m; i++) {
			Edge e = edges[i];
			if (!uf.same(e.u, e.v)) {
				uf.unite(e.u, e.v);
				res += e.cost;
			}
		}
		System.out.printf("%.4f\n", sum - res);
	}

	public static void main(String[] args) {
		new Main().run();
	}

}