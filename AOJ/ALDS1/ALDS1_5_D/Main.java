import java.util.Scanner;

public class Main {
	final int INF = Integer.MAX_VALUE;

	long mergeCount = 0;
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		mergeSort(a, 0, n);
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
			if (l[i] <= r[j]) {
				a[k] = l[i++];
			} else {
				mergeCount += n1 - i;
				a[k] = r[j++];
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
