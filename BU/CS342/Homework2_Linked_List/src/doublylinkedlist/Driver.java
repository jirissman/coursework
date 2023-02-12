package doublylinkedlist;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt();
	}

	private void doIt() {
		// TODO Auto-generated method stub
		
		DoubleLinkedList list = new DoubleLinkedList();
		list.addToTail("This");
		list.addToTail("is");
		list.addToTail("a");
		list.addToTail("doubly");
		list.addToTail("linked");
		list.addToTail("list");
		list.addToTail("with");
		list.addToTail("exactly");
		list.addToTail("10");
		list.addToTail("nodes");
		list.printForward();
		list.printReverse();
	}

}
