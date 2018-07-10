import java.util.Scanner;

public class Main {
	final int MAX_N = 123456;

	boolean[] prime;
	void run() {
		Scanner scan = new Scanner(System.in);
		prime = new boolean[MAX_N * 2 + 1];
		sieve();
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				return;
			int ans = 0;
			for (int i = n + 1; i <= n * 2; i++)
				ans += prime[i] ? 1 : 0;
			System.out.println(ans);
		}
	}
	void sieve() {
		prime[2] = true;
		for (int i = 3; i <= MAX_N * 2; i += 2)
			prime[i] = true;

		for (int i = 3; i < Math.sqrt(MAX_N * 2 + 1); i += 2) {
			if (!prime[i])
				continue;
			for (int j = i * 2; j <= MAX_N * 2; j += i)
				prime[j] = false;
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
