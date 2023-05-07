package Queues;


public class LinkedQueue <T>{

	private Node<T> head;
	private Node<T> tail;
	private int count;
	
	public boolean add(T data) {
		Node<T> newNode = new Node<T>();
		
		newNode.setData(data);
		// This is the first node in the queue
		if (isEmpty()) {
			tail = head = newNode;
			count = 1;
			return true;
		} else {
			// General case
			tail.setNext(newNode);
			tail = tail.getNext();
			count++;
		}
		return true;
	}

	public T remove() {
		if (isEmpty()) {
			return null;
		}
		
		T tmp = head.getData();
		head = head.getNext();
		count--;
		
		if (isEmpty()) {
			head = tail = null;
		}
		
		return tmp;
	}

	public T peek() {

		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public int size() {
		return count;
	}

	public void clear() {
		head = tail = null;
		count = 0;
	}
	
	public String toString() {
		if (isEmpty()) {
			return "<Empty>";
		}
		String rtn = "";
		//rtn += "head: " + head + ", tail: " + tail + "\n";
		
		Node<T> tmp = head;
		for (int i = 0; i < count; i++) {
			if (tmp == head) {
				rtn += "head -> ";
			} else {
				rtn += "        ";
			}
			rtn += tmp.getData() + "\n";
			
			tmp = tmp.getNext();
		}
		
		return rtn;
	}

}
