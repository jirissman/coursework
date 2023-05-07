
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt3();
	}
	
	private void doIt() {
		LinkedStack<Double> stack = new LinkedStack<Double>();
		
		stack.push(23.23);
		stack.push(12.12);
		System.out.println(stack);
		System.out.println(stack.pop());
		System.out.println(stack);
		
		for (int i = 0; i < 100; i++) {
			stack.push((double) i);
		}
		
		System.out.println(stack);
		System.out.println("Stack size =  " + stack.depth());
	}
	
	private void doIt2() {
		RPNCalculator calc = new RPNCalculator();
		
		calc.runCalc();
		
	}
	
	private void doIt3() {
		ParenChecker pc = new ParenChecker();
		pc.runPC();
	}

}
