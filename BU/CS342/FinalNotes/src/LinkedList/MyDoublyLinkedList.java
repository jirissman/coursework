package LinkedList;


public class MyDoublyLinkedList {
	private DNode head;
	private DNode tail;
	private int count;

	public MyDoublyLinkedList() {
		head = tail = null;
		count = 0;
	}

	public boolean addToHead(Integer data) {

		DNode newNode = new DNode();
		newNode.setData(data);

		if (count == 0) {
			// This is the first Node added to list
			head = tail = newNode;
			count = 1;
			return true;
		}

		newNode.setNext(head);
		head.setPrev(newNode);
		head = newNode;
		count++;
		return true;
	}
	
	private DNode search(Integer data) {
		DNode tmp = head;
		
		while (tmp != null) {
			if (tmp.getData().equals(data)) {
				return tmp;
			}
			
			tmp = tmp.getNext();
			
		}
		
		return null;
	}
	
	public boolean addAfter(Integer addAfterMe, Integer dataToAdd) {
		DNode node = search(addAfterMe);
		
		if (node == null) {
			// Data to add after is not in the list
			return false;
		}
		
		DNode newNode = new DNode();
		newNode.setData(dataToAdd);
		
		node.getNext().setPrev(newNode);
		newNode.setNext(node.getNext());
		
		node.setNext(newNode);
		newNode.setPrev(node);
		
		if (node == tail) {
			tail = newNode;
		}
		
		count++;
		
		return true;
	}

	public String toString() {
		DNode tmp = head;
		String rtn = "";

		if (count == 0) {
			rtn += "<Empty>";
		} else {
			rtn += "head -> ";

			while(tmp != null) {
				rtn += tmp.getData() + " -> ";
				tmp = tmp.getNext();
			}
			
			rtn += "null";
		}
		
		return rtn;
	}
}
