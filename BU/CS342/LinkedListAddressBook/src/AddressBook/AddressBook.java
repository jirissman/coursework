package AddressBook;

public class AddressBook {
	private Node head;
	private int count;

	public AddressBook() {
		head = null;
		count = 0;
	}

	public void add(String name, String email, String phone) {
		Node temp = head;
		Node newNode = new Node();
		newNode.setName(name);
		newNode.setEmail(email);
		newNode.setPhone(phone);
		// if list is empty, add it to head
		if (count == 0) {
			head = newNode;
			count++;
			return;
		}
		if (head.getLast().compareTo(newNode.getLast()) >= 0) {
			// if head is lexicographically after or equal to newNode, add newNode to head
			newNode.setNext(head);
			head = newNode;
			count++;
			return;
		}
		while (temp.getNext() != null) {
			if (temp.getNext().getLast().compareTo(newNode.getLast()) >= 0) {
				// find the node lexicographically after newNode and add newNode before it
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
				count++;
				return;
			}
			temp = temp.getNext();
		}
		// we've reached the end of the list so newNode must belong at the end
		temp.setNext(newNode);
		count++;
		return;

	}

	public boolean delete(int index) {
		if (!validIndex(index)) {
			return false;
		}
		if (index == 1) {
			// special case to remove the head
			head = head.getNext();
			count--;
			return true;
		}
		Node temp = head;
		int counter = 1;
		// move temp to node before index position
		while (counter < index - 1) {
			temp = temp.getNext();
			counter++;
		}
		temp.setNext(temp.getNext().getNext()); // set temp to 2 nodes ahead to delete node after temp
		count--;
		return true;
	}

	public boolean modify(int index, String name, String email, String phone) {
		if (!validIndex(index)) {
			return false;
		}
		Node temp = head;
		int counter = 1;
		// move temp to index position
		while (counter < index) {
			temp = temp.getNext();
			counter++;
		}
		if (name != null) {
			temp.setName(name);
		}
		if (email != null) {
			temp.setEmail(email);
		}
		if (phone != null) {
			temp.setPhone(phone);
		}
		return true;
	}

	public void search(String name) {
		if (count == 0) {
			System.out.println("Address book is empty.");
			return;
		}
		Node temp = head;
		int counter = 1;
		int printCount = 0;
		while (temp != null) {
			if (temp.getName().equals(name)) {
				printIndex(counter);
				printCount++;
			}
			temp = temp.getNext();
			counter++;
		}
		if (printCount == 0) {
			System.out.println("No entries match the search.");
		}
		return;
	}

	public void email(String email) {
		if (count == 0) {
			System.out.println("Address book is empty.");
			return;
		}
		Node temp = head;
		int counter = 1;
		int printCount = 0;
		while (temp != null) {
			if (temp.getEmail().equals(email)) {
				printIndex(counter);
				printCount++;
			}
			temp = temp.getNext();
			counter++;
		}
		if (printCount == 0) {
			System.out.println("No entries match the search.");
		}
		return;
	}

	public void printAll() {
		if (count == 0) {
			System.out.println("Address book is empty.");
			return;
		}
		Node temp = head;
		int counter = 1;
		while (temp != null) {
			System.out.println(counter + ": " + temp.toString());
			counter++;
			temp = temp.getNext();
		}
		return;
	}

	public boolean printIndex(int index) {
		if (!validIndex(index)) {
			return false;
		}
		Node temp = head;
		int counter = 1;
		// move temp to index position
		while (counter < index) {
			temp = temp.getNext();
			counter++;
		}
		System.out.println(counter + ": " + temp.toString());
		return true;
	}

	private boolean validIndex(int index) {
		if (count == 0) {
			System.out.println("Address book is empty. Add some entries first.");
			return false;
		}
		if (index > count || index < 1) {
			System.out.println("Index " + index + " is out of range. Valid range is 1-" + count);
			return false;
		}
		return true;
	}
}
