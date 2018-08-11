import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Tree tree = new Tree();
		for (int i = 0; i < n; i++) {
			String inst = scan.next();
			int key;

			switch(inst) {
			case "insert":
				key = scan.nextInt();
				if (DEBUG)
					System.out.println("insert: " + key);
				tree.insert(new Node(key));
				break;
			case "find":
				key = scan.nextInt();
				if (DEBUG)
					System.out.println("insert: " + key);
				System.out.println(tree.find(key) ? "yes" : "no");
				break;
			case "print":
				if (DEBUG)
					System.out.println("print");
				tree.print();
				break;
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}

class Tree {
	Node root;

	void insert(Node node) {
		Node parent = null;
		Node child = this.root;
		while (child != null) {
			parent = child;
			if (node.key < child.key) child = child.left;
			else					  child = child.right;
		}
		node.parent = parent;

		if(parent == null)		   		this.root    = node;
		else if (node.key < parent.key) parent.left  = node;
		else					   		parent.right = node;
	}

	boolean find(int key) {
		Node node = this.root;
		while (node != null) {
			if (key == node.key) return true;
			if (key < node.key) node = node.left;
			else 				node = node.right;
		}
		return false;
	}

	void print() {
		this.inorder(this.root);
		System.out.println();
		this.preorder(this.root);
		System.out.println();
	}

	void preorder(Node node) {
		if (node == null) return;
		System.out.print(" " + node.key);
		this.preorder(node.left);
		this.preorder(node.right);
	}
	void inorder(Node node) {
		if (node == null) return;
		this.inorder(node.left);
		System.out.print(" " + node.key);
		this.inorder(node.right);
	}
}

class Node {
	int key;
	Node parent, left, right;
	Node(int key) {
		this.key = key;
	}
}