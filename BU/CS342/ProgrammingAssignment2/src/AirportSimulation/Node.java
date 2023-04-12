package AirportSimulation;

/**
 * This class represents a node in a queue that can hold an Integer value that represents the time the node was added to the queue.
 */
public class Node {
	private Integer time;
	private Node next;
	/**
	 * Returns the Integer value stored in this node.
	 * @return The Integer value stored in this node.
	 */
	public Integer getTime() {
		return time;
	}

	/**
	 * Sets the Integer value stored in this node.
	 * @param time The Integer value to be stored in this node.
	 */
	public void setTime(Integer time) {
		this.time = time;
	}

	/**
	 * Returns the next node in the queue.
	 * @return The next node in the queue.
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * Sets the next node in the queue.
	 * @param next The next node in the queue.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}

