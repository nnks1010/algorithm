import java.util.HashMap;
import java.util.Scanner;

public class Main {
	int[][] database = {
			{  5, -1, -2, -1, -3 },
			{ -1,  5, -3, -2, -4 },
			{ -2, -3,  5, -2, -2 },
			{ -1, -2, -2,  5, -1 },
			{ -3, -4, -2, -1,  0 }
	};
	void run() {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 0); map.put('C', 1); map.put('G', 2); map.put('T', 3); map.put('-', 4);

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		while (n-- > 0) {
			int len1 = scan.nextInt();
			char[] str1 = scan.next().toCharArray();
			int len2 = scan.nextInt();
			char[] str2 = scan.next().toCharArray();
			int[][] dp = new int[len1 + 1][len2 + 1];
			for (int i = 1; i <= len1; i++)
				dp[i][0] = dp[i - 1][0] + database[map.get(str1[i - 1])][map.get('-')];
			for (int i = 1; i <= len2; i++)
				dp[0][i] = dp[0][i - 1] + database[map.get('-')][map.get(str2[i - 1])];
			for (int i = 1; i <= len1; i++) {
				for (int j = 1; j <= len2; j++) {
					if (str1[i - 1] == str2[j - 1]) {
						dp[i][j] = dp[i - 1][j - 1] + database[map.get(str1[i - 1])][map.get(str2[j - 1])];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - 1] + database[map.get(str1[i - 1])][map.get(str2[j - 1])],
								   Math.max(dp[i][j - 1]     + database[map.get('-')][map.get(str2[j - 1])],
										    dp[i - 1][j]     + database[map.get(str1[i - 1])][map.get('-')]));
					}
				}
			}
			System.out.println(dp[len1][len2]);
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
