package Recursion;

public class MazeSolverDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MazeSolverDriver me = new MazeSolverDriver();
		me.doIt();
	}
	
	public void doIt() {
		
		MazeSolver s = new MazeSolver();
		
		s.solve(0, 0, MazeNode.NORTH);
	}

}
