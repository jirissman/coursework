package homework4;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.getInput();
	}

	private void getInput() {
		Hashtable table = new Hashtable();
		Scanner kbd = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Enter a command. Enter 'h' for help.");
			String command = kbd.next().toLowerCase();
			kbd.nextLine();
			switch (command) {
			case "h": {
				System.out.println("Commands are as follows:\n"
						+ "'a' - add a new entry to the hashtable\n"
						+ "'s' - search for an entry in the hashtable\n"
						+ "'d' - delete an entry from the hashtable\n"
						+ "'p' - print the hashtable\n"
						+ "'q' - quit the program");
				break;
			}
			case "a": {
				System.out.println("Enter the value to be added to the hashtable:");
				String value = kbd.nextLine();
				table.add(value);
				System.out.println("New entry " + value + " added.");
				break;
			}
			case "p": {
				table.printHash();
				break;
			}
			case "s": {
				System.out.println("Enter the value to search:");
				String value = kbd.nextLine();
				System.out.println(table.search(value) ? "Value is in the hashtable" : "Value is not in the hashtable");
				break;
			}
			case "d": {
				System.out.println("Enter the value to delete:");
				String value = kbd.nextLine();
				table.delete(value);
				break;
			}
			case "q": {
				done = true;
				break;
			}
			default:
				System.out.println("Unexpected command: " + command);
				break;
			}
		}
		kbd.close();
	}
}
