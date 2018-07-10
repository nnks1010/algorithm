import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int n = scan.nextInt();
			int l = scan.nextInt();
			int r = scan.nextInt();
			if (n + l + r == 0)
				return;
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scan.nextInt();
			
			int ans = 0;
			for (int year = l; year <= r; year++) {
				int idx = 1;
				for (int i = 0; i < n; i++) {
					if (year % a[i] == 0)
						break;
					idx++;
				}
				if (idx == n && n % 2 == 1)
					ans++;
				else if (idx % 2 == 1)
					ans++;
			}
			System.out.println(ans);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}

}
