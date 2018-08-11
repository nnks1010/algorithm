import java.util.Scanner;

public class Main {
	final int MAX_M = 2000;
	int[] a;
	boolean[] sums;

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		a = new int[n];
		sums = new boolean[MAX_M + 1];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		dfs(0, 0);
		int q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			int m = scan.nextInt();
			System.out.println(sums[m] ? "yes" : "no");
		}
	}
	void dfs(int deep, int sum) {
		if (sum > MAX_M) return;
		if (deep == a.length) {
			sums[sum] = true;
			return;
		}
		dfs(deep + 1, sum);
		dfs(deep + 1, sum + a[deep]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
