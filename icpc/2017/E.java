import java.util.Scanner;
import java.util.Stack;

public class E {
	final int VAR = 4;
	final int MAX_LEN = 16;
	final int PATTERN = 1 << (1 << VAR);

	int[] tables;

	void init() {
		tables = new int[PATTERN];
		for (int i = 0; i < PATTERN; i++)
			tables[i] = MAX_LEN;
		dfs("", -3, -1);
	}

	void dfs(String exp, int len, int nOpen) {
		System.out.println(len + ": " + nOpen + " :" + exp);
		if (nOpen == 0)
			compute(exp, len);
		if (len + 4 <= MAX_LEN) {
			dfs(exp + "0", len + 4, nOpen + 1);
			dfs(exp + "1", len + 4, nOpen + 1);
			dfs(exp + "a", len + 4, nOpen + 1);
			dfs(exp + "b", len + 4, nOpen + 1);
			dfs(exp + "c", len + 4, nOpen + 1);
			dfs(exp + "d", len + 4, nOpen + 1);
		}
		if (len >= 1 && len + 1 <= MAX_LEN)
			dfs(exp + "-", len + 1, nOpen);
		if (nOpen > 0) {
			dfs(exp + "^", len, nOpen - 1);
			dfs(exp + "*", len, nOpen - 1);
		}
	}
	
	void compute(String exp, int len) {
		int value = eval(exp);
		tables[value] = Math.min(tables[value], len);
	}
	
	int eval(String exp) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < exp.length(); i++) {
			int v0, v1;
			switch (exp.charAt(i)) {
			case '0': stack.push(0x0000); break;
			case '1': stack.push(0xffff); break;
			case 'a': stack.push(0xff00); break;
			case 'b': stack.push(0xf0f0); break;
			case 'c': stack.push(0xcccc); break;
			case 'd': stack.push(0xaaaa); break;
			case '-':
				int v = stack.pop();
				stack.push(v ^ 0xffff);
				break;
			case '*':
				v0 = stack.pop();
				v1 = stack.pop();
				stack.push(v0 & v1);
				break;
			case '^':
				v0 = stack.pop();
				v1 = stack.pop();
				stack.push(v0 ^ v1);
				break;
			}
		}
		return stack.pop();
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String exp = scan.next();
			if (exp.equals("."))
				break;
			System.out.println(tables[eval(exp, 0)]);
		}
	}
	
	int eval(String exp, int index) {
		switch(exp.charAt(index)) {
		case '1': return 0xffff;
		case '0': return 0x0000;
		case 'a': return 0xff00;
		case 'b': return 0xf0f0;
		case 'c': return 0xcccc;
		case 'd': return 0xaaaa;
		case '-': return eval(exp, index + 1) ^ 0xffff;
		case '(':
			index++;
			int l = eval(exp, index);
			while (exp.charAt(index) == '-')
				index++;
			if (exp.charAt(index++) == '(') {
				index++;
				for (int i = 1; i > 0; index++) {
					if (exp.charAt(index) == '(') i++;
					if (exp.charAt(index) == ')') i--;
				}
			}
			char op = exp.charAt(index);
			int r = eval(exp, index + 1);
			if (op == '*')
				return l & r;
			else
				return l ^ r;
		}
		throw new Error(exp + "["+index+"]");
	}

	public static void main(String[] args) {
		E e = new E();
		e.init();
		e.run();
	}
}
