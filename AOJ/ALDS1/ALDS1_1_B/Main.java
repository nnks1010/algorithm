import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		if (y > x) {
			int swap = x;
			x = y;
			y = swap;
		}
		while (x > y) {
			int n = x % y;
			if (n == 0) break;
			x = y;
			y = n;
		}
		System.out.println(y);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
