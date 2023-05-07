
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt2();
	}

	private void doIt() {
		MyLinkedList list = new MyLinkedList();

		list.addToHead(22);
		list.addToHead(33);
		list.addToHead(44);
		list.addToHead(55);
		list.addToHead(66);
		list.addToHead(77);
		System.out.println(list);

		System.out.println(list.removeFromHead());

		System.out.println(list);

		list.deleteByData(33);;
		System.out.println(list);

		list.addAfter(44, 34);
		System.out.println(list);

		list.addAfter(66, 60);
		System.out.println(list);

		list.addAfter(22, 11);
		System.out.println(list);

		list.addBefore(44, 47);
		System.out.println(list);
	}
	
	private void doIt2() {
		MyDoublyLinkedList list = new MyDoublyLinkedList();
		
		list.addToHead(88);
		list.addToHead(77);
		list.addToHead(66);
		list.addToHead(55);
		System.out.println(list);
		
		list.addAfter(66, 70);
		System.out.println(list);
	}

}
