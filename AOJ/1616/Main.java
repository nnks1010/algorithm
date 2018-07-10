import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			if (n + m == 0)
				break;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					int sum = a[i] + a[j];
					if (sum <= m)
						ans = Math.max(ans, sum);
				}
			}
			if (ans != 0) {
				System.out.println(ans);
			} else {
				System.out.println("NONE");
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
