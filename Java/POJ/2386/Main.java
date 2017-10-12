import java.util.Scanner;

public class Main {
	int n, m;
	char[][] map;
	static final char CHECK = 'x';
	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = scan.next().toCharArray();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 'W') continue;
				cnt++;
				solve(i, j);
			}
		}
		System.out.println(cnt);
	}
	
	void solve(int y, int x) {
		if (y < 0 || x < 0 || y >= n || x >= m) return;
		if (map[y][x] != 'W') return;
		map[y][x] = CHECK;
		int[] dy = { -1, -1, -1,  0, 0,  1, 1, 1 };
		int[] dx = { -1,  0,  1, -1, 1, -1, 0, 1 };
		for (int i = 0; i < 8; i++) {
			solve(y + dy[i], x + dx[i]);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
