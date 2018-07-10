import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			char[] str1 = scan.next().toCharArray();
			char[] str2 = scan.next().toCharArray();
			int[][] dp = new int[str1.length + 1][str2.length + 1];
			for (int i = 0; i < str1.length; i++) {
				for (int j = 0; j < str2.length; j++) {
					if(str1[i] == str2[j])
						dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
					else{
						dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
					}
				}
			}
			System.out.println(dp[str1.length][str2.length]);
		}
	}
	public static void main(String[] args) {
		 new Main().run();
	}
}
