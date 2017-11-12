import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		int[][] shift = new int[n][2];
		for (int i = 0; i < n; i++) {
			shift[i][0] = scan.nextInt();
			shift[i][1] = scan.nextInt();
		}
		Arrays.sort(shift, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
		int start = 0;
		int end = 1;
		int cows = 0;
		while (true) {
			int m = 0;
			for (int i = start; i < n; i++) {
				if (end < shift[i][0]) {
					start = i;
					break;
				}
				m = Math.max(m, shift[i][1]);
				if (i == n - 1 && m != t) {
					System.out.println(-1);
					return;
				}
			}
			cows++;
			if (m == t) {
				System.out.println(cows);
				return;
			} else if (m == 0) {
				System.out.println(-1);
				return;
			} else {
				end = m + 1;
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
