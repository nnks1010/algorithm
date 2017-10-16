import java.util.Scanner;

public class Main {
	int w, h;
	int[][] field;
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			w = scan.nextInt();
			h = scan.nextInt();
			if (w + h == 0)
				break;
			field = new int[h][];
			int sx = 0, sy = 0;
			for (int i = 0; i < h; i++) {
				field[i] = new int[w];
				char[] data = scan.next().toCharArray();
				for (int j = 0; j < w; j++) {
					if (data[j] == '.')
						field[i][j] = 0;
					else if (data[j] == '#')
						field[i][j] = 1;
					else {
						sx = j;
						sy = i;
						field[i][j] = 0;
					}
				}
			}
			int ans = solve(sy, sx);
			System.out.println(ans);
		}
	}
	int solve(int y, int x) {
		if (y < 0 || x < 0 || y >= h || x >= w)
			return 0;
		if (field[y][x] == 1)
			return 0;
		field[y][x] = 1;
		return 1 + solve(y-1, x) + solve(y+1, x) + solve(y, x-1) + solve(y, x+1);
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}
