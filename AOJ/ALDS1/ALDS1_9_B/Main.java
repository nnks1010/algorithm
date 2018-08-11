import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int[] heap = new int[h + 1];
		for (int i = 1; i <= h; i++)
			heap[i] = scan.nextInt();
		buildMaxHeap(heap);
		for (int i = 1; i <= h; i++)
			System.out.print(" " + heap[i]);
		System.out.println();
	}
	
	void maxHeapify(int[] a, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest = 0;
		if (left <= (a.length - 1) && a[left] > a[i])
			largest = left;
		else
			largest = i;
		if (right <= (a.length - 1) && a[right] > a[largest])
			largest = right;
		if (largest != i) {
			int tmp = a[i];
			a[i] = a[largest];
			a[largest] = tmp;
			maxHeapify(a, largest);
		}
	}
	
	void buildMaxHeap(int[] a) {
		for (int i = (a.length - 1) / 2; i >= 1; i--)
			maxHeapify(a, i);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
