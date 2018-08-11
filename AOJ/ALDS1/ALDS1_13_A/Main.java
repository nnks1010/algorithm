import java.util.Scanner;

public class Main {
	final int ROW = 0;
	final int COL = 1;
	final int QUEEN = 1;
	final int X = 2;

	boolean[] row, col, rDia, lDia; // -, |, /, \
	boolean[][] board;
	void run() {
		Scanner scan = new Scanner(System.in);
		board = new boolean[8][8];
		row = new boolean[8];
		col = new boolean[8];
		rDia = new boolean[2 * 8 - 1];
		lDia = new boolean[2 * 8 - 1];

		int k = scan.nextInt();
		for (int i = 0; i < k; i++) {
			int r = scan.nextInt();
			int c = scan.nextInt();
			board[r][c] = true;
			row[r] = true;
			col[c] = true;
			rDia[(c + (8 - 1)) - r] = true;
			lDia[r + c] = true;
		}
		dfs(0);
	}
	void dfs(int r) {
		if (r == 8) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++)
					System.out.print(board[i][j] == true ? "Q" : ".");
				System.out.println();
			}
			return;
		}
		if (row[r])
			dfs(r + 1);
		for (int i = 0; i < 8; i++) {
			if (!row[r] && !col[i] && !rDia[(i + (8 - 1)) - r] && !lDia[r + i]) {
				board[r][i] = true;
				row[r] = true;
				col[i] = true;
				rDia[(i + (8 - 1)) - r] = true;
				lDia[r + i] = true;
				dfs(r + 1);
				board[r][i] = false;
				row[r] = false;
				col[i] = false;
				rDia[(i + (8 - 1)) - r] = false;
				lDia[r + i] = false;
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
