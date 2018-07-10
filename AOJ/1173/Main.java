import java.util.Scanner;
import java.util.Stack;

public class Main {
	final int MARU = 1;
	final int KAKU = 2;
	final boolean DEBUG = false;
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String str = scan.nextLine();
			if (str.equals("."))
				break;
			if (DEBUG)
				System.out.println(str);
			boolean ans = true;
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				switch (c) {
				case '(':
					stack.push(MARU);
					break;
				case '[':
					stack.push(KAKU);
					break;
				case ')':
					if (stack.isEmpty()) {
						ans = false;
						break;
					}
					int m = stack.pop();
					if (m != MARU)
						ans = false;
					break;
				case ']':
					if (stack.isEmpty()) {
						ans = false;
						break;
					}
					int k = stack.pop();
					if (k != KAKU)
						ans = false;
					break;
				}
			}
			if (!stack.isEmpty())
				ans = false;
			System.out.println(ans ? "yes" : "no");
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
