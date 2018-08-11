import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Tree treap = new Tree();
		for (int i = 0; i < n; i++) {
			String inst = scan.next();
			int key;

			switch(inst) {
			case "insert":
				key = scan.nextInt();
				int priority = scan.nextInt();
				if (DEBUG)
					System.out.println("insert: " + key);
				treap.insert(key, priority);
				break;
			case "find":
				key = scan.nextInt();
				if (DEBUG)
					System.out.println("insert: " + key);
				System.out.println(treap.find(key) ? "yes" : "no");
				break;
			case "delete":
				key = scan.nextInt();
				if (DEBUG)
					System.out.println("find: " + key);
				treap.delete(key);
				break;
			case "print":
				if (DEBUG)
					System.out.println("print");
				treap.print();
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

	void insert(int key, int priority) {
		this.root = this.insertNode(this.root, key, priority);
	}

	void delete(int key) {
		this.root = this.deleteNode(this.root, key);
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
	Node insertNode(Node node, int key, int priority) {
		if (node == null)
			return new Node(key, priority);
		if (key == node.key)
			return node;
		if (key < node.key) {
			node.left = insertNode(node.left, key, priority);
			if (node.priority < node.left.priority)
				node = rightRotate(node);
		} else {
			node.right = insertNode(node.right, key, priority);
			if (node.priority < node.right.priority)
				node = leftRotate(node);
		}
		return node;
	}
	Node deleteNode(Node node, int key) {
		if (node == null)
			return null;
		if (key < node.key)
			node.left = deleteNode(node.left, key);
		else if (key > node.key)
			node.right = deleteNode(node.right, key);
		else
			return _delete(node, key);
		return node;
	}
	Node leftRotate(Node node) {
		Node right = node.right;
		node.right = right.left;
		right.left = node;
		return right;
	}
	Node rightRotate(Node node) {
		Node left = node.left;
		node.left = left.right;
		left.right = node;
		return left;
	}
	Node _delete(Node node, int key) {
		if (node.left == null && node.right == null)
			return null;
		else if (node.left == null)
			node = leftRotate(node);
		else if (node.right == null)
			node = rightRotate(node);
		else {
			if (node.left.priority > node.right.priority)
				node = rightRotate(node);
			else
				node = leftRotate(node);
		}
		return deleteNode(node, key);
	}
}

class Node {
	int key, priority;
	Node parent, left, right;
	Node(int key, int priority) {
		this.key = key;
		this.priority = priority;
	}
}
