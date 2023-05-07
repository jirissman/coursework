package ContainerClasses;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt();
	}
	
	// these strings are actually the same string
	// if strings are constants they can be equal with ==
	// if they are not constants then they will only be equal with .equals
	String y = "Hi";
	String z = "Hi";
	
	private void doIt() {
		int a = 15;
		int b = 23;
		
		Scanner kbd = new Scanner(System.in);
		System.out.println("--> ");
		String x = kbd.nextLine();
		
		System.out.println(x);
		System.out.println(y);
		
		
		// use this for objects
		if(y.equals(z)) {
			
		}
		
		// use this for primitives
		if (y==x) {
			System.out.println("Strings are equal");
		} else {
			System.out.println("Strings are not equal");
		}
		kbd.close();
	}
}
