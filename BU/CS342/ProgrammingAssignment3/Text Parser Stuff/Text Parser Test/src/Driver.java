import edu.bu.met.cs342sb1.TextParser;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	public void doIt() {
		TextParser tp = new TextParser();
		
		if (tp.openFile("pg174.txt") == false) {
			System.out.println("Error opening file");
			System.exit(0);
		}
		String word = tp.getNextWord();
		while(word != null) {
			System.out.println(word);
			word = tp.getNextWord();
		}
	}

}
