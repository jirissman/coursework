package QueensPuzzle;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}

	void doIt() {
	NQueens solution = new NQueens();
	solution.solve();
	}
}
