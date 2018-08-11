import java.util.Scanner;

public class Main {
	final int MAX_N = 2000000;
	final int K = 10000;
	
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n + 1];
		int[] b = new int[n + 1];

		for (int j = 1; j <= n; j++)
			a[j] = scan.nextInt();
		countingSort(a, b, K);

		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < n; i++)
			builder.append(b[i] + " ");
		System.out.println(builder.append(b[n]));
	}

	void countingSort(int[] a, int[] b, int k) {
		int[] c = new int[k + 1];
		for (int i = 1; i < a.length; i++)
			c[a[i]] += 1;
		
		for (int i = 1; i <= k; i++)
			c[i] += c[i - 1];
		
		for (int j = a.length - 1; j >= 1; j--) {
			b[c[a[j]]] = a[j];
			c[a[j]]--;
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
