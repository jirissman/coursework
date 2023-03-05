package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.run();

	}

	private void run() {
		// set input to file or keyboard
		boolean inputFromFile = false;
		File file = new File("src/project2/operations.txt");
		Scanner scanner;
		Cache cache = new Cache();
		try {
			scanner = inputFromFile ? new Scanner(file) : new Scanner(System.in);
			boolean done = false;
			while (!done) {
				System.out.println("(R)ead, (W)rite, or (D)isplay Cache?");
				String operation = scanner.nextLine().toUpperCase();
				if (inputFromFile) {
					System.out.println(operation);
				}
				switch (operation) {
				case "R":
					System.out.println("What address would you like read?");
					int readAddress = scanner.nextInt(16);
					scanner.nextLine();
					if (inputFromFile) {
						System.out.printf("%H%n",readAddress);
					}
					cache.Read(readAddress);
					break;
				case "W":
					System.out.println("What address would you like to write to?");
					int writeAddress = scanner.nextInt(16);
					if (inputFromFile) {
						System.out.printf("%H%n",writeAddress);
					}
					System.out.println("What data would you like to write at that address?");
					int writeData = scanner.nextInt(16);
					scanner.nextLine();
					if (inputFromFile) {
						System.out.printf("%H%n",writeData);
					}
					cache.Write(writeAddress, writeData);
					break;
				case "D":
					cache.Display();
					break;
				case "Q":
					done = true;
					System.out.println("Program quit successfully");
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
				if(inputFromFile && !scanner.hasNextLine()) {
					done = true;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
