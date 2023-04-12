package AirportSimulation;

/**
 * This class represents a dynamic queue that can hold Integer values that represent when a plane enters the queue.
 */
public class DynamicQueue {
	private Node head = null;
	private Node tail = null;
	private int count = 0;

	/**
	 * Adds a plane to the end of the queue.
	 * @param time The time in the simulation the plane is added to the queue.
	 */
	public void add(Integer time) {
		Node newNode = new Node();
		newNode.setTime(time);
		if (isEmpty()) {
			// special case: first node in queue
			tail = head = newNode;
			count = 1;
		} else {
			// general case: add to rear
			tail.setNext(newNode);
			tail = newNode;
			count++;
		}
	}

	/**
	 * Removes the plane at the front of the queue.
	 * @return The time that the plane at the front of the queue originally entered the queue or null if the queue is empty.
	 */
	public Integer remove() {
		if (isEmpty()) {
			return null;
		}
		Integer time = head.getTime();
		head = head.getNext();
		count--;
		if (isEmpty()) {
			// if the last element of the queue was removed, reset the queue
			head = tail = null;
		}
		return time;
	}

	/**
	 * Returns the time that the plane at the front of the queue originally entered the queue without removing it.
	 * @return The time that the plane at the front of the queue originally entered the queue or null if the queue is empty.
	 */
	public Integer peek() {
		if (isEmpty()) {
			return null;
		}
		return head.getTime();
	}

	/**
	 * Checks if the queue is empty.
	 * @return true if the queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return count == 0;
	}

	/**
	 * Returns the number of planes in the queue.
	 * @return The number of planes in the queue.
	 */
	public int size() {
		return count;
	}

	/**
	 * Clears all elements from the queue.
	 */
	public void clear() {
		head = tail = null;
		count = 0;
	}
}
