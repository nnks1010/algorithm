import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				break;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scan.nextInt();
			}
			int ans = Math.abs(a[0] - a[1]);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) continue;
					ans = Math.min(ans, Math.abs(a[i] - a[j]));
				}
			}
			System.out.println(ans);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
