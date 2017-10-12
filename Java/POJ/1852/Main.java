import java.util.Scanner;

public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            int l = scan.nextInt();
            int n = scan.nextInt();
            int min = 0, max = 0;
            for (int j = 0; j < n; j++) {
                int x = scan.nextInt();
                int m;
                m = Math.min(l - x, x);
                min = Math.max(min, m);
                m = Math.max(l - x, x);
                max = Math.max(max, m);
            }
            System.out.println(min + " " + max);
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
