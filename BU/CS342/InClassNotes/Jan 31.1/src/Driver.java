import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	String y = "Hi";
	String z = "Hi";
	
	private void doIt() {
		int a = 15;
		int b = 23;
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("--> ");
		String x = kbd.nextLine();
		
		System.out.println(x);
		System.out.println(y);
		
		if (a == b) {
			
		}
		
		if (y.equals(z)) {
			
		}
		
		if (y.equals(x)) {
			System.out.println("Strings are equal");
		} else {
			System.out.println("Strings are not equal");
		}
 	}

}
