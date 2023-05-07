
public class Driver {

	private static final int TABLE_SIZE = 37;
	private int []table = new int[TABLE_SIZE]; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Driver me = new Driver();
		me.doIt();

	}
	
	private void doIt() {
		int hashLoc = 0;
		
		int offsetValue = 1;
		
		for (int i = 0; i < 1000; i++) {
			int target = hashLoc + (offsetValue * offsetValue);
			table[target % TABLE_SIZE]++;
			
			offsetValue++;
		}
		
		for (int i = 0; i < table.length; i++) {
			System.out.printf("table[%d] = %d%n", i, table[i]);
		}
		
	}
	
	

}
