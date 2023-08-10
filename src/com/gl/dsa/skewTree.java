package com.gl.dsa;
class Node {

	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
		this.left = this.right = null;
	}
}

public class skewTree {

	private Node headNode = null;
	private Node prevNode = null;

	public void buildSkewTree(Node tree) {

		if (tree == null)
			return;

		buildSkewTree(tree.left);

		if (headNode == null) {
			headNode = tree;
			tree.left = null;
			prevNode = tree;
		} else {
			prevNode.right = tree;
			tree.left = null;
			prevNode = tree;
		}

		buildSkewTree(tree.right);
	}

	public void printSkewTree() {
		Node node = headNode;
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.right;
		}
	}
}

class skyscraper {

	public static void main(String[] args) {

		Node tree = new Node(50);
		tree.left = new Node(30);
		tree.right = new Node(60);
		tree.left.left = new Node(10);
		tree.right.left = new Node(55);

		skewTree skewTree = new skewTree();
		skewTree.buildSkewTree(tree);
		skewTree.printSkewTree();
	}
}
