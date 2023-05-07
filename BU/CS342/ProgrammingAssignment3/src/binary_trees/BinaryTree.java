package binary_trees;

/**
 * This is a class that represents a binary tree data structure. It contains
 * methods for inserting, searching, and traversing the tree.
 */
public class BinaryTree {
	private Node root = null;
	private int count = 0;

	/**
	 * Adds a word into the binary tree in lexicographical order. If the word
	 * already exists in the tree, the word's count is incremented by one.
	 * 
	 * @param word The word to be added to the binary tree.
	 */
	public void insert(String word) {
		if (root == null) {
			// The tree is empty, and we're first
			root = new Node();
			root.setWord(word);
			count = 1;
		} else {
			internalInsert(root, word);
		}
	}

	/**
	 * Internal version of the insert function to allow recursive function calls.
	 * 
	 * @param root The node to which the word will be added.
	 * @param word The word to be added to the binary tree.
	 */
	private void internalInsert(Node root, String word) {
		// Check if word is already in the tree
		if (word.equals(root.getWord())) {
			root.incrementCount();
			return;
		}
		// Decide if new word should be to the left or right of the current node
		if (word.compareTo(root.getWord()) < 0) {
			// The result is a negative integer if this String object lexicographically
			// precedes the argument string. (go left)

			// Check if there is already a left child
			if (root.getLeftChild() == null) {
				// There is not already a left child, add the word
				Node newNode = new Node();
				newNode.setWord(word);
				root.setLeftChild(newNode);
				count++;
			} else {
				// Continue down the tree to the left
				internalInsert(root.getLeftChild(), word);
			}
		} else { // Go right instead
			// Check if there is already a right child
			if (root.getRightChild() == null) {
				// There is not already a right child, add the word
				Node newNode = new Node();
				newNode.setWord(word);
				root.setRightChild(newNode);
				count++;
			} else {
				// Continue down the tree to the left
				internalInsert(root.getRightChild(), word);
			}
		}
	}

	/**
	 * Searches for a word in the binary tree and returns the number of times the
	 * word has been inserted into the binary tree.
	 * 
	 * @return The number of times the argument word has been inserted into the
	 *         binary tree.
	 * @param word The word to query.
	 */
	public int getCount(String word) {
		return internalCount(word, root);
	}

	/**
	 * Internal version of the count function to allow recursive function calls.
	 * 
	 * @return The number of times the argument word has been inserted into the
	 *         binary tree.
	 * @param word The word to query.
	 * @param root The node to search.
	 */
	private int internalCount(String word, Node root) {
		if (root == null) {
			// Base Case
			return 0;
		} else {
			// Recursive Case
			if (word.equals(root.getWord())) {
				// Found the word, return the count
				return root.getCount();
			} else {
				// Decide to continue looking left or right
				if (word.compareTo(root.getWord()) < 0) { // Go left
					return internalCount(word, root.getLeftChild());
				} else { // Go right
					return internalCount(word, root.getRightChild());
				}
			}
		}
	}

	/**
	 * Calculates the depth of the binary tree.
	 * 
	 * @return The depth of the binary tree.
	 */
	public int depth() {
		return internalDepth(root);
	}

	/**
	 * Internal version of the depth function to allow recursive function calls.
	 * 
	 * @return The depth of the binary tree.
	 */
	private int internalDepth(Node root) {
		if (root == null) {
			// Base Case
			return 0;
		} else {
			// Recursive Case
			int leftDepth = internalDepth(root.getLeftChild());
			int rightDepth = internalDepth(root.getRightChild());
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}

	/**
	 * @return The number of words in the binary tree.
	 */
	public int size() {
		return count;
	}

	/**
	 * @return The word at the root of the binary tree.
	 */
	public String getRoot() {
		return root == null ? null : root.getWord(); // safety check if tree is empty
	}

	/**
	 * @return The total number of words inserted into the binary tree.
	 */
	public int getTotal() {
		return internalTotal(root);
	}

	/**
	 * Internal version of the total function to allow recursive function calls.
	 * 
	 * @return The total number of words inserted into the binary tree.
	 */
	private int internalTotal(Node root) {
		if (root == null) {
			// Base Case
			return 0;
		} else {
			// Recursive Case
			int leftTotal = internalTotal(root.getLeftChild());
			int rightTotal = internalTotal(root.getRightChild());
			return leftTotal + rightTotal + root.getCount();
		}
	}

	/**
	 * Find the word that was inserted into the binary tree the most times. No ties
	 * allowed, the lexicographically first (smallest) word will be returned.
	 * 
	 * @return The word that was inserted into the binary tree the most times.
	 */
	public String mostFrequent() {
		return internalSearch(internalMax(root), root);
	}

	/**
	 * Internal version of the most frequent word function to allow recursive
	 * function calls.
	 * 
	 * @return Highest count recorded in the binary tree.
	 */
	private int internalMax(Node root) {
		if (root == null) {
			// Base Case
			return 0;
		} else {
			// Recursive Case
			int leftMax = internalMax(root.getLeftChild());
			int rightMax = internalMax(root.getRightChild());
			return Math.max(root.getCount(), Math.max(leftMax, rightMax));
		}
	}

	/**
	 * Internal function to find the lexicographically first word with the input
	 * count.
	 * 
	 * @param count The count to search for.
	 * @return Lexicographically first word with the argument count.
	 */
	private String internalSearch(int count, Node root) {
		if (root == null) {
			// Base Case
			return null;
		} else {
			// Recursive Case
			String leftWord = internalSearch(count, root.getLeftChild());
			if (leftWord != null) {
				// check if a lexicographically lower word has the same count
				return leftWord;
			} else if (root.getCount() == count) {
				// check if this node contains the desired count
				return root.getWord();
			} else {
				// the left subtree and the current node don't have the desired count
				return internalSearch(count, root.getRightChild());
			}
		}
	}

	/**
	 * Find the word(s) at the leaves with the greatest depth. A leaf is a node with
	 * no children.
	 * 
	 * @return An array of the word(s) that are at the deepest leaves of the tree.
	 */
	public String[] deepestLeaves() {
		if (root == null) {
			String[] arr = { "<Empty Tree>" };
			return arr;
		}
		return internalDeepest(root);
	}

	/**
	 * Internal version of the deepest leaves method to allow recursive function
	 * calls.
	 * 
	 * @param root The node to search for the deepest leaves.
	 * @return An array of the word(s) that are at the deepest leaves of the tree.
	 */
	private String[] internalDeepest(Node root) {
		int leftDepth = internalDepth(root.getLeftChild());
		int rightDepth = internalDepth(root.getRightChild());
		if (leftDepth == 0 && rightDepth == 0) {
			// Base Case: no subtrees, this node is a leaf
			String[] arr = { root.getWord() };
			return arr;
		} else if (leftDepth < rightDepth) {
			// Recursive Case: only the right subtree can have the deepest leaves
			return internalDeepest(root.getRightChild());
		} else if (leftDepth > rightDepth) {
			// Recursive Case: only the left subtree can have the deepest leaves
			return internalDeepest(root.getLeftChild());
		} else {
			// Recursive Case: subtrees have equally deep leaves, combine output
			String[] leftTree = internalDeepest(root.getLeftChild());
			String[] rightTree = internalDeepest(root.getRightChild());
			String[] rtn = new String[leftTree.length + rightTree.length];
			// copy left subtree
			for (int i = 0; i < leftTree.length; i++) {
				rtn[i] = leftTree[i];
			}
			// copy right subtree
			for (int i = 0; i < rightTree.length; i++) {
				rtn[i + leftTree.length] = rightTree[i];
			}
			return rtn;
		}
	}

	/**
	 * Convert the binary tree into an array. This can be done with pre-order,
	 * in-order, or post-order traversal methods. Only the specified number of nodes
	 * will be returned from the start of the array.
	 * 
	 * @param length The number of words to return after traversal.
	 * @param order  The type of traversal to use. Pre-order = 0, In-order = 1,
	 *               Post-Order = 2.
	 * @return An array of the specified length containing words from the tree in
	 *         the specified traversal order.
	 */
	public String[] traverse(int length, int order) {
		if (root == null) {
			String[] arr = { "<Empty Tree>" };
			return arr;
		}
		// create an array to hold the words in the tree and to return
		String[] list = new String[size()];
		String[] rtn = new String[length];
		// select the type of traversal
		switch (order) {
		case 0:
			list = preOrderTraversal(root);
			break;
		case 1:
			list = inOrderTraversal(root);
			break;
		case 2:
			list = postOrderTraversal(root);
			break;
		default:
			String[] arr = { "Bad input: " + order };
			return arr;
		}
		// copy the requested number of words into return array
		for (int i = 0; i < rtn.length; i++) {
			if (i < size()) {
				// check that there are still words left to copy
				rtn[i] = list[i];
			}
		}
		return rtn;
	}

	/**
	 * Internal pre-order traversal method. Uses recursive calls to append words
	 * together into the correct order in an array.
	 * 
	 * @param root The tree to traverse.
	 * @return An array of words in pre-order traversal.
	 */
	private String[] preOrderTraversal(Node root) {
		if (root == null) {
			// Base Case
			String[] rtn = new String[0];
			return rtn;
		} else {
			// Recursive Case
			String[] leftTree = preOrderTraversal(root.getLeftChild());
			String[] rightTree = preOrderTraversal(root.getRightChild());
			String[] rtn = new String[leftTree.length + rightTree.length + 1];
			// Copy from recursive calls into new array of correct size in pre-order
			// Copy current value first
			rtn[0] = root.getWord();
			// Copy in left subtree second
			for (int i = 0; i < leftTree.length; i++) {
				rtn[i + 1] = leftTree[i];
			}
			// Copy in right subtree last
			for (int i = 0; i < rightTree.length; i++) {
				rtn[i + leftTree.length + 1] = rightTree[i];
			}
			return rtn;
		}
	}

	/**
	 * Internal in-order traversal method. Uses recursive calls to append words
	 * together into the correct order in an array.
	 * 
	 * @param root The tree to traverse.
	 * @return An array of words in in-order traversal.
	 */
	private String[] inOrderTraversal(Node root) {
		if (root == null) {
			String[] rtn = new String[0];
			return rtn;
		} else {
			// Recursive Case
			String[] leftTree = inOrderTraversal(root.getLeftChild());
			String[] rightTree = inOrderTraversal(root.getRightChild());
			String[] rtn = new String[leftTree.length + rightTree.length + 1];
			// Copy from recursive calls into new array of correct size in in-order
			// Copy in left subtree first
			for (int i = 0; i < leftTree.length; i++) {
				rtn[i] = leftTree[i];
			}
			// Copy in current value second
			rtn[leftTree.length] = root.getWord();
			// Copy in right subtree last
			for (int i = 0; i < rightTree.length; i++) {
				rtn[i + leftTree.length + 1] = rightTree[i];
			}
			return rtn;
		}
	}

	/**
	 * Internal post-order traversal method. Uses recursive calls to append words
	 * together into the correct order in an array.
	 * 
	 * @param root The tree to traverse.
	 * @return An array of words in post-order traversal.
	 */
	private String[] postOrderTraversal(Node root) {
		if (root == null) {
			String[] rtn = new String[0];
			return rtn;
		} else {
			// Recursive Case
			String[] leftTree = postOrderTraversal(root.getLeftChild());
			String[] rightTree = postOrderTraversal(root.getRightChild());
			String[] rtn = new String[leftTree.length + rightTree.length + 1];
			// Copy from recursive calls into new array of correct size in post-order
			// Copy in left subtree first
			for (int i = 0; i < leftTree.length; i++) {
				rtn[i] = leftTree[i];
			}
			// Copy in right subtree second
			for (int i = 0; i < rightTree.length; i++) {
				rtn[i + leftTree.length] = rightTree[i];
			}
			// Copy in current value last
			rtn[leftTree.length + rightTree.length] = root.getWord();
			return rtn;
		}
	}

	/**
	 * Deletes all nodes of the tree. Cannot be undone.
	 */
	public void clear() {
		root = null;
	}
}
