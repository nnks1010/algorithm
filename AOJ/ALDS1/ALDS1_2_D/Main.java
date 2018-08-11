import java.util.Scanner;

public class Main {
	int cnt;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		shellSort(a, n);
	}

	void insertSort(int[] a, int n, int g) {
		for (int i = g; i < n; i++) {
			int v = a[i];
			int j = i - g;
			while (j >= 0 && a[j] > v) {
				a[j + g] = a[j];
				j -= g;
				cnt++;
			}
			a[j + g] = v;
		}
	}

	void shellSort(int[] a, int n) {
		cnt = 0;
		int m = 0;
		if (a.length == 1) {
			m = a.length;
		} else {
			for (int i = a.length; i > 1; i /= 2)
				m++;
		}
		int[] g = new int[m];
		if (m == 1) {
			g[0] = 1;
		} else {
			for (int i = 0, len = a.length / 2; i < m; i++, len /= 2)
				g[i] = len;
		}

		System.out.println(m);
		for (int i = 0; i < m; i++)
			System.out.print(g[i] + (i != m - 1 ? " ":"\n"));

		for (int i = 0; i < m; i++)
			insertSort(a, n, g[i]);

		System.out.println(cnt);
		for (int i = 0; i < n; i++)
			System.out.println(a[i]);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
