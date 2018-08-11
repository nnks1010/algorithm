import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int min_j = i;
			for (int j = i; j < n; j++) {
				if (a[j] < a[min_j])
					min_j = j;
			}
			if (i != min_j)
				count++;
			int tmp = a[i];
			a[i] = a[min_j];
			a[min_j] = tmp;
		}
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + (i != n - 1 ? " ":"\n"));
		System.out.println(count);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
