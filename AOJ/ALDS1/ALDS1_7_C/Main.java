import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;

	class Node {
		int id;
		Node p, l, r;
		Node(int id) {
			this.id = id;
			this.p = this.l = this.r = null;
		}
		
		Node getRoot() {
			Node n = this;
			while (n.p != null)
				n = n.p;
			return n;
		}

		void preorder() {
			System.out.print(" " + this.id);
			if (this.l != null)
				this.l.preorder();
			if (this.r != null)
				this.r.preorder();
		}
		void inorder() {
			if (this.l != null)
				this.l.inorder();
			System.out.print(" " + this.id);
			if (this.r != null)
				this.r.inorder();
		}
		void postorder() {
			if (this.l != null)
				this.l.postorder();
			if (this.r != null)
				this.r.postorder();
			System.out.print(" " + this.id);
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
				nodes[left].p = nodes[id];
			}
			if (right != -1) {
				nodes[id].r = nodes[right];
				nodes[right].p = nodes[id];
			}
		}
		Node root = nodes[0].getRoot();
		System.out.println("Preorder");
		root.preorder();
		System.out.println("\nInorder");
		root.inorder();
		System.out.println("\nPostorder");
		root.postorder();
		System.out.println();
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
