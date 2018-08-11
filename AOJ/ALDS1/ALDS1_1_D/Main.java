import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int min = scan.nextInt();
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			int r = scan.nextInt();
			ans = Math.max(ans, r - min);
			min = Math.min(min, r);
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
