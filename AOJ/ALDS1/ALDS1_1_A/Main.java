import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = scan.nextInt();
		for (int i = 1; i < n; i++) {
			for (int k = 0; k < n; k++)
				System.out.print(array[k] + (k == n - 1 ? "": " "));
			System.out.println();
			int v = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > v) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = v;
		}
		for (int k = 0; k < n; k++)
			System.out.print(array[k] + (k == n - 1 ? "": " "));
		System.out.println();
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
