import java.util.Scanner;

public class Main {
	static final int[] HAIKU = { 5, 7, 5, 7, 7 };
	int n;
	int[] w;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			n = scan.nextInt();
			if (n == 0)
				break;
			w = new int[n];
			for (int i = 0; i < n; i++)
				w[i] = scan.next().length();

			int index = 0, sum = 0, count = 0;
			int i = index;
			while (i < n) {
				sum += w[i++];
				if (sum == HAIKU[count]) {
					sum = 0;
					count++;
				} else if (sum > HAIKU[count]) {
					index++;
					i = index;
					sum = 0;
					count = 0;
				}
				if (count == HAIKU.length) {
					System.out.println(index + 1);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
