import java.util.Scanner;
import java.util.Stack;

public class Main {
	class Pond {
		int index, ans;
		Pond(int index, int ans) {
			this.index = index;
			this.ans = ans;
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		char[] a = scan.next().toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Pond> ans = new Stack<Pond>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == '\\')
				stack.push(i);
			else if (a[i] == '/') {
				if (stack.isEmpty())
					continue;
				int n = stack.pop();
				Pond pond = new Pond(n, i - n);
				while (!ans.isEmpty()) {
					Pond p = ans.pop();
					if (p.index < pond.index) {
						ans.push(p);
						break;
					}
					pond = new Pond(pond.index, p.ans + pond.ans);
				}
				ans.push(pond);
			}
		}
		int sum = 0;
		for (int i = 0; i < ans.size(); i++)
			sum += ans.get(i).ans;
		System.out.println(sum);

		System.out.print(ans.size());
		for (int i = 0; i < ans.size(); i++)
			System.out.print(" " + ans.get(i).ans);
		System.out.println();
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
