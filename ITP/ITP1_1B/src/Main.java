import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		System.out.println((int)Math.pow(x, 3));
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
