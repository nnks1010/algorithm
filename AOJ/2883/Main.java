import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String s = scan.next();
			if (s.equals("."))
				return;
			String p = scan.next();
			int pHash = eval(s, p);
			int hashSum = 0;
			for (int i = 0; i <= 9999; i++) {
				int num  = i;
				String pass = Integer.toString(num / 1000);
				num -= 1000 * (num / 1000);
				pass += Integer.toString(num / 100);
				num -= 100 * (num / 100);
				pass += Integer.toString(num / 10);
				num -= 10 * (num / 10);
				pass += Integer.toString(num);
				if (pHash == eval(s, pass))
					hashSum++;
			}
			System.out.println(pHash + " " + hashSum);
		}
	}
	
	int eval(String s, String p) {
//		System.out.println(s);
		if (s.length() == 1) {
			switch(s) {
			case "a": return p.charAt(0) - '0';
			case "b": return p.charAt(1) - '0';
			case "c": return p.charAt(2) - '0';
			case "d": return p.charAt(3) - '0';
			default:
				throw new Error("internal error: " + s);
			}
		}
		int index = 1;
		char op = s.charAt(index++);
		int lhv = 0, rhv = 0;
//		System.out.println("left");
		if (s.charAt(index) != '[') {
			lhv = eval(s.substring(index, index + 1), p);
			index++;
		} else {
			int idx = index;
			int kakko = 1;
			while (kakko != 0) {
				idx++;
				if (s.charAt(idx) == '[') kakko++;
				else if (s.charAt(idx) == ']') kakko--;
			}
//			System.out.println("lhv: " + s + " " + index + " " + idx);
//			System.out.println(s.substring(index, idx + 1));
			lhv = eval(s.substring(index, idx + 1), p);
			index = idx + 1;
		}
//		System.out.println("right");
		if (s.charAt(index) != '[') {
			rhv = eval(s.substring(index, index + 1), p);
		} else {
			int idx = index;
			int kakko = 1;
			while (kakko != 0) {
				idx++;
				if (s.charAt(idx) == '[') kakko++;
				else if (s.charAt(idx) == ']') kakko--;
			}
//			System.out.println("rhv: " + s + " " + index + " " + idx);
//			System.out.println(s.substring(index, idx + 1));
			rhv = eval(s.substring(index, idx + 1), p);
		}
		switch(op) {
		case '+': return lhv | rhv;
		case '*': return lhv & rhv;
		case '^': return lhv ^ rhv;
		default:
			throw new Error("internal error");
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
