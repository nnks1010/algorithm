import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		int[][] map = new int[r + 2][c + 2];
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				map[i][j] = scan.nextInt();
				que.add(map[i][j]);
			}
		}
		int[][] dp = new int[r + 2][c + 2];
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int ans = 0;
		while (!que.isEmpty()) {
			int cur = que.poll();
			label: for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					if (map[i][j] == cur && dp[i][j] == 0) {
						dp[i][j] = 1;
					for (int k = 0; k < 4; k++) {
						int y = i + dy[k];
						int x = j + dx[k];
						if (cur > map[y][x])
							dp[i][j] = Math.max(dp[i][j], dp[y][x] + 1);
					}
					ans = Math.max(ans, dp[i][j]);
					break label;
					}
				}
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
