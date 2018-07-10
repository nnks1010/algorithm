import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int m = scan.nextInt();
			int n_min = scan.nextInt();
			int n_max = scan.nextInt();
			if (m + n_min + n_max == 0)
				break;
			int[] p = new int[m];
			for (int i = 0; i < m; i++) {
				p[i] = scan.nextInt();
			}
			int n = 0;
			int ans = 0;
			for (int i = 0; i < m; i++) {
				if (i >= n_min - 1 && i < n_max) {
					if (n <= p[i] - p[i + 1]) {
						n = p[i] - p[i + 1];
						ans = i + 1;
					}
				}
			}
			System.out.println(ans);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
