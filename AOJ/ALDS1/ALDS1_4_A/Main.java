import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = scan.nextInt();
		int q = scan.nextInt();
		int[] t = new int[q];
		for (int i = 0; i < q; i++)
			t[i] = scan.nextInt();
		int ans = 0;
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < n; j++) {
				if (t[i] != s[j])
					continue;
				ans++;
				break;
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
