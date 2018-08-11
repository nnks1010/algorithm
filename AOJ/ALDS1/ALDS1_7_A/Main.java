import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;

	class Node {
		Node p;
		int[] child;
		int id;
		
		Node(int id) {
			this.id = id;
		}

		void print() {
			System.out.print("node " + this.id + ": ");
			System.out.print("parent = " + (this.p == null ? -1 : this.p.id) + ", ");
			int d = 0;
			Node p = this.p;
			while (p != null) {
				d++;
				p = p.p;
			}
			System.out.print("depth = " + d + ", ");
			System.out.print((this.p == null         ? "root" :
							  this.child.length != 0 ? "internal node" :
													   "leaf") + ", ");
			System.out.print("[");
			for (int i = 0; i < this.child.length; i++)
				System.out.print(this.child[i] + (i != this.child.length - 1 ? ", " : ""));
			System.out.println("]");
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
			int k = scan.nextInt();
			nodes[id].child = new int[k];
			for (int j = 0; j < k; j++) {
				int c = scan.nextInt();
				nodes[id].child[j] = nodes[c].id;
				nodes[c].p = nodes[id];
			}
		}
		for (int i = 0; i < n; i++)
			nodes[i].print();
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
