package Stacks;


public class ParenChecker {

	LinkedStack<Character> stack = new LinkedStack<Character>();
	
	public void runPC() {
		
		
		String inString = "()()()()())";
		
		for (int i = 0; i < inString.length(); i++) {
			
			Character c = inString.charAt(i);
			if (c.equals('(')) {
				stack.push(c);
			} else if (c.equals(')')) {
				if (stack.isEmpty()) {
					System.out.println("ERROR: Insufficient '(' characters");
					return;
				} else {
					stack.pop();
				}
			}
					
		}
		
		if (stack.depth() != 0) {
			System.out.println("ERROR: Insufficient ')' characters");
		} else {
			System.out.println("Parenthesis line up");
		}
		
		
	}
}
