import java.util.Scanner;

public class Main {
	final int N = 4;
	final int N2 = 16;
	final int LIMIT = 45;

	class Puzzle {
		int[] board = new int[N2];
		int space, md;
		Puzzle() {}
		Puzzle(Puzzle p) {
			space = p.space;
			md = p.md;
			for (int i = 0; i < N2; i++)
				board[i] = p.board[i];
		}
		int getAllMD() {
			int sum = 0;
			for (int i = 0; i < N2; i++) {
				if (board[i] == N2) continue;
				sum += mdt[i][board[i] - 1];
			}
			return sum;
		}
		void swap(int next, int cur) {
			int tmp = this.board[cur];
			this.board[cur] = this.board[next];
			this.board[next] = tmp;
		}
	}

	int limit = 0;
	int[] path = new int[LIMIT];
	int[][] mdt = new int[N2][N2];
	Puzzle state = null;
	char[] dir = {'r', 'u', 'l', 'd'};
	int[] dx = { 0, -1, 0, 1 };
	int[] dy = { 1, 0, -1, 0 };

	void run() {
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < N2; i++)
			for (int j = 0; j < N2; j++)
				mdt[i][j] = Math.abs(i / N - j / N) + Math.abs(i % N - j % N);

		Puzzle p = new Puzzle();
		
		for (int i = 0; i < N2; i++) {
			p.board[i] = scan.nextInt();
			if (p.board[i] == 0) {
				p.board[i] = N2;
				p.space = i;
			}
		}
		iterative_deepening(p);
	}
	boolean dfs(int depth, int prev) {
		if (state.md == 0) return true;
		if (depth + state.md > limit) return false;

		int sx = state.space / N;
		int sy = state.space % N;
		for (int i = 0; i < 4; i++) {
			int tx = sx + dx[i];
			int ty = sy + dy[i];
			if (tx < 0 || ty < 0 || tx >= N || ty >= N) continue;
			if (Math.max(prev, i) - Math.min(prev, i) == 2) continue;
			Puzzle p = new Puzzle(state);
			state.md -= mdt[tx * N + ty][state.board[tx * N + ty] - 1];
			state.md += mdt[sx * N + sy][state.board[tx * N + ty] - 1];
			state.swap(tx * N + ty, sx * N + sy);
			state.space = tx * N + ty;
			if (dfs(depth + 1, i)) {
				path[depth] = i;
				return true;
			}
			state = p;
		}
		return false;
	}
	void iterative_deepening(Puzzle p) {
		p.md = p.getAllMD();
		
		for (limit = p.md; limit <= LIMIT; limit++) {
			state = new Puzzle(p);
			if (dfs(0, -100)) {
				System.out.println(limit);
				return;
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
