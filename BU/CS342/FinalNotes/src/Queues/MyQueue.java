package Queues;


public interface MyQueue {

	boolean add(Integer data);

	Integer remove();

	Integer peek();

	boolean isEmpty();

	int size();

	void clear();

}