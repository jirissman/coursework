package SinglyLinkedList;

public class LinkedList {

	private Node head;
	private int counter;

	public LinkedList() {
		head = null;
		counter = 0;
	}

	public void addToHead(Integer data) {
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNext(head);
		head = newNode;
		counter++;
	}

	public Integer removeFromHead() {
		if (counter == 0) {
			// Empty list
			return null;
		}
		// Store the current head for return
		Integer tmp = head.getData();

		// Move head to the next node
		head = head.getNext();
		counter--;
		return tmp;
	}

	public boolean isEmpty() {
		return (counter == 0);
	}

	private Node searchForNode (Integer data) {
		if (counter == 0) {
			return null;
		}
	
		Node tmp = new Node();
		while (tmp != null) {
			if (tmp.getData().equals(data)) {
				// this is the one we want
				return tmp;
			}
		}
		// we couldn't find it
		return null;
	}

	public boolean deleteByData(Integer data) {
		// there's nothing in the list to delete
		if (counter == 0) {
			return false;
		}

		// find the data and delete it
		Node prev = null;
		Node crnt = head;

		while (crnt != null) {
			if (crnt.getData().equals(data)) {
				// this is the one we want

				// where is it in the list?
				if (prev == null) {
					// the data is in the head of the list
					removeFromHead();
				} else {
					prev.setNext(crnt.getNext());
					counter--;
				}
				return true;
			}
			prev = crnt;
			crnt = crnt.getNext();
		}

		// we did not find the data
		return false;

//		// Some sort of search
//		Node tmp = head;
//		while (tmp != null) {
//			if (tmp.getData().equals(data)) {
//				
//			}
//		}
	}

	public boolean addAfter(Integer addAfterMe, Integer dataToAdd) {
		Node tmp = head;
		if (counter == 0) {
			// empty list, nothing to add after
			return false;
		}
		while (tmp != null) {
			if (tmp.getData().equals(addAfterMe)) {
				Node toAdd = new Node();
				toAdd.setData(dataToAdd);
				toAdd.setNext(tmp.getNext());
				tmp.setNext(toAdd);
				counter++;
				return true;
			}
			tmp = tmp.getNext();
		}
		// we couldn't find the value to add after
		return false;
	}

	private Node internalSearchForPrev(Integer data) {
		// return the previous node that refers to the passed in data

		// NOTE: the data must reside in the list before calling this method
		// find the data
		Node prev = null;
		Node crnt = head;

		while (crnt != null) {
			if (crnt.getData().equals(data)) {
				// this is the one we want

				// where is it in the list?
				if (prev == null) {
					// the data is in the head of the list
					return null;
				} else {
					return prev;
				}
			}
			prev = crnt;
			crnt = crnt.getNext();
		}
	}

	public boolean search(Integer data) {
		return (searchForNode(data) != null);
	}
	
	public boolean addBefore(Integer addBeforeMe, Integer dataToAdd) {
		// does the data exist in the list?
		if (searchForNode(addBeforeMe) == null) {
			return false;
		}
		
		Node prev = internalSearchForPrev(addBeforeMe);
		
		if (prev == null) {
			return false;
		}
	}

	@Override
	public String toString() {
		String rtn = "";

		if (counter == 0) {
			rtn = "<Empty>";
		} else {
			Node tmp = head;
			rtn += "head -> ";
			while (tmp != null) {
				rtn += tmp.getData() + " -> ";
				tmp = tmp.getNext();
			}
			rtn += "null";
		}
		return rtn;
	}

}
