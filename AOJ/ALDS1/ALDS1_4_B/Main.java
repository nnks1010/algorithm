import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int n, q;
	int[] s, t;
	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		s = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = scan.nextInt();
		q = scan.nextInt();
		t = new int[q];
		for (int i = 0; i < q; i++)
			t[i] = scan.nextInt();
		int ans = 0;
		for (int i = 0; i < q; i++) {
			if (binarySearch(t[i]))
				ans++;
		}
		System.out.println(ans);
	}

	boolean binarySearch(int val) {
		int low = 0;
		int hight = n - 1;
		while (low <= hight) {
			int mid = (low + hight) / 2;
			if (s[mid] == val)
				return true;
			else if (s[mid] > val)
				hight = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		new Main().run();
	}
}