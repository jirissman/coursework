package binary_trees;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}

	private void doIt() {
		// set up text parser and binary tree
		TextParser tp = new TextParser();
		BinaryTree tree = new BinaryTree();
		if (tp.openFile("C:\\Users\\Joseph.Rissman\\Desktop\\pg345.txt") == false) {
			System.out.println("Error opening file");
			System.exit(0);
		}
		
		// insert words from text into the binary tree
		String word = tp.getNextWord();
		while (word != null) {
			tree.insert(word);
			word = tp.getNextWord();
		}

		// convert string arrays to single string for printing later
		String[] deepestWordsArray = tree.deepestLeaves();
		String[] preOrderArray = tree.traverse(20, 0);
		String[] inOrderArray = tree.traverse(20, 1);
		String[] postOrderArray = tree.traverse(20, 2);
		String deepestWords = "";
		String preOrder = "";
		String inOrder = "";
		String postOrder = "";
		for (int i = 0; i < deepestWordsArray.length; i++) {
			deepestWords += deepestWordsArray[i] + " ";
		}
		for (int i = 0; i < preOrderArray.length; i++) {
			preOrder += preOrderArray[i] + " ";
		}
		for (int i = 0; i < inOrderArray.length; i++) {
			inOrder += inOrderArray[i] + " ";
		}
		for (int i = 0; i < postOrderArray.length; i++) {
			postOrder += postOrderArray[i] + " ";
		}

		// print required output
		System.out.println("transylvania   = " + tree.getCount("transylvania"));
		System.out.println("harker         = " + tree.getCount("harker"));
		System.out.println("renfield       = " + tree.getCount("renfield"));
		System.out.println("vampire        = " + tree.getCount("vampire"));
		System.out.println("expostulate    = " + tree.getCount("expostulate"));
		System.out.println("fang           = " + tree.getCount("fang"));
		System.out.println("Depth          = " + tree.depth());
		System.out.println("Unique words   = " + tree.size());
		System.out.println("Root word      = " + tree.getRoot());
		System.out.println("Deepest words  = " + deepestWords);
		System.out.println("Total words    = " + tree.getTotal());
		System.out.println("Most used word = '" + tree.mostFrequent() + "' occured "
				+ tree.getCount(tree.mostFrequent()) + " times");
		System.out.println("Pre-Order Traversal: " + preOrder);
		System.out.println("In-Order Traversal: " + inOrder);
		System.out.println("Post-Order Traversal: " + postOrder);

	}
}
