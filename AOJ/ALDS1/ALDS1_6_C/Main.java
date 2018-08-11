import java.util.Scanner;

public class Main {
	class Card {
		char d;
		int v;
		Card(char d, int v) {
			this.d = d;
			this.v = v;
		}
		
		public String toString() {
			return this.d + " " + this.v;
		}
	}
	final int INF = Integer.MAX_VALUE;

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Card[] m = new Card[n];
		Card[] q = new Card[n];
		for (int i = 0; i < n; i++) {
			char d = scan.next().charAt(0);
			int v = scan.nextInt();
			m[i] = new Card(d, v);
			q[i] = new Card(d, v);
		}
		quickSort(q, 0, n - 1);
		mergeSort(m, 0, n);	// a stable sort
		
		boolean isStable = true;
		for (int i = 0; i < n; i++)
			if (!(q[i].v == m[i].v && q[i].d == m[i].d))
				isStable = false;
		
		System.out.println(isStable ? "Stable" : "Not stable");
		for (int i = 0; i < n; i++)
			System.out.println(q[i].toString());
	}
	
	void quickSort(Card[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}
	
	int partition(Card[] a, int p, int r) {
		int x = a[r].v;
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j].v <= x) {
				i += 1;
				Card tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		Card tmp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = tmp;
		return i + 1;
	}

	void mergeSort(Card[] a, int left, int right) {
		if (left + 1 < right) {
			int mid = (left + right) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid, right);
			merge(a, left, mid, right);
		}
	}
	
	void merge(Card[] a, int left, int mid, int right) {
		int n1 = mid - left;
		int n2 = right - mid;

		Card[] l = new Card[n1 + 1];
		Card[] r = new Card[n2 + 1];
		for (int i = 0; i < n1; i++)
			l[i] = a[left + i];
		for (int i = 0; i < n2; i++)
			r[i] = a[mid + i];
		l[n1] = r[n2] = new Card(' ', INF);
		
		int i = 0, j = 0;
		for (int k = left; k < right; k++) {
			if (l[i].v <= r[j].v)
				a[k] = l[i++];
			else
				a[k] = r[j++];
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
