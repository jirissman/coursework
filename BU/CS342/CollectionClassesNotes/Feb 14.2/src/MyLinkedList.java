
public class MyLinkedList <T>{
	private Node<T> head;
	private int count;
	
	public void addToHead(T data) {
		
		Node<T> nn = new Node<T>();
		nn.setData(data);
		nn.setNext(head);
		
		head = nn;
		count++;
		return;
	}
	
	public T removeFromHead() {
		if (count == 0) {
			// Empty list
			return null;
		}
		
		T tmp = head.getData();
		
		head = head.getNext();
		count--;
		
		return tmp;
	}
	
	public String toString() {
		if (count == 0) {
			return "<Empty>";
		}
		
		String rtn = "";
		Node<T> tmp = head;
		while(tmp != null) {
			rtn += tmp.getData() + "\n";
			
			tmp = tmp.getNext();
		}
		
		return rtn;
	}
}
