/**
 *
 * アリ本P.37 迷路の最短路の回答
 *
 **/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // y, x座標を扱う Pair クラスを作成
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
        // 入力された迷路を格納する field の作成
        int[][] field = new int[m][];
        // そのマスに来たターン数を格納する ans の作成
        int[][] ans = new int[m][];
        int sy = 0, sx = 0; // スタート座標
        int gy = 0, gx = 0; // ゴール座標
        for (int i = 0; i < m; i++) {
            field[i] = new int[n];
            ans[i] = new int[n];
            char[] data = scan.next().toCharArray();
            for (int j = 0; j < n; j++) {
                field[i][j] = data[j];
                // Start と Gaul の座標を格納する
                if (data[j] == 'S') {
                    sy = i;
                    sx = j;
                }
                if (data[j] == 'G') {
                    gy = i;
                    gx = j;
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
            Pair p = que.poll();
            // ゴール座標ならばターン数を出力して終了
            if (p.y == gy && p.x == gx) {
                System.out.println(ans[p.y][p.x]);
                break;
            }
            int[] dx = { 1, 0, -1,  0 };
            int[] dy = { 0, 1,  0, -1 };
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i], nx = p.x + dx[i];
                // マップの範囲外ならばスキップ
                if (ny < 0 || nx < 0 || ny >= m || nx >= n)
                    continue;
                // すでに来たことあるマスならばスキップ
                if (ans[ny][nx] != 0)
                    continue;
                // field のマスが壁ならばスキップ
                if (field[ny][nx] == '#')
                    continue;
                ans[ny][nx] = ans[p.y][p.x] + 1;
                que.add(new Pair(ny, nx));
            }
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
