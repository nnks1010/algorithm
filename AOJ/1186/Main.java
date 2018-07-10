import java.util.Scanner;

public class Main {
	static final int MAX_LENGTH = 150;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			if (h + w == 0)
				break;
			int min = Integer.MAX_VALUE;
			int root = h * h + w * w;
			int min_h = 0;
			int min_w = 0;
			for (int i = 1; i <= MAX_LENGTH; i++) {
				for (int j = i + 1; j <= MAX_LENGTH; j++) {
					int r = i * i + j * j;
					if (r > root || (r == root && i > h)) {
						if (min > r || (root == r && i < min_h)) {
							min = Math.min(min, r);
							min_h = i;
							min_w = j;
						}
					}
				}
			}
			System.out.println(min_h + " " + min_w);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
