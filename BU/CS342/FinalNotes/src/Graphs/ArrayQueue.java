package Graphs;


public class ArrayQueue {

	private Integer []queue;
	private int head;
	private int tail;
	private int count;
	
	private static final int QUEUE_SIZE = 8;
	
	public ArrayQueue() {
		queue = new Integer[QUEUE_SIZE];
		head = tail = count = 0;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#add(java.lang.Integer)
	 */
	public boolean add(Integer data) {
		if (isFull()) {
			return false;
		} else {
			queue[tail] = data;
			tail++;
			if (tail == QUEUE_SIZE) {
				tail = 0;
			}
			count++;
			return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#remove()
	 */
	public Integer remove() {
		if (isEmpty()) {
			return null;
		} else {
			Integer rtn = queue[head++];
			if (head == QUEUE_SIZE) {
				head = 0;
			}
			count--;
			return rtn;
		}
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#isFull()
	 */
	public boolean isFull() {
		return (count == QUEUE_SIZE);
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#isEmpty()
	 */
	public boolean isEmpty() {
		return (count == 0);
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#size()
	 */
	public int size() {
		return count;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#maxSize()
	 */
	public int maxSize() {
		return QUEUE_SIZE;
	}
	
	/* (non-Javadoc)
	 * @see MyQueue#head()
	 */
	public Integer head() {
		if (isEmpty()) {
			return null;
		} else {
			return queue[head];
		}
	}
	
	public String toString() {
		String rtn = "";
		if (isEmpty()) {
			rtn = "<Empty>";
		} else {
			int tmp = head;
			for (int i = 0; i < count; i++) {
				rtn += " <" + queue[tmp++] + ">";
				if (tmp == QUEUE_SIZE) {
					tmp = 0;
				}
			}
		}
		return rtn;
	}
	
}
