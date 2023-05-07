package Stacks;

import java.util.Scanner;

public class RPNCalculator {

	private LinkedStack<Double> stack;
	
	public void runCalc() {
		Scanner kbd = new Scanner(System.in);
		
		// Welcome user
		System.out.println("Welcome to my RPN Calculator");
		
		boolean done = false;
		
		stack = new LinkedStack<Double>();
		
		String inString;
		while(!done) {
			System.out.println("Enter command (? for help)\n-> ");
			inString = kbd.nextLine();
			
			String lowString = inString.toLowerCase();
			
			switch(lowString) {
			
				case "?":
				case "h":
					System.out.println("Help goes here");
					break;
					
				case "q":
					done = true;
					break;
					
				case "=":
					System.out.println(stack.peek());
					break;
					
				case "c":
					stack.clear();
					break;
					
				case "p":
					System.out.println(stack);
					break;
					
				case "+": {
					if (stack.depth() < 2) {
						System.out.println("Insufficient arguments on stack");
						break;
					}
					
					Double a = stack.pop();
					Double b = stack.pop();
					Double c = a + b;
					stack.push(c);
					break;
				}
					
				case "*": {
					if (stack.depth() < 2) {
						System.out.println("Insufficient arguments on stack");
						break;
					}
					
					Double a = stack.pop();
					Double b = stack.pop();
					Double c = a * b;
					stack.push(c);
					break;
				}
				
				case "-": {
					if (stack.depth() < 2) {
						System.out.println("Insufficient arguments on stack");
						break;
					}
					Double b = stack.pop();
					Double a = stack.pop();
					Double c = a - b;
					stack.push(c);
					break;
					
				}
				
				case "/": {
					if (stack.depth() < 2) {
						System.out.println("Insufficient arguments on stack");
						break;
					}
					Double b = stack.pop();
					Double a = stack.pop();
					if (b.equals(0.0)) {
						System.out.println("ERROR:Division by 0");
						stack.push(a);
						stack.push(b);
						break;
					}
					Double c = a / b;
					stack.push(c);
					break;
				}
					
				default: {
					Double val = null;
					try {
						val = Double.parseDouble(lowString);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid command (" + inString + ")");
						break;
					}
				
					stack.push(val);
					break;
				}
			}
		}
		kbd.close();
	}
}
