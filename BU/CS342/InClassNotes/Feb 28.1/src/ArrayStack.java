
public class ArrayStack {
	
	private Double []stack;
	private int count;
	private static final int STACK_SIZE = 12;
	
	public ArrayStack() {
		stack = new Double[STACK_SIZE];
		count = 0;
	}
	public boolean push(Double value) {
		if (isFull()) {
			// STACK OVERFLOW - Make the stack larger
			
			Double []newStack = new Double[count+STACK_SIZE];
			for (int i = 0; i < count; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		
		stack[count++] = value;
		
		return true;
	}
	
	public Double pop() {
		if (isEmpty()) {
			// STACK UNDERFLOW
			return null;
		} else {
			Double rtn = peek();
			count--;
			return rtn;
		}
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public boolean isFull() {
		return (count == stack.length);
	}
	
	public Double peek() {
		if (isEmpty()) {
			return null;
		}
		return stack[count-1];
	}
	
	public int depth() {
		return count;
	}
	
	public int getCapacity() {
		return stack.length;
	}
	
	public void clear() {
		count = 0;
	}
	
	public String toString() {
		String rtn = "";
		
		if (isEmpty()) {
			rtn += "<Empty>";
		} else {
			for (int i = count-1; i >= 0; i--) {
				if (i == count-1) {
					rtn += "top -> ";
				} else {
					rtn += "       ";
				}
				rtn += stack[i] + "\n";
			}
		}
		
		return rtn;
	}

}
