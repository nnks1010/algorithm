import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int s = scan.nextInt();
			if (x + y + s == 0)
				break;
			int max = 0;
			for (int i = 1; i < s; i++) {
				for (int j = 1; j < s; j++) {
					int xi = (i * (100 + x) / 100);
					int xj = (j * (100 + x) / 100);
					if (xi + xj == s) {
						int yi = (i * (100 + y) / 100);
						int yj = (j * (100 + y) / 100);
						max = Math.max(max, yi + yj);
					}
				}
			}
			System.out.println(max);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
