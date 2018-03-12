import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		for (int count = 1; true; count++) {
			int n = scan.nextInt();
			int d = scan.nextInt();
			if (n + d == 0)
				break;
			double[][] field = new double[n][2];
			boolean impossible = false;
			for (int i = 0; i < n; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				if (y > d)
					impossible = true;
				double side = Math.sqrt(Math.abs(d * d - y * y));
				field[i][0] = x - side;
				field[i][1] = x + side;
			}
			if (impossible) {
				System.out.printf("Case %d: -1\n", count);
				continue;
			}
			Arrays.sort(field, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					if (o1[1] == o2[1]) return 0;
					return o1[1] > o2[1]? 1 : -1;
				}
			});
//			for (int i = 0; i < field.length; i++) {
//				System.out.println(Arrays.toString(field[i]));
//			}
//			System.out.println();
			int radar = 1;
			double term = field[0][1]; // 終端を記録
			for (int i = 0; i < n; i++) {
//				System.out.println(term + " < " + field[i][0] + " : " + field[i][1]);
				if (term < field[i][0]) {
					radar++;
					term = field[i][1];
				}
			}
			System.out.printf("Case %d: %d\n", count, radar);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
