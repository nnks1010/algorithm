import java.util.Scanner;

public class Main {
	class Pair {
		int y, x;
		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	final int MAX_N = 200;
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int N = scan.nextInt();
			if (N == 0)
				return;
			if (N == 1) {
				System.out.println(1 + " " + 1);
				continue;
			}
			Pair[] pairs = new Pair[N];
			pairs[0] = new Pair(0, 0);
			int[] dy = { 0, -1, 0, 1 };
			int[] dx = { -1, 0, 1, 0 };
			for (int i = 1; i < N; i++) {
				int n = scan.nextInt();
				int d = scan.nextInt();
				Pair p = pairs[n];
				pairs[i] = new Pair(p.y + dy[d], p.x + dx[d]);
			}
			int max_x = 0, max_y = 0;
			int min_x = 0, min_y = 0;
			for (int i = 0; i < N; i++) {
				max_x = Math.max(max_x, pairs[i].x);
				max_y = Math.max(max_y, pairs[i].y);
				min_x = Math.min(min_x, pairs[i].x);
				min_y = Math.min(min_y, pairs[i].y);
			}
			System.out.println((max_x - min_x + 1) + " " + (max_y - min_y + 1));
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
