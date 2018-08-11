import java.util.Scanner;

public class Main {
	final int MAX_P = 100000 * 10000;
	int n, k;
	int[] w;
	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextInt();
		w = new int[n];
		for (int i = 0; i < n; i++)
			w[i] = scan.nextInt();

		int low = 0;
		int hight = MAX_P;
		while (low <= hight) {
			int mid = (low + hight) / 2;
			if (canPile(mid))
				hight = mid - 1;
			else
				low = mid + 1;
		}
		System.out.println(hight);
	}
	
	boolean canPile(int p) {
		int sum = 0;
		int index = 0;

		for (int i = 0; i < k; i++) {
			sum = 0;
			while (sum + w[index] < p) {
				sum += w[index];
				index++;
				if (index == n)
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
