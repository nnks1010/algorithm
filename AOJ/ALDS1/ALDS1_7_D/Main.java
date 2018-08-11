import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	int[] preIds, inIds, posIds;
	int preIndex, inIndex, posIndex;
	
	int prev, pos;
	int location(int l, int r, int id) {
		for (int i = l; i < r; i++)
			if (inIds[i] == id) return i;
		return -1;
	}

	void tree(int l, int r) {
		if (l < r) {
			int root = preIds[preIndex++];
			int m = location(l, r, root);
			tree(l, m);
			tree(m + 1, r);
			posIds[posIndex++] = root;
		}
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		preIds = new int[n];
		inIds =  new int[n];
		posIds = new int[n];
		preIndex = inIndex = posIndex = 0;

		for (int i = 0; i < n; i++)
			preIds[i] = scan.nextInt();
		for (int i = 0; i < n; i++)
			inIds[i] = scan.nextInt();
		tree(0, n);
		for (int i = 0; i < n; i++)
			System.out.print(posIds[i] + (i == n - 1 ? "\n" : " "));
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
