import java.util.Scanner;

public class Main {
	final int INF = Integer.MAX_VALUE;

	int mergeCount = 0;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = scan.nextInt();
		mergeSort(s, 0, n);
		for (int i = 0; i < n; i++)
			System.out.print(s[i] + (i == n - 1 ? "\n" : " "));
		System.out.println(mergeCount);
	}
	
	void mergeSort(int[] a, int left, int right) {
		if (left + 1 < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid, right);
			merge(a, left, mid, right);
		}
	}
	
	void merge(int[] a, int left, int mid, int right) {
		int n1 = mid - left;
		int n2 = right - mid;

		int[] l = new int[n1 + 1];
		int[] r = new int[n2 + 1];
		for (int i = 0; i < n1; i++)
			l[i] = a[left + i];
		for (int i = 0; i < n2; i++)
			r[i] = a[mid + i];
		l[n1] = r[n2] = INF;
		
		int i = 0, j = 0;
		for (int k = left; k < right; k++) {
			mergeCount++;
			if (l[i] <= r[j])
				a[k] = l[i++];
			else
				a[k] = r[j++];
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
