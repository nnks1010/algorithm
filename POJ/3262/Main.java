import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] cow = new int[n][2];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			cow[i][0] = scan.nextInt();
			cow[i][1] = scan.nextInt();
			sum += cow[i][1];
		}
		Arrays.sort(cow, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int d1 = o1[0] * o2[1];
				int d2 = o1[1] * o2[0];
				if (d1 < d2) {
					return -1;
				} else if (d1 > d2) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		long ans = 0;
		for (int i = 0; i < n; i++) {
			sum -= cow[i][1];
			ans += sum * cow[i][0] * 2;
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
