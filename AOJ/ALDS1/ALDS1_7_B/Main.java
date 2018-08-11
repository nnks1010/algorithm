import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	class Node {
		int id, s, deg;
		Node p, l, r;
		Node(int id) {
			this.id = id;
			this.s = -1;
			this.deg = 0;
			this.p = this.l = this.r = null;
		}
		
		void print() {
			System.out.print("node " + this.id + ": ");
			System.out.print("parent = " + (this.p == null ? -1 : this.p.id) + ", ");
			System.out.print("sibling = " + this.s + ", ");
			System.out.print("degree = " + this.deg + ", ");
			int depth = 0;
			Node n = this.p;
			while (n != null) {
				depth++;
				n = n.p;
			}
			System.out.print("depth = " + depth + ", ");
			System.out.print("height = " + this.getHeight(0) + ", ");
			if(this.p == null)
				System.out.println("root");
			else if (this.l == null && this.r == null)
				System.out.println("leaf");
			else
				System.out.println("internal node");
		}
		
		int getHeight(int dep) {
			if (DEBUG)
				System.out.println("node " + this.id + ": " + dep);
			if (this.l == null && this.r == null)
				return dep;
			else if (this.l == null)
				return this.r.getHeight(dep + 1);
			else if (this.r == null)
				return this.l.getHeight(dep + 1);
			else
				return Math.max(this.l.getHeight(dep + 1), this.r.getHeight(dep + 1));
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++)
			nodes[i] = new Node(i);
		for (int i = 0; i < n; i++) {
			int id = scan.nextInt();
			int left  = scan.nextInt();
			int right = scan.nextInt();
			if (left != -1) {
				nodes[id].l = nodes[left];
				nodes[id].deg += 1;
				nodes[left].p = nodes[id];
			}
			if (right != -1) {
				nodes[id].r = nodes[right];
				nodes[id].deg += 1;
				nodes[right].p = nodes[id];
			}
			if (left != -1 && right != -1) {
				nodes[right].s = left;
				nodes[left].s = right;
			}
		}
		for (int i = 0; i < n; i++)
			nodes[i].print();
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
