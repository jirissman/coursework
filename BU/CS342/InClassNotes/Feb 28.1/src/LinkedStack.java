
public class LinkedStack <T> {
	
	private Node<T> head;
	private int count;
	
	public LinkedStack() {
		head = null;
		count = 0;
	}

	public boolean push(T value) {
		// Allocate and fill out a new Node
		Node<T> newNode = new Node<T>();
		newNode.setData(value);
		
		// Set the next for the new node to refer to the head
		newNode.setNext(head);
		
		count++;
		
		// This node becomes the head of the stack.
		head = newNode;
		
		return false;
	}

	public T pop() {
		if (isEmpty()) {
			return null;
		}
		T tmp = peek();
		head = head.getNext();
		count--;
		
		return tmp;
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public boolean isFull() {
		return false;
	}

	public T peek() {
		if (isEmpty()) {
			return null;
		}
		
		
		return head.getData();
	}

	public int depth() {
		return count;
	}

	public void clear() {
		head = null;
		count = 0;
	}
	
	public String toString() {
		String rtn = "";
		
		if (isEmpty()) {
			return "<Empty>";
		}
		
		Node<T> tmp = head;
		
		while(tmp != null) {
			if (tmp == head) {
				rtn += "top -> ";
			} else {
				rtn += "       ";
			}
			
			rtn += tmp.getData() + "\n";
			tmp = tmp.getNext();
		}
		
		return rtn;
	}

}
