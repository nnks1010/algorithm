import java.util.Scanner;

public class Main {
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

			int[][] map = new int[MAX_N * 2 + 1][MAX_N * 2 + 1];
			for (int i = 0; i <= MAX_N * 2; i++)
				for (int j = 0; j <= MAX_N * 2; j++)
					map[i][j] = -1;

			map[MAX_N][MAX_N] = 0;
			int[] dy = {  0, 1, 0, -1 };
			int[] dx = { -1, 0, 1,  0 };
			for (int k = 1; k < N; k++) {
				int n = scan.nextInt();
				int d = scan.nextInt();
				int x = 0, y = 0;
				for (int i = 0; i <= MAX_N * 2; i++) {
					for (int j = 0; j <= MAX_N * 2; j++) {
						if (map[i][j] == n) {
							y = i;
							x = j;
						}
					}
				}
//				System.out.println(y + " " + x);
				map[y + dy[d]][x + dx[d]] = k;
			}


			int hh = 0;
			label: for (int i = 0; i <= MAX_N * 2; i++) {
				for (int j = 0; j <= MAX_N * 2; j++) {
					if (map[i][j] != -1) {
						hh = i;
						break label;
					}
				}
			}
			int ll = 0;
			label: for (int i = MAX_N * 2; i >= 0; i--) {
				for (int j = MAX_N * 2; j >= 0; j--) {
					if (map[i][j] != -1) {
						ll = i;
						break label;
					}
					
				}
			}

			int hl = 0;
			label: for (int j = 0; j <= MAX_N * 2; j++) {
				for (int i = 0; i <= MAX_N * 2; i++) {
					if (map[i][j] != -1) {
						hl = j;
						break label;
					}
				}
			}

			int lr = 0;
			label: for (int j = MAX_N * 2; j >= 0; j--) {
				for (int i = MAX_N * 2; i >= 0; i--) {
					if (map[i][j] != -1) {
						lr = j;
						break label;
					}
				}
			}
			System.out.println((lr - hl + 1) + " " + (ll - hh + 1));
			
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
