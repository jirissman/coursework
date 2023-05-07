
public class ArrBinTree {
	
	private Integer []tree = new Integer[1024];
	private int count=0;
	
	public boolean add(Integer data) {
		
		if (tree[0] == null) {
			tree[0] = data;
			count = 1;
			return true;
		}
		return internalAdd(data, 0);
	}
	
	private boolean internalAdd(Integer data, int root) {
		if (tree[root] == null) {
			tree[root] = data;
			count++;
			return true;
		}
		
		if (data < tree[root]) {
			// Add left
			return internalAdd(data, root*2 + 1);
		} else if (data > tree[root]){
			// Add right
			return internalAdd(data, root*2 + 2);
		} else {
			return false;
		}
	}

	public void delete(Integer data) {
		// TODO Auto-generated method stub
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	public boolean search(Integer data) {
		if (tree[0].equals(data)) {
			return true;
		} else {
			return internalSearch(data, 0);
		}
	}
	
	private boolean internalSearch(Integer data, int root) {
		if (tree[root] == null) {
			return false;
		}
		
		if (tree[root].equals(data)) {
			return true;
		}
		
		if (data < tree[root]) {
			return internalSearch(data, root*2 + 1);
		} else {
			return internalSearch(data, root*2 + 2);
		}
	}

	public void inOrderTraversal() {
		// TODO Auto-generated method stub
		if (count == 0) {
			System.out.println("<Empty Tree>");
		}
		
		inOrderTraversal(0);
		System.out.println();
	}
	
	private void inOrderTraversal(int root) {
		if (tree[root] == null) {
			return;
		}
		
		inOrderTraversal(root * 2 + 1);
		System.out.print(tree[root] + " ");
		inOrderTraversal(root * 2 + 2);
	}

	public int treeDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void preOrderTraversal() {
		if (tree[0] == null) {
			System.out.println("<Empty Tree>");
		} else {
			System.out.print("Pre Order : ");
			preOrderTraversal(0);
			System.out.println();
		}
		
	}
	
	private void preOrderTraversal(int root) {
		// BASE Case
		if (tree[root] == null) {
			return;
		}
		
		System.out.print(tree[root] + " ");
		preOrderTraversal(root*2+1);
		preOrderTraversal(root*2+2);
		
	}

	public void postOrderTraversal() {
		// TODO Auto-generated method stub
		
	}

}
