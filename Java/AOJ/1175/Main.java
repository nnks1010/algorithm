import java.util.Scanner;

public class Main {
	class Circle {
		int x, y, r, c;
		Circle (int x, int y, int r, int c) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.c = c;
		}
	}
	final boolean DEBUG = false;
	final int MAX_N = 4 * 6;
	Circle[] circles;
	boolean[] isVisited;
	int n, ans;

	void run() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			n = scan.nextInt();
			if (n == 0)
				return;
			circles = new Circle[n];
			isVisited = new boolean[1 << 24];
			
			for (int i = 0; i < n; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				int r = scan.nextInt();
				int c = scan.nextInt();
				circles[i] = new Circle(x, y, r, c);
			}
			ans = 0;
			dfs(0);
			System.out.println(ans);
		}
	}
	
	int deleteCount(int bit) {
		int count = 0;
		while (bit != 0) {
			if ((bit & 1) != 0)
				count++;
			bit >>= 1;
		}
		return count;
	}
	
	boolean isTop(int bit, int circle) {
		if ((bit & (1 << circle)) != 0)
			return false;
		
		for (int i = circle - 1; i >= 0; i--) {
			if ((bit & (1 << i)) != 0)
				continue;
			int dx = circles[i].x - circles[circle].x;
			int dy = circles[i].y - circles[circle].y;
			if (circles[i].r + circles[circle].r > Math.sqrt(dx * dx + dy * dy))
				return false;
		}
		return true;
	}
	
	void dfs(int bit) {
		if (isVisited[bit])
			return;
		isVisited[bit] = true;
		if (DEBUG)
			System.out.println(bit);

		ans = Math.max(ans, deleteCount(bit));
		if (n - ans <= 1)
			return;
		
		for (int i = 0; i < n; i++) {
			if (DEBUG) {
				System.out.println(i + " " + !isTop(bit, i));
				System.out.println();
			}
			if (!isTop(bit, i))
				continue;
			for (int j = i + 1; j < n; j++) {
				if (DEBUG) {
					System.out.println("j: " + j + " " + !isTop(bit, j));
				}
				if (!isTop(bit, j))
					continue;
				if(circles[i].c == circles[j].c) {
					dfs(bit | (1 << i) | (1 << j));
					if (n - ans <= 1)
						return;
				}
			}
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
