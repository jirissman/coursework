
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		String test = "1";
		
		int testNum = test.charAt(0) - '0';
		
		System.out.println(testNum);
	}

}
