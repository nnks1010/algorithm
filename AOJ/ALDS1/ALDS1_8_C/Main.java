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
			case "delete":
				key = scan.nextInt();
				if (DEBUG)
					System.out.println("find: " + key);
				tree.delete(key);
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
	final boolean DEBUG = false;
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

	void delete(int key) {
		this.deleteNode(this.root, key);
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
	void deleteNode(Node node, int key) {
		if (node == null)
			return;
		while (node != null) {
			if (key == node.key)
				break;
			if (key < node.key) node = node.left;
			else			 	node = node.right;
		}
		if(DEBUG)
			System.out.println("delete key: " + node.key);

		Node parent = node.parent;
		if (node.left == null && node.right == null)
			if (parent == null)
				this.root = null;
			else if (parent.left != null && parent.left.key == node.key)
				parent.left = null;
			else
				parent.right = null;
		else if (node.left != null && node.right != null) {
			Node pre = this.getNextInNode(node, key);
			this.delete(pre.key);
			node.key = pre.key;
		} else if (node.left != null) {
			if (parent.left != null && parent.left.key == node.key)
				parent.left = node.left;
			else
				parent.right = node.left;
			node.left.parent = parent;
		} else {
			if (parent.left != null && parent.left.key == node.key)
				parent.left = node.right;
			else
				parent.right = node.right;
			node.right.parent = parent;
		}
	}
	Node getNextInNode(Node node, int key) {
		if (node == null) return null;
		Node n = this.getNextInNode(node.left, key);
		if (n != null)
			return n;
		if (node.key > key)
			return node;
		return this.getNextInNode(node.right, key);
	}
}

class Node {
	int key;
	Node parent, left, right;
	Node(int key) {
		this.key = key;
	}
}
