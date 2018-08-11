import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int[] heap = new int[h + 1];
		for (int i = 1; i <= h; i++)
			heap[i] = scan.nextInt();
		for (int i = 1; i <= h; i++) {
			System.out.print("node " + i + ": ");
			System.out.print("key = " + heap[i] + ", ");
			if (i / 2 > 0)
				System.out.print("parent key = " + heap[i / 2] + ", ");
			if (2 * i <= h)
				System.out.print("left key = " + heap[2 * i] + ", ");
			if (2 * i + 1 <= h)
				System.out.print("right key = " + heap[2 * i + 1] + ", ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
