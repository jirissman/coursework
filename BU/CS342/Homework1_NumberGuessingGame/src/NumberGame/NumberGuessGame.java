package NumberGame;

import java.util.*;

public class NumberGuessGame {

	public static void main(String[] args) {
		NumberGuessGame game = new NumberGuessGame();
		Scanner sc = new Scanner(System.in);
		int answer = game.generateAnswer();
		int guess = game.getInput(sc);
		int counter = 1;
		while (guess != answer) {
			if (guess < answer) {
				System.out.println("Your guess is too low");
			} else {
				System.out.println("Your guess is too high");
			}
			guess = game.getInput(sc);
			counter++;
		}
		System.out.println("Congratulations! It took you " + counter + " guesses to find the answer");
		sc.close();
	}

	private int getInput(Scanner sc) {
		// Function to get guess from user while checking for incorrect input
		int input = 0;
		while (input == 0) {
			System.out.println("Input a number between 1 and 1000:");
			try {
				input = sc.nextInt();
				sc.nextLine();
				if (input < 1 || input > 1000) {
					System.out.println("You entered an invalid number");
					input = 0;
				}
			} catch (Exception e) {
				System.out.println("Invalid input");
				sc.nextLine();
				input = 0;
			}
		}
		return input;
	}

	private int generateAnswer() {
		// Generates a random integer from 1 to 1000
		Random rand = new Random();
		return rand.nextInt(1000) + 1;
	}
}
