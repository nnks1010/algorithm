import java.util.Scanner;
import java.util.Stack;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		while (scan.hasNext()) {
			String token = scan.next();
			switch (token) {
			case "+": {
				int v1 = stack.pop();
				int v2 = stack.pop();
				stack.push(v2 + v1);
				break;
			}
			case "-": {
				int v1 = stack.pop();
				int v2 = stack.pop();
				stack.push(v2 - v1);
				break;
			}
			case "*": {
				int v1 = stack.pop();
				int v2 = stack.pop();
				stack.push(v2 * v1);
				break;
			}
			default: {
				stack.push(Integer.valueOf(token));
				break;
			}
			}
		}
		System.out.println(stack.pop());
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
