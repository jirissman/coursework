package Recursion;

public class FibonnacciFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonnacciFactorial me = new FibonnacciFactorial();
		me.doIt();
	}
	
	private static final int FIB_VALUE = 50;
	private void doIt() {
		//System.out.println(recFact(5));
		
		long start1 = System.currentTimeMillis();
		System.out.println(itFib(FIB_VALUE));
		long stop1 = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		System.out.println(recFib(FIB_VALUE));
		long stop2 = System.currentTimeMillis();
		
		System.out.printf("Iterative Fibonacci Executed in %d milliseconds\n", (stop1-start1));
		System.out.printf("Recursive Fibonacci Executed in %d milliseconds\n", (stop2-start2));
	}
	
	
	private long itFact(int val) {
		// Iterative solution to factorial
		long total = 1;
		for (int i = val; i > 0; i--) {
			total = total * i;
		}
		
		return total;
	}
	
	private long recFact(int val) {
		
		// Base Case
		if (val == 1) {
			return 1;
		}
		
		return val * recFact(val - 1);
	}
	
	private long itFib(int order) {
		if ((order == 1) || (order == 2))
			return 1;
		
		long a = 1;
		long b = 1;
		long c = 1;
		
		for (int i = 2; i < order; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	private long recFib(int order) {
		// Base Case
		if ((order == 1) || (order == 2)) {
			return 1;
		}
		
		return recFib(order-1) + recFib(order-2);

	}

}
