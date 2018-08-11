import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		boolean reverseElement = true;
		int count = 0;
		while (reverseElement) {
			reverseElement = false;
			for (int j = n - 1; j >= 1; j--) {
				if (a[j] < a[j - 1]) {
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
					reverseElement = true;
					count++;
				}
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + (i != n - 1 ? " ":"\n"));
		System.out.println(count);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
