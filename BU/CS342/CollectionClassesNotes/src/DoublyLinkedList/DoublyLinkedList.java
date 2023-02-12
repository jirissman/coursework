package DoublyLinkedList;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int counter;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		counter = 0;
	}

	public boolean addToHead(Integer data) {
		Node newNode = new Node();
		newNode.setData(data);

		if (counter == 0) {
			// this is the first node of the list
			head = tail = newNode;
			counter = 1;
			return true;
		}
		newNode.setNext(head);
		head.setPrev(newNode);
		head = newNode;
		counter++;
		return true;
	}

	@Override
	public String toString() {
		Node tmp = head;
		String rtn = "";
		if (counter == 0) {
			rtn += "<Empty>";
		} else {
			rtn += "head -> ";

			while (tmp != null) {
				rtn += tmp.getData() + " -> ";
				tmp = tmp.getNext();
			}
			rtn += "tail";
		}
		return rtn;
	}
}
