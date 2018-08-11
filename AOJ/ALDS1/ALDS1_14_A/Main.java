import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		String t = scan.next();
		String p = scan.next();
		for (int i = 0; i <= t.length() - p.length(); i++) {
			if (t.substring(i, i + p.length()).equals(p))
				System.out.println(i);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
