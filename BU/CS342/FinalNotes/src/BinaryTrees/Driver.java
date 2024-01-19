package BinaryTrees;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		
		LinkedBinaryTree tree = new LinkedBinaryTree();
		tree.inOrderTraversal();
		tree.add(103);
		tree.add(78);
		tree.add(110);
		tree.add(60);
		tree.add(100);
		tree.add(107);
		tree.add(113);
		tree.add(12);
		tree.add(65);
		tree.add(101);
		tree.add(122);
		tree.add(4);
		tree.add(68);
		tree.add(115);
		tree.add(125);
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		tree.postOrderTraversal();
		
		System.out.println("Search for 790 " + tree.search(790));
		System.out.println("Search for 800 " + tree.search(800));
		
		System.out.println(tree);
		//System.out.println(tree.getDepth());
	}

}
