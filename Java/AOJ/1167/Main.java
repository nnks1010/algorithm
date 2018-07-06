import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	final int MAX_N = 1000000;
	final int INF = Integer.MAX_VALUE;
	void run() {
		Scanner scan = new Scanner(System.in);
		int[] dp1 = new int[MAX_N + 1];
		int[] dp2 = new int[MAX_N + 1];
		for (int i = 1; i <= MAX_N; i++)
			dp1[i] = dp2[i] = INF;

		int[] pollock = new int[MAX_N]; //{ 1, 4, 10, 20, 35 };
		int pCount = 0;
		for (int i = 1;;i++) {
			int p = (i * (i + 1) * (i + 2)) / 6;
			if (p > MAX_N)
				break;
			pollock[pCount++] = p;
			if (DEBUG)
				System.out.println(pollock[pCount - 1]);
		}
		if (DEBUG)
			System.out.println(pCount);

		for (int i = 1; i <= MAX_N; i++) {
			for (int j = 0; j < pCount; j++) {
				if (i - pollock[j] < 0)
					continue;

				dp1[i] = Math.min(dp1[i], dp1[i - pollock[j]] + 1);
				if (pollock[j] % 2 == 1)
					dp2[i] = Math.min(dp2[i], dp2[i - pollock[j]] + 1);
			}
		}
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				return;
			System.out.println(dp1[n] + " " + dp2[n]);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
