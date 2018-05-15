import java.util.Scanner;

public class Main {
	final int N = 6;
	final int MAX_V = 20000 * N + 1;
	void run() {
		Scanner scan = new Scanner(System.in);
		for (int k = 1; ; k++) {
			int[] marbles = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				marbles[i] = scan.nextInt();
				sum += marbles[i] * (i + 1);
			}
			if (sum == 0)
				break;

			int[] dp = new int[MAX_V];
			for (int j = 0; j < MAX_V; j++)
				dp[j] = -1;

			dp[0] = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < MAX_V; j++) {
					if (dp[j] >= 0)
						dp[j] = marbles[i];
					if (j - (i + 1) >= 0)
						dp[j] = Math.max(dp[j], dp[j - (i + 1)] - 1);
				}
//				for (int j = 0; j <= 12; j++)
//					System.out.print(dp[j] + " ");
//				System.out.println();
			}
//			System.out.println();
			
			System.out.println("Collection #" + k + ":");
			if (sum % 2 == 0 && dp[sum / 2] >= 0)
				System.out.println("Can be divided.");
			else
				System.out.println("Can't be divided.");

			System.out.println();
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
