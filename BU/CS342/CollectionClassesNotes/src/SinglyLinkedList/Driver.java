package SinglyLinkedList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}

	
	private void doIt() {
		LinkedList list = new LinkedList();
		
		list.addToHead(22);
		list.addToHead(33);
		list.addToHead(56);
		list.addToHead(92);
		list.addToHead(13);
		list.addToHead(33);
		list.addToHead(80);
		list.addToHead(96);
		System.out.println(list);
		
		System.out.println(list.removeFromHead());
		System.out.println(list);
		list.addAfter(22, 42);
		System.out.println(list);
		list.deleteByData(33);
		System.out.println(list);
	}
}
