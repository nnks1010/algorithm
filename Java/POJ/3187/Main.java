import java.util.Scanner;

public class Main {
	int n, sum;
	int[] pattern;
	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		sum = scan.nextInt();
		pattern = new int[n];
		dfs(0);
	}

	boolean dfs(int d) {
		if (d == n) {
			// debug
//			for (int i = 0; i < n; i++) {
//				System.out.print(pattern[i] + " ");
//			}
//			System.out.println();
			int[][] array = new int[n][n];
			array[0] = pattern.clone();
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					array[i + 1][j] = array[i][j] + array[i][j + 1];
				}
			}
			if (array[n - 1][0] == sum) {
				for (int i = 0; i < n; i++) {
					if (i == 0)
						System.out.print(array[0][i]);
					else
						System.out.print(" " + array[0][i]);
				}
				System.out.println();
				return true;
			}
			return false;
		}
		for (int i = 0; i < n; i++) {
			boolean flg = false;
			for (int j = 0; j < n; j++) {
				if (pattern[j] == i + 1) flg = true;
			}
			if (flg) continue;
			pattern[d] = i + 1;
			if (dfs(d + 1)) return true;
			pattern[d] = 0;
		}
		return false;
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
