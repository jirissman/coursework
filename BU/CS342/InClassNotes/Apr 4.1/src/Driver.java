
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		//count(1,10);
		dontDoThis(1, 1);
	}
	
	String space = " ";
	
	private void count(int start, int end) {
		
		// BASE Case
		if (start == end) {
			System.out.println(space.repeat(start) + start);
			return;
		}
		
		System.out.println(space.repeat(start) + start);
		count(start+1, end);
		System.out.println(space.repeat(start) + start);
	}
	
	private void dontDoThis(int count, int count2) {
		System.out.println("Count = " + count);
		dontDoThis(count + 1, count2 + 1);
	}

}
