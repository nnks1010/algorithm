import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Pazzle {
		int y, x;
		int[][] board;
		Pazzle(int y, int x, int[][] board) {
			this.y = y;
			this.x = x;
			this.board = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					this.board[i][j] = board[i][j];
		}
		Pazzle(Pazzle p) {
			this.y = p.y;
			this.x = p.x;
			board = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					board[i][j] = p.board[i][j];
		}
		String boardToString() {
			String str = "";
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					str += Integer.toString(board[i][j]);
				}
			}
			return str;
		}
		void swapBoard(int ny, int nx) {
			int tmp = board[y][x];
			board[y][x] = board[ny][nx];
			board[ny][nx] = tmp;
			y = ny;
			x = nx;
		}
		void printDebug() {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
	final int N = 3;
	int[][] board;
	void run() {
		Scanner scan = new Scanner(System.in);

		board = new int[N][N];
		int y = 0, x = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = scan.nextInt();
				if (board[i][j] == 0) {
					y = i;
					x = j;
				}
			}
		}
		Queue<Pazzle> que = new LinkedList<Pazzle>();
		HashSet<String> hash = new HashSet<String>();
		que.add(new Pazzle(y, x, board));
		String ansPazzle = "123456780";
		int ans = 0;
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		while (!que.isEmpty()) {
			int length = que.size();
			for (int i = 0; i < length; i++) {
				Pazzle p = que.poll();
				String boardStr = p.boardToString();
				if (boardStr.equals(ansPazzle)) {
					System.out.println(ans);
					return;
				}
				hash.add(boardStr);
				for (int j = 0; j < 4; j++) {
					int ny = p.y + dy[j];
					int nx = p.x + dx[j];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
						Pazzle np = new Pazzle(p);
						np.swapBoard(ny, nx);
						if (hash.contains(np.boardToString()))
							continue;
						que.add(np);
					}
				}
			}
			ans++;
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
