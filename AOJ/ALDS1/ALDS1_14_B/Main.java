import java.util.Scanner;

public class Main {
	final boolean DEBUG = true;
	final long b = 1000000007l;
	final long h = 1 << 63;
	void run() {
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		char[] txt = scan.next().toCharArray();
		char[] pat = scan.next().toCharArray();
		int tl = txt.length;
		int pl = pat.length;
		if (tl < pl)
			return;
		
		long t = 1, ph = 0, th = 0;
		for (int i = 0; i < pl; i++) {
			t = (t * b) % h;
			ph = (b * ph + pat[i]) % h;
			th = (b * th + txt[i]) % h;
		}
		
		for (int i = 0; i <= tl - pl; i++) {
			if (ph == th)
				sb.append(i + "\n");
			if (i + pl < tl)
				th = (th * b + txt[i + pl] - txt[i] * t) % h;
		}
		System.out.print(sb.toString());
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
