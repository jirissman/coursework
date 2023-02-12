package doublylinkedlist;

public class DoubleLinkedList {

	private Node head;
	private Node tail;
	private int count;

	DoubleLinkedList() {
		head = tail = null;
		count = 0;
	}

	public void addToHead(String data) {
		Node newNode = new Node();
		newNode.setData(data);
		if (count == 0) {
			// the list is empty
			newNode.setNext(head);
			newNode.setPrev(tail);
			head = tail = newNode;
			count = 1;
		} else {
			// the list is NOT empty
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
			count++;
		}
	}

	public void addToTail(String data) {
		Node newNode = new Node();
		newNode.setData(data);
		if (count == 0) {
			// the list is empty
			newNode.setNext(head);
			newNode.setPrev(tail);
			head = tail = newNode;
			count = 1;
		} else {
			// the list is NOT empty
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
			count++;
		}
	}

	public void printForward() {
		if (count == 0) {
			// list is empty
			System.out.println("<Empty>");
		} else {
			// set iterator to first element
			Node it = head;
			String printer = "head -> ";
			// iterate through list, adding each node data to output string
			while(it != null) {
				printer += it.getData() + " -> ";
				it = it.getNext();
			}
			printer += "tail";
			System.out.println(printer);
		}
	}

	public void printReverse() {
		if (count == 0) {
			// list is empty
			System.out.println("<Empty>");
		} else {
			// set iterator to last element
			Node it = tail;
			String printer = "tail -> ";
			// iterate through list in reverse, adding each node data to output string
			while(it != null) {
				printer += it.getData() + " -> ";
				it = it.getPrev();
			}
			printer += "head";
			System.out.println(printer);
		}
	}
}
