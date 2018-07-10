import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	class Block {
		int h, a, c;
		Block(int h, int a, int c) {
			this.h = h; this.a = a; this.c = c;
		}
	}
	final int MAX_A = 40000 + 1;
	void run() {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		Block[] blocks = new Block[k];
		for (int i = 0; i < k; i++) {
			int h = scan.nextInt();
			int a = scan.nextInt();
			int c = scan.nextInt();
			blocks[i] = new Block(h, a, c);
		}
		Arrays.sort(blocks, new Comparator<Block>() {
			@Override
			public int compare(Block b1, Block b2) {
				return b1.a - b2.a;
			}
		});
		int[] dp = new int[MAX_A];
		for (int i = 0; i < MAX_A; i++)
			dp[i] = -1;
		dp[0] = 0;

		for (int i = 0; i < k; i++) {
			Block b = blocks[i];
			for (int j = 0; j <= b.a; j++) {
				if (dp[j] >= 0) dp[j] = b.c;
				if (j >= b.h) dp[j] = Math.max(dp[j], dp[j - b.h] - 1);
			}
		}
		int ans = 0;
		for (int i = 0; i < MAX_A; i++)
			if (dp[i] >= 0) ans = Math.max(ans, i);
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
