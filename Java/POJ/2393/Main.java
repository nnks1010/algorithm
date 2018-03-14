import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int s = scan.nextInt();
		int[][] factory = new int[n][2];
		for (int i = 0; i < n; i++) {
			factory[i][0] = scan.nextInt();
			factory[i][1] = scan.nextInt();
		}
		long ans = factory[0][0] * factory[0][1];
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i - 1; j <= i; j++) {
				min = Math.min(min, factory[j][0] + ((i - j) * s));
			}
			ans += min * factory[i][1];
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
