import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;

	class PriorityQueue {
		final int MAX_HEAP = 2000000 + 1;
		int[] heap;
		int h, startIndex;
		PriorityQueue() {
			this.heap = new int[MAX_HEAP];
			this.h = 0;
			this.startIndex = 1;
		}
		void insert(int k) {
			h++;
			this.heap[h] = k;
			int i = h;
			while (i > 1 && heap[i] > heap[i / 2]) {
				int tmp = heap[i];
				heap[i] = heap[i / 2];
				heap[i / 2] = tmp;
				i = i / 2;
			}
		}
		void extract() {
			System.out.println(heap[1]);
			heap[1] = heap[h];
			h--;
			maxHeapify(1);
		}
		void maxHeapify(int i) {
			int left = 2 * i;
			int right = 2 * i + 1;
			int largest = 0;
			if (left <= h && heap[left] > heap[i])
				largest = left;
			else
				largest = i;

			if (right <= h && heap[right] > heap[largest])
				largest = right;

			if (largest != i) {
				int tmp = heap[i];
				heap[i] = heap[largest];
				heap[largest] = tmp;
				maxHeapify(largest);
			}
		}
		void buildMaxHeap() {
			for (int i = h / 2; i >= 1; i--)
				maxHeapify(i);
		}
		void printDebug() {
			System.out.print("debug: ");
			for (int i = startIndex; i <= (h % MAX_HEAP); i++)
				System.out.print(heap[i] + " ");
			System.out.println();
		}
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		PriorityQueue que = new PriorityQueue();
		while (true) {
			String inst = scan.next();
			switch (inst) {
			case "insert":
				int k = scan.nextInt();
				if (DEBUG)
					System.out.println("insert " + k);
				que.insert(k);
				break;
			case "extract":
				if (DEBUG)
					System.out.print("expact: ");
				que.extract();
				break;
			case "end":
				return;
			}
			if (DEBUG)
				que.printDebug();
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
