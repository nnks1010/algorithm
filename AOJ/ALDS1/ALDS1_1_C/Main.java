import java.util.Scanner;

public class Main {
	final int MAX_N = 100000000;
	boolean[] primes;
	void eratosthenes() {
		primes = new boolean[MAX_N + 1];

		primes[2] = true;
		for (int i = 3; i <= MAX_N; i += 2)
			primes[i] = true;

		for (int i = 3; i <= Math.sqrt(MAX_N); i += 2) {
			if (!primes[i]) continue;
			for (int j = i * 2; j <= MAX_N; j += i)
				primes[j] = false;
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int v = scan.nextInt();
			ans += primes[v] ? 1 : 0;
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		Main main = new Main();
		main.eratosthenes();
		main.run();
	}
}
