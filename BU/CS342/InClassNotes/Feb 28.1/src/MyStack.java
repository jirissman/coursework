
public interface MyStack {

	boolean push(Double value);

	Double pop();

	boolean isEmpty();

	boolean isFull();

	Double peek();

	int depth();

	void clear();

}