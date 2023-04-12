package QueensPuzzle;

public class Stack {
	private Node head;
	private int count;

	public Stack() {
		head = null;
		count = 0;
	}

	public void push(int col) {
		Node newNode = new Node();
		newNode.setColumn(col);
		newNode.setNext(head);
		count++;
		head = newNode;
	}

	public int pop() {
		int rtn = 0;
		if (!isEmpty()) {
		rtn = head.getColumn();
		head = head.getNext();
		count--;
		}
		return rtn;
	}

	public int peek() {
		if (isEmpty()) {
			return 0;
		}
		return head.getColumn();
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public int depth() {
		return count;
	}
}