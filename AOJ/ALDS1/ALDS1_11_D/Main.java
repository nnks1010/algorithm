import java.util.Scanner;

public class Main {
	class UnionFind {
		private int[] par, rank;
		UnionFind(int n) {
			par = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++)
				par[i] = i;
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
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < m; i++) {
			int s = scan.nextInt();
			int t = scan.nextInt();
			uf.unite(s, t);
		}

		int q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			int s = scan.nextInt();
			int t = scan.nextInt();
			System.out.println(uf.same(s, t) ? "yes" : "no");
		}

	}
	public static void main(String[] args) {
		new Main().run();
	}
}
