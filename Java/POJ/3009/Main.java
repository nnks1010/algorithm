import java.util.Scanner;

public class Main {
	static final boolean VACANT = true;
	static final boolean BLOCK = false;
	static final int MAX_DEEP = 10;

	int w, h;
	int gy, gx;
	boolean[][] board;
	int[] dy = { 1, 0, -1, 0 };
	int[] dx = { 0, 1, 0, -1 };

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			w = scan.nextInt();
			h = scan.nextInt();
			if (w + h == 0)
				break;
			board = new boolean[h][w];
			int sy = 0, sx = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					int n = scan.nextInt();
					board[i][j] = n == 1 ? BLOCK : VACANT;
					if (n == 2) {
						sy = i;
						sx = j;
					}
					if (n == 3) {
						gy = i;
						gx = j;
					}
				}
			}
			int ans = dfs(sy, sx, 0);
			System.out.println(ans != MAX_DEEP + 1 ? ans : -1);
		}
	}

	int dfs(int y, int x, int d) {
		if (d == MAX_DEEP)
			return d + 1;
		int min = MAX_DEEP + 1;

		for (int i = 0; i < 4; i++) {
			int cy = y + dy[i], cx = x + dx[i];
			// 1マス先が壁やブロックならば動かさない
			if (cy < 0 || cx < 0 || cy >= h || cx >= w)
				continue;
			if (board[cy][cx] == BLOCK)
				continue;
			// カールの移動
			while (true) {
				// ゴールに到達する場合
				if (cy == gy && cx == gx)
					return d + 1;
				int ny = cy + dy[i], nx = cx + dx[i];
				// 壁に当たる場合
				if (ny < 0 || nx < 0 || ny >= h || nx >= w)
					break;
				// ブロックに当たる場合
				if (board[ny][nx] == BLOCK) {
					board[ny][nx] = VACANT;
					min = Math.min(min, dfs(cy, cx, d + 1));
					board[ny][nx] = BLOCK;
					break;
				}
				cy = ny;
				cx = nx;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
