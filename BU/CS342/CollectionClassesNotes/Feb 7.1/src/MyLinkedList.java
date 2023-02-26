
public class MyLinkedList {

	private Node head;
	private int count;
	
	
	public MyLinkedList() {
		head = null;
		count = 0;
	}
	
	public void addToHead(Integer data) {
		
		Node newNode = new Node();
		newNode.setData(data);
		
		newNode.setNext(head);
		head = newNode;
		count++;
	}
	
	public Integer removeFromHead() {
		
		if (count == 0) {
			// Empty List
			return null;
		} else {
			// Store the current head for return
			Integer tmp = head.getData();
			
			// Move head to the next node
			head = head.getNext();
			
			count--;
			
			return tmp;
		}
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public boolean deleteByData(Integer data) {
		// Find the data
		Node tmp = head;
		
		// Nothing in the list, you can't delete it
		if (count == 0) {
			return false;
		}
		
		// Search and delete
		Node prev = null;
		Node cur = head;
		
		while(cur != null) {
			if (cur.getData().equals(data)) {
				// This is the one we want.
				
				// Where is it in the list?
				if (prev == null) {
					// The data is in the head of the list
					removeFromHead();
					return true;
				} else {
					prev.setNext(cur.getNext());
					count--;
					return true;
				}
				
			}
			
			prev = cur;
			cur = cur.getNext();
		}
		
		// We did not find the data
		return false;
	}
	
	private Node searchForNode(Integer data) {
		Node tmp = head;
		while(head != null) {
			if (tmp.getData().equals(data)) {
				return tmp;
			}
			
			tmp = tmp.getNext();
		}
		
		return null;
	}
	
	public boolean search(Integer data) {
		return (searchForNode(data) != null);
	}
	
	private Node internalSearchForPrev(Integer data) {
		// Return the previous node that refers to the passed in data
		
		// NOTE:  The data must reside in the list before calling this
		//        method.
		Node prev = null;
		Node cur = head;
		
		while(cur != null) {
			if (cur.getData().equals(data)) {
				// This is the one we want.
				
				// Where is it in the list?
				if (prev == null) {
					// The data is in the head of the list
					return null;
				} else {
					return prev;
				}
				
			}
			
			prev = cur;
			cur = cur.getNext();
		}
		
		// THIS SHOULD NEVER HAPPEN
		return null;
	}
	
	public boolean addAfter(Integer addAfterMe, Integer dataToAdd) {
		Node addAfterNode = searchForNode(addAfterMe);
		
		if (addAfterNode != null) {
			Node newNode = new Node();
			newNode.setData(dataToAdd);
			newNode.setNext(addAfterNode.getNext());
			addAfterNode.setNext(newNode);
			count++;
			return true;
		} else {
		
			return false;
		}
	}
	
	public boolean addBefore(Integer addBeforeMe, Integer dataToAdd) {
		// Does the data exist in the list
		if (searchForNode(addBeforeMe) == null) {
			// The add before me data is not present
			System.out.println(addBeforeMe + " Does not exist in list");
			return false;
		}
		
		Node prev = internalSearchForPrev(addBeforeMe);
		
		if (prev == null) {
			// We want to add before the head of the list
			System.out.println("Adding " + dataToAdd + " to head");
			addToHead(dataToAdd);
			return true;
		}
		
		Node newNode = new Node();
		newNode.setData(dataToAdd);
		newNode.setNext(prev.getNext());
		
		prev.setNext(newNode);
		count++;
		
		return true;
	}
	
	public String toString() {
		String rtn = "";
		
		if (count == 0) {
			rtn += "<Empty>";
		} else {
			Node tmp = head;
			
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
