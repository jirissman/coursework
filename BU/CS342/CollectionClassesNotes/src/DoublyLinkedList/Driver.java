package DoublyLinkedList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}

	public void doIt() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addToHead(22);
		System.out.println(list);
	}
}
