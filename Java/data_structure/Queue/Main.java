import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    class Pair {
        int y, x;
        Pair(int y,int x) {
            this.y = y;
            this.x = x;
        }
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] field = new int[m][];
        int[][] ans = new int[m][];
        int sy = 0, sx = 0; // スタート座標
        int gy = 0, gx = 0; // ゴール座標
        for (int i = 0; i < m; i++) {
            field[i] = new int[n];
            ans[i] = new int[n];
            char[] data = scan.next().toCharArray();
            for (int j = 0; j < n; j++) {
                if (data[j] == '#') {
                    field[i][j] = 1;
                } else if (data[j] == '.') {
                    field[i][j] = 0;
                } else if (data[j] == 'S') {
                    sy = i;
                    sx = j;
                    field[i][j] = 0;
                } else {
                    gy = i;
                    gx = j;
                    field[i][j] = 0;
                }
            }
        }
        // debug
//      for (int i = 0; i < m; i++) {
//          for (int j = 0; j < n; j++) {
//              System.out.print(field[i][j] + " ");
//          }
//          System.out.println();
//      }
//      System.out.println(sy + " " + sx);
//      System.out.println(gy + " " + gx);

        // Pair の Queue を作成
        Queue<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(sy, sx));

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int y = pair.y;
            int x = pair.x;
            if (y == gy && x == gx) {
                System.out.println(ans[y][x]);
                break;
            }
            int[] dx = { 1, 0, -1,  0 };
            int[] dy = { 0, 1,  0, -1 };
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                    continue;
                if (ans[ny][nx] != 0)
                    continue;
                if (field[ny][nx] != 0)
                    continue;
                ans[ny][nx] = ans[y][x] + 1;
                que.add(new Pair(ny, nx));
            }
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
