import java.util.Scanner;

public class Main {
	int[] ball;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			ball = new int[10];
			for (int j = 0; j < 10; j++) {
				ball[j] = scan.nextInt();
			}
			if (dfs(0, 0, 0))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	boolean dfs(int l, int r, int d) {
		if (d == 10) return true;
		if (l < ball[d]) {
			return dfs(ball[d], r, d+1);
		} else if (r < ball[d]) {
			return dfs(l, ball[d], d+1);
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
