import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	class Pazzle {
		int y, x;
		int turn, md, cost;
		int[][] board;
		Pazzle(int y, int x, int t, int[][] board) {
			this.y = y;
			this.x = x;
			this.turn = t;
			this.board = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					this.board[i][j] = board[i][j];
			setManhattanDist();
			cost = turn + md;
		}
		Pazzle(Pazzle p) {
			this.y = p.y;
			this.x = p.x;
			this.turn = p.turn + 1;
			board = new int[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					board[i][j] = p.board[i][j];
		}
		String boardToString() {
			String str = "";
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					str += Integer.toString(board[i][j]) + " ";
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
		void setManhattanDist() {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 0)
						continue;
					sum += Math.abs(i - ansPos[board[i][j]][0]) + Math.abs(j - ansPos[board[i][j]][1]);
				}
			}
			md = sum;
			cost = turn + md;
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
	final int N = 4;
	int[][] ansPos = {
			{3, 3}, {0, 0}, {0, 1}, {0, 2},
			{0, 3}, {1, 0}, {1, 1}, {1, 2},
			{1, 3}, {2, 0}, {2, 1}, {2, 2},
			{2, 3}, {3, 0}, {3, 1}, {3, 2}
	};
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
		PriorityQueue<Pazzle> que = new PriorityQueue<Pazzle>(new Comparator<Pazzle>() {
			@Override
			public int compare(Pazzle p1, Pazzle p2) {
				return p1.cost - p2.cost;
			}
		});
		HashSet<String> hash = new HashSet<String>();
		que.add(new Pazzle(y, x, 0, board));
		int[] dy = { 1, 0, -1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		while (!que.isEmpty()) {
			Pazzle p = que.poll();
			if (p.md == 0) {
				System.out.println(p.turn);
				return;
			}
			hash.add(p.boardToString());
			for (int j = 0; j < 4; j++) {
				int ny = p.y + dy[j];
				int nx = p.x + dx[j];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				Pazzle np = new Pazzle(p);
				np.swapBoard(ny, nx);
				if (hash.contains(np.boardToString()))
					continue;
				np.setManhattanDist();
				if (np.cost > 45)
					continue;
				que.add(np);
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
