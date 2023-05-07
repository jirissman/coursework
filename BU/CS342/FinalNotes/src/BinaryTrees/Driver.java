package BinaryTrees;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		
		ArrBinTree tree = new ArrBinTree();
		tree.inOrderTraversal();
		tree.add(500);
		tree.add(250);
		tree.add(750);
		tree.add(125);
		tree.add(230);
		tree.add(790);
		tree.add(534);
		tree.add(25);
		tree.add(75);
		tree.add(50);
		tree.add(48);
		tree.add(92);
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		tree.postOrderTraversal();
		
		System.out.println("Search for 790 " + tree.search(790));
		System.out.println("Search for 800 " + tree.search(800));
		
		System.out.println(tree);
		//System.out.println(tree.getDepth());
	}

}
