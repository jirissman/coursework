package Hashing;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		
		ChainedHash table = new ChainedHash();
		
		//System.out.println(table);
		
		table.add(7);
		table.add(31+7);
		table.add(31+31+7);
		table.add(31+31+31+7);
		table.add(31+31+31+31+7);
		table.add(31+31+31+31+31+7);
		table.delete(31+31+31+7);
		System.out.println(table);
		table.add(31+31+31+31+31+31+7);
		System.out.println(table);
	}

}
