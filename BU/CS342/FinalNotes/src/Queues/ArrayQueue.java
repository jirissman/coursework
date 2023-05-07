package Queues;


public class ArrayQueue {
	
	private Integer []queue;
	private int tail;
	private int head;
	private int count;
	private static final int QUEUE_SIZE = 12;
	
	
	public ArrayQueue() {
		queue = new Integer[QUEUE_SIZE];
		head = tail = count = 0;
	}
	
	public ArrayQueue(int size) {
		queue = new Integer[size];
		head = tail = count = 0;		
	}
	
	public boolean add(Integer data) {
		
		// If the queue is full, we can't add anything
		if (isFull()) {
			return false;
		}
		
		queue[tail++] = data;
		
		// Cure wrap
		if (tail == queue.length) {
			tail = 0;
		}

		count++;
		return true;
	}
	
	public Integer remove() {
		
		// If queue is empty, return null
		if (isEmpty()) {
			return null;
		}
		
		Integer tmp = queue[head];
		head++;
		
		if (head == queue.length) {
			head = 0;
		}

		count--;
		
		return tmp;
		
	}
	
	public Integer peek() {
		if (isEmpty()) {
			return null;
		} else {
			return queue[head];
		}
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public boolean isFull() {
		return (count == queue.length);
	}
	
	public int size() {
		return count;
	}
	
	public int getCapacity() {
		return queue.length;
	}
	
	public void clear() {
		head = tail = count = 0;
		
	}
	
	public String toString() {
		if (isEmpty()) {
			return "<Empty>";
		}
		String rtn = "";
		rtn += "head: " + head + ", tail: " + tail + "\n";
		
		int tmp = head;
		for (int i = 0; i < count; i++) {
			if (tmp == head) {
				rtn += "head -> ";
			} else {
				rtn += "        ";
			}
			rtn += queue[tmp] + "\n";
			
			tmp++;
			// Cure Wrap
			if (tmp == queue.length) {
				tmp = 0;
			}
		}
		
		return rtn;
	}
	

}
