import java.util.Scanner;

public class Driver  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Driver me = new Driver();
		me.doIt2();
	}
	
	private void doIt() {
		int x = 23;
		TestClass t = new TestClass();
		
		Scanner kbd = new Scanner(System.in);
		System.out.print("Hi -> ");
		x = kbd.nextInt();
		
		if (x == 0) {
			t.setData(23);
		} else {
			t = null;
		}
		
		System.out.println(t.getData());
		kbd.close();
	}
	
	private void doIt2() {
		int count = 0;
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 100; j++) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	

}
