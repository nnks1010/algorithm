import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println(a * b + " " + (a * 2 + b * 2));
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
