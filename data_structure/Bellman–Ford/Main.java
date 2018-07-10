import java.util.Scanner;

public class Main {
    class Edge {
        int from, to, cost;
        Edge(int from, int to, int cost) {
            this.from = from;
            this.to= to;
            this.cost = cost;
        }
    }
    
    final int INF = Integer.MAX_VALUE;
    final int MAX_E = 10;
    final int MAX_V = 10;

    void run() {
        Scanner scan = new Scanner(System.in);
        int v = scan.nextInt();
        int e = scan.nextInt();
        
        Edge[] edges = new Edge[MAX_E];
        int[] dist = new int[MAX_V];
        
        for (int i = 0; i < e; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int cost = scan.nextInt();
            edges[i] = new Edge(from - 1, to - 1, cost);
        }
        
        for (int i = 0; i < v; i++)
            dist[i] = INF;
        dist[0] = 0;
        while (true) {
            boolean update = false;
            for (int i = 0; i < e; i++) {
                Edge edge = edges[i];
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
//                    System.out.println(edge.from + " " + edge.to + " : " + dist[edge.to]);
                    update = true;
                }
            }
            if (!update)
                break;
        }
        for (int i = 0; i < v; i++)
            System.out.println(dist[i]);
    }
    // 負の閉路の検知
    boolean findNegativeLoop(int v, int e, int[] dist, Edge[] edges) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < e; j++) {
                Edge edge = edges[j];
                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    // n回目にも更新があるなら負の閉路が存在する
                    if (i == v - 1)
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
