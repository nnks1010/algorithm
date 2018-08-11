import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	final int MAX_N = 44;
	void run() {
		Scanner scan = new Scanner(System.in);
		int[] dp = new int[MAX_N + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= MAX_N; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		int n = scan.nextInt();
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
