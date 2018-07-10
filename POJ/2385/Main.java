import java.util.Scanner;

public class Main {
	int T, W;
	int[] tree;

	void run() {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		W = scan.nextInt();
		tree = new int[T+1];
		for (int i = 1; i <= T; i++)
			tree[i] = scan.nextInt();
		int[][] dp = new int[W+1][T+1];
//		int count = 0;
		for (int t = 0; t < T; t++) {
			for (int w = W; w >= 0; w--) {
//				if (W > t && W - w > t) continue;
//				dp[j][i] = ++count;
				dp[w][t+1] = Math.max(dp[w][t+1], dp[w][t] + apple(t + 1, w));
				if (w != 0) {
					dp[w-1][t+1] = dp[w][t] + apple(t + 1, w - 1);
				}
			}
		}
		for (int i = 0; i <= W; i++) {
			for (int j = 0; j <= T; j++)
				System.out.printf("%3d", dp[i][j]);
			System.out.println();
		}
		System.out.println(dp[0][T]);
	}
	
	// 時間tでw回移動している時にりんごが取れる場合は1，そうでない場合は0を返す
	int apple(int t, int w) {
		return ((W - w) % 2) == (tree[t] - 1) ? 1 : 0;
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}
