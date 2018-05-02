import java.util.Scanner;

public class Main {
	class Edge {
		int s, e, t;
		Edge(int s, int e, int t) {
			this.s = s;
			this.e = e;
			this.t = t;
		}
	}
	final int INF = Integer.MAX_VALUE / 3;

	void run() {
		Scanner scan = new Scanner(System.in);
		int f = scan.nextInt();
		while (f-- > 0) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int w = scan.nextInt();
			Edge[] es = new Edge[(m * 2) + w];
			for (int i = 0; i < (m * 2); i+=2) {
				int s = scan.nextInt();
				int e = scan.nextInt();
				int t = scan.nextInt();
				es[i] = new Edge(s, e, t);
				es[i + 1] = new Edge(e, s, t);
			}
			for (int i = 0; i < w; i++) {
				int index = i + m * 2;
				int s = scan.nextInt();
				int e = scan.nextInt();
				int t = scan.nextInt();
				es[index] = new Edge(s, e, -t);
			}
//			for (int i = 0; i < m * 2 + w; i++)
//				System.out.println(es[i].s + " " + es[i].e + " " + es[i].t);
//			System.out.println();
			int[] d = new int[n + 1];
			boolean ans = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m * 2 + w; j++) {
					Edge e = es[j];
					if (d[e.e] > d[e.s] + e.t) {
						d[e.e] = d[e.s] + e.t;
						if (i == n - 1) {
							ans = true;
						}
					}
				}
			}
			System.out.println(ans ? "YES" : "NO");
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
