package QueensPuzzle;

//If two queens are placed at position (i, j) and (k, l).
//Then they are on same diagonal only if (i - j) = k - l or i + j = k + l.
//The first equation implies that j - l = i - k.
//The second equation implies that j - l = k - i.
//Therefore, two queens lie on the duplicate diagonal if and only if |j-l|=|i-k|
public class NQueens {

//	private boolean place(int k, int i) {
//		for (int j = 1; j <= k - 1; j++) {
//			if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
//				return false;
//			}
//		}
//		return true;
//	}

	private void printSolution(Stack choices) {
		while (choices.depth() > 0) {
			for (int i = 1; i <= 8; i++) {
				if (choices.peek() == i) {
					System.out.print("Q ");
				} else {
					System.out.print("- ");
				}
			}
			choices.pop();
			System.out.println();
		}
	}

	private boolean valid(Stack choices) {
		Stack test = choices;
		// record row and column of the top choice
		int row = test.depth();
		int col = test.pop();
		// while there are still choices to check
		while (test.depth() > 0) {
			// check if next choice has the same column as top choice
			if (test.peek() == col) {
				return false;
			}
			// check if next choice is in the same diagonal as top choice
			if (Math.abs(test.depth() - row) == Math.abs(test.peek() - col)) {
				return false;
			}
			test.pop(); // pop to the next level
		}

		// we reached the bottom of the stack, it must be valid!
		return true;
	}

	public void solve() {
		Stack choices = new Stack();
		while (choices.depth() < 8) {
			choices.push(1);
			
			while (!valid(choices)) {
				// if the top choice is incorrect, pop it off then add 1 and push it back on
				int guess = choices.pop();
				choices.push(guess + 1);
				choices.pop();
			}
		}
		printSolution(choices);
	}
}