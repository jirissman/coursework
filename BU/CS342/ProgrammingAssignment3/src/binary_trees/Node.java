package binary_trees;

/**
 * This is a class that represents a node in a binary tree data structure. It
 * contains methods for accessing and mutating the string data, count data, and
 * left and right child nodes.
 */
public class Node {
	private int count = 1;
	private String word = null;
	private Node leftChild = null;
	private Node rightChild = null;

	public int getCount() {
		return count;
	}

	public void resetCount() {
		this.count = 0;
	}

	public void incrementCount() {
		this.count++;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
}
