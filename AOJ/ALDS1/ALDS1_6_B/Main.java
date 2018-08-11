import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		
		int baseIndex = partition(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			if (i == baseIndex)
				System.out.print("[" + a[i] + "]");
			else
				System.out.print(a[i]);
			System.out.print(i == n - 1 ? "\n" : " ");
		}
	}
	
	int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i += 1;
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		int tmp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = tmp;
		return i + 1;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
