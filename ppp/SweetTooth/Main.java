/*
 * 甘いもの好き
 * fn: ジェレミーの最大利得
 * fn = (1 - x) + fn-1
 * x: (3 - n + 2fn-1) / 4
 * {(n - 1) - fn-1} + x = (n - 1) + (1 - x)
 * f2 = 5/4
 */

import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		float jCake = 5 / 4;
		for (int i = 2; i <= n; i++)
			jCake = ((i + 1) + 2 * (jCake)) / 4;
		System.out.println(jCake);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
