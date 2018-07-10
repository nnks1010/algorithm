import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Pair {
		int y, x;

		Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static final int MAX_LENGTH = 303;
	static final int GOAL = Integer.MAX_VALUE;
	int[] dy = { 0, 1, 0, -1, 0 };
	int[] dx = { 0, 0, 1, 0, -1 };

	void run() {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int[][] field = new int[MAX_LENGTH][MAX_LENGTH];
		int[][] dist = new int[MAX_LENGTH][MAX_LENGTH];
		for (int i = 0; i < MAX_LENGTH; i++)
			Arrays.fill(field[i], GOAL);
		for (int i = 0; i < m; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int t = scan.nextInt();
			for (int j = 0; j < 5; j++) {
				int ny = y + dy[j], nx = x + dx[j];
				if (ny < 0 || nx < 0 || ny >= MAX_LENGTH || nx >= MAX_LENGTH)
					continue;
				field[ny][nx] = Math.min(field[ny][nx], t);
			}
		}
		Queue<Pair> que = new LinkedList<Pair>();
		que.add(new Pair(0, 0));
		while (!que.isEmpty()) {
			Pair p = que.poll();
			if (dist[p.y][p.x] >= field[p.y][p.x])
				continue;
			if (field[p.y][p.x] == GOAL) {
				System.out.println(dist[p.y][p.x]);
				return;
			}
			for (int i = 0; i < 5; i++) {
				int ny = p.y + dy[i], nx = p.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= MAX_LENGTH || nx >= MAX_LENGTH)
					continue;
				if (dist[ny][nx] != 0)
					continue;
				if (i != 0)
					dist[ny][nx] = dist[p.y][p.x] + 1;
				que.add(new Pair(ny, nx));
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
