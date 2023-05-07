
public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt2();
	}
	
	private void doIt() {
		
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.addToHead(23);
		list.addToHead(24);
		list.addToHead(50);
		
		System.out.println(list);
		
		System.out.println("Deleted " + list.removeFromHead());
		System.out.println();
		
		System.out.println(list);
		
	}
	
	private void doIt2() {
		MyLinkedList<String> list = new MyLinkedList<String>();
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		
		list.addToHead("This is a test");
		list.addToHead("This is a test also");
		list.addToHead("This is a test, me too");
		
		System.out.println(list);
		
		System.out.println("Deleted " + list.removeFromHead());
		System.out.println();
		
		System.out.println(list);
	}

}
