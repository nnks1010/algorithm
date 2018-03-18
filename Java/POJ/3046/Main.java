import java.util.Scanner;

public class Main {
    static final int MAX_T = 1000;
    static final int MAX_A = 100000;
    static final int M = 1000000;
    void run() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int a = scan.nextInt();
        int s = scan.nextInt();
        int b = scan.nextInt();
        int[] ants = new int[MAX_T];
        for (int i = 0; i < a; i++)
            ants[scan.nextInt() - 1] += 1;
        int[][] dp = new int[2][MAX_A + 1];
        for (int i = 0; i < 2; i++)
            dp[i][0] = 1;
        for (int i = 0; i < t; i++) {
            for (int j = 1; j <= b; j++) {
                if (j - 1 - ants[i] >= 0) {
                    dp[1][j] = (dp[1][j - 1] + dp[0][j] - dp[0][j - 1 - ants[i]] + M) % M;
                } else {
                    dp[1][j] = (dp[1][j - 1] + dp[0][j]) % M;
                }
            }
            int[] tmp = dp[0];
            dp[0] = dp[1];
            dp[1] = tmp;
            for (int j = 1; j <= b; j++)
            	dp[1][j] = 0;
        }
        int ans = 0;
        for (int i = s; i <= b; i++)
            ans = (ans + dp[0][i]) % M;
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        new Main().run();
    }
}
