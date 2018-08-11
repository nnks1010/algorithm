import java.util.Scanner;

public class Main {
	class Pair {
		double y, x;
		Pair(double x, double y) {
			this.y = y;
			this.x = x;
		}
		void print() {
			System.out.println(this.y + " " + this.x);
		}
	}
	int n;

	void run() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		Pair p1 = new Pair(0, 0);
		Pair p2 = new Pair(0, 100);
		p1.print();
		kochCurve(0, new Pair(0, 0), new Pair(0, 100));
		p2.print();
	}
	
	void kochCurve(int deep, Pair p1, Pair p2) {
		if (deep == n) {
			return;
		}
		
		Pair s = new Pair((2 * p1.x + p2.x) / 3, (2 * p1.y + p2.y) / 3);
		Pair t = new Pair((p1.x + 2 * p2.x) / 3, (p1.y + 2 * p2.y) / 3);
		
		double _x = p2.x - p1.x;
		double _y = -(p2.y - p1.y);
		double dist = Math.sqrt(_x * _x + _y * _y)/ Math.sqrt(3);

		Pair u;
		if (_x >= 0) {
			double angle = Math.atan(_y / _x) + Math.PI / 6;
			u = new Pair(p1.x + (dist * Math.cos(angle)), p1.y - (dist * Math.sin(angle)));
		} else {
			double angle = Math.atan(_y / _x) - Math.PI / 6;
			u = new Pair(p2.x + (dist * Math.cos(angle)), p2.y - (dist * Math.sin(angle)));
		}

		kochCurve(deep + 1, p1, s);
		s.print();
		kochCurve(deep + 1, s, u);
		u.print();
		kochCurve(deep + 1, u, t);
		t.print();
		kochCurve(deep + 1, t, p2);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
