import java.util.HashSet;
import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		HashSet<String> dic = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			String inst = scan.next();
			String str = scan.next();
			switch (inst) {
			case "insert":
				dic.add(str);
				break;
			case "find":
				System.out.println(dic.contains(str) ? "yes" : "no");
				break;
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
