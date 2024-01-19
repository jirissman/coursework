package BinaryTrees;

/**
 * In a full binary tree every node has either 0 or 2 child nodes. In a complete
 * binary tree, all levels are completely filled except possibly the last level.
 * 
 * 
 */

public class LinkedBinaryTree {

	private Node root;
	private int count;

	public void add(Integer data) {
		if (root == null) {
			// The tree is empty, and we're first
			root = new Node();
			root.setData(data);
			count = 1;
		} else {
			internalAdd(root, data);
		}
	}

	private void internalAdd(Node root, Integer data) {

		// Decide which path down the tree to take
		if (data < root.getData()) {
			// Go to the left

			// Is there currently a left child
			if (root.getlChild() == null) {
				// Base case for insert data here.
				Node newNode = new Node();
				newNode.setData(data);
				root.setlChild(newNode);
				count++;
			} else {
				internalAdd(root.getlChild(), data);
			}
		} else {
			// Go to the right
			if (root.getrChild() == null) {
				Node newNode = new Node();
				newNode.setData(data);
				root.setrChild(newNode);
				count++;
			} else {
				internalAdd(root.getrChild(), data);
			}
		}
	}

	public boolean search(Integer data) {
		if (root == null) {
			return false;
		}
		return search(root, data);
	}

	private boolean search(Node root, Integer data) {
//		System.out.print("Entered recursive search ");
//		System.out.print("Looking for " + data + " ");
//		System.out.println(root == null ? "null" : root.getData() );
		// BASE case where root is null, means we did not find it.
		if (root == null) {
//			System.out.println("Returned due to null");
			return false;
		}

		if (root.getData().equals(data)) {
//			System.out.println("Returned due to found");
			return true;
		}

		if (data < root.getData()) {
			return search(root.getlChild(), data);
		} else {
			return search(root.getrChild(), data);
		}
	}

	public void preOrderTraversal() {
		if (root == null) {
			System.out.println("<Empty Tree>");
		} else {
			System.out.print("Pre Order : ");
			preOrderTraversal(root);
			System.out.println();
		}
	}

	private void preOrderTraversal(Node root) {
		// BASE Case
		if (root == null) {
			return;
		}

		System.out.print(root.getData() + " ");
		preOrderTraversal(root.getlChild());
		preOrderTraversal(root.getrChild());
	}

	public void inOrderTraversal() {
		if (root == null) {
			System.out.println("<Empty Tree>");
		} else {
			System.out.print("In Order  : ");
			inOrderTraversal(root);
			System.out.println();
		}
	}

	private void inOrderTraversal(Node root) {
		// BASE Case
		if (root == null) {
			return;
		}

		inOrderTraversal(root.getlChild());
		System.out.print(root.getData() + " ");
		inOrderTraversal(root.getrChild());
	}

	public void postOrderTraversal() {
		if (root == null) {
			System.out.println("<Empty Tree>");
		} else {
			System.out.print("Post Order: ");
			postOrderTraversal(root);
			System.out.println();
		}
	}

	private void postOrderTraversal(Node root) {
		// BASE Case
		if (root == null) {
			return;
		}

		postOrderTraversal(root.getlChild());
		postOrderTraversal(root.getrChild());
		System.out.print(root.getData() + " ");
	}

	public void clear() {
		root = null;
	}

	public String toString() {
		if (root == null) {
			return "<Empty Tree>";
		}
		return internalToString(root);
	}

	private String internalToString(Node root) {

		if (root == null) {
			return "";
		}

		String left = internalToString(root.getlChild());
		String cur = root.getData().toString() + " ";
		String right = internalToString(root.getrChild());

		return left + cur + right;
	}

	public int getDepth() {
		if (root == null) {
			return -1;
		} else {
			return getDepth(root, 0);
		}
	}

	private int getDepth(Node root, int depth) {
		// BASE Case
		if (root == null) {
			return depth - 1;
		} else {
			int lDepth = getDepth(root.getlChild(), depth + 1);
			int rDepth = getDepth(root.getrChild(), depth + 1);
			return lDepth > rDepth ? lDepth : rDepth;
		}
	}

	public int size() {
		return count;
	}

	public void delete(Integer data) {
		int size = size();
		root = recDelete(root, data);

		// If the size of the tree changed, we deleted something
		if (size != size()) {
			count = size - 1;
		}
	}

	private Node recDelete(Node root, Integer data) {

		// Base Case
		if (root == null) {
			return root;
		}

		// Recurse down the tree
		if (data < root.getData()) {
			root.setlChild(recDelete(root.getlChild(), data));
		} else if (data > root.getData()) {
			root.setrChild(recDelete(root.getrChild(), data));
		} else {
			// If the data is the same, delete this node
			count--;
			// see if node has one child or no children
			if (root.getlChild() == null) {
				return root.getrChild();
			} else if (root.getrChild() == null) {
				return root.getlChild();
			}

			// The Node has two children, get the smallest in the right subtree.
			root.setData(getMinValue(root.getrChild()));

			// Delete the in-Order successor
			root.setrChild(recDelete(root.getrChild(), root.getData()));
		}

		return root;
	}

	private Integer getMinValue(Node root) {
		int minv = root.getData();

		while (root.getlChild() != null) {
			minv = root.getlChild().getData();
			root = root.getlChild();
		}

		return minv;
	}

}
