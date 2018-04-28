import java.util.Scanner;

public class Main {
	final int MAX_V = 10;
	final int MAX_C = 100000;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				break;
			int[][] d = new int[MAX_V][MAX_V];
			boolean[] v = new boolean[MAX_C];

			for (int i = 0; i < MAX_V; i++)
				for (int j = 0; j < MAX_V; j++)
					d[i][j] = MAX_C;
			for (int i = 0; i < MAX_V; i++)
				d[i][i] = 0;

			for (int i = 0; i < n; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				int c = scan.nextInt();
				d[a][b] = c;
				d[b][a] = c;
				v[a] = v[b] = true;
			}
			for (int k = 0; k < MAX_V; k++)
				for (int i = 0; i < MAX_V; i++)
					for (int j = 0; j < MAX_V; j++)
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

//			for (int i = 0; i < 5; i++) {
//				for (int j = 0; j < 5; j++)
//					System.out.print((d[i][j] != MAX_C ? d[i][j] : "X") + " ");
//				System.out.println();
//			}
			int ans_v = 0;
			int ans_c = MAX_C;
			for (int i = 0; i < MAX_V; i++) {
				int sum = 0;
				if (!v[i]) continue;
				for (int j = 0; j < MAX_V; j++) {
					if (d[i][j] != MAX_C)
						sum += d[i][j];
//					System.out.print((d[i][j] != MAX_C? d[i][j]:"X") + " ");
				}
//				System.out.println(": " + sum);
				if (ans_c > sum) {
					ans_c = sum;
					ans_v = i;
				}
			}
			System.out.println(ans_v + " " + ans_c);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
