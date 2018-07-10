import java.util.Scanner;

public class Main {
	static final int CHECK = 0;
	static final int RINGO = 1;
	static final int KAKI  = 2;
	static final int MIKAN = 3;
	
	int[][] field;
	int h, w, fruit;
	int[] dy = { 1, 0, -1,  0 };
	int[] dx = { 0, 1,  0, -1 };

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			h = scan.nextInt();
			w = scan.nextInt();
			if (h + w == 0)
				break;
			field = new int[h][];
			for (int i = 0; i < h; i++) {
				field[i] = new int[w];
				char[] f = scan.next().toCharArray();
				for (int j = 0; j < w; j++) {
					if (f[j] == '@')
						field[i][j] = RINGO;
					else if (f[j] == '#')
						field[i][j] = KAKI;
					else
						field[i][j] = MIKAN;
				}
			}
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (field[i][j] != CHECK) {
						ans++;
						fruit = field[i][j];
						dfs(i, j);
					}
				}
			}
			System.out.println(ans);
		}
	}

	void dfs(int y, int x) {
		if (y < 0 || x < 0 || y >= h || x >= w || field[y][x] != fruit)
			return;
		field[y][x] = CHECK;

//		なぜかエラーが起きる．探すのに2時間かかった．キレそう
//		for (int i = 0; i < 4; i++)
//			bfs(y + dy[i], x + dx[i]);

		dfs(y + 0, x + 1);
		dfs(y + 0, x - 1);
		dfs(y + 1, x + 0);
		dfs(y - 1, x + 0);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
