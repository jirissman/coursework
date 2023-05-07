package LinkedList;

public class TemplateDriver {

	public static void main(String[] args) {
		TemplateDriver me = new TemplateDriver();
		me.doIt2();
	}
	
	private void doIt() {
		
		TemplateLinkedList<Integer> list = new TemplateLinkedList<Integer>();
		
		list.addToHead(23);
		list.addToHead(24);
		list.addToHead(50);
		
		System.out.println(list);
		
		System.out.println("Deleted " + list.removeFromHead());
		System.out.println();
		
		System.out.println(list);
		
	}
	
	private void doIt2() {
		TemplateLinkedList<String> list = new TemplateLinkedList<String>();
		TemplateLinkedList<Integer> list2 = new TemplateLinkedList<Integer>();
		
		list.addToHead("This is a test");
		list.addToHead("This is a test also");
		list.addToHead("This is a test, me too");
		
		System.out.println(list);
		
		System.out.println("Deleted " + list.removeFromHead());
		System.out.println();
		
		System.out.println(list);
	}

}
