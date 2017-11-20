import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int[] ball = new int[10];
			for (int j = 0; j < 10; j++)
				ball[j] = scan.nextInt();
			int l = 0;
			int r = 0;
			boolean impossible = false;
			for (int j = 0; j < 10; j++) {
				if (l < ball[j]) {
					l = ball[j];
				} else if (r < ball[j]) {
					r = ball[j];
				} else {
					impossible = true;
				}
			}
			System.out.println(impossible? "NO":"YES");
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
