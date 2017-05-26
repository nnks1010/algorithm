import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int time = scan.nextInt();
		int h = time / (60 * 60);
		time %= 60 * 60;
		int m = time / 60;
		int s = time % 60;
		System.out.println(h + ":" + m + ":" + s);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
