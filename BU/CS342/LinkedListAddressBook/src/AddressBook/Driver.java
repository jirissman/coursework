package AddressBook;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Driver me = new Driver();
		me.doIt();
	}

	private void doIt() {
		AddressBook book = new AddressBook();
		Scanner kbd = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			System.out.println("Enter a command. Enter 'h' for help.");
			String command = kbd.next().toLowerCase();
			kbd.nextLine();
			switch (command) {
			case "h": {
				System.out.println("Commands are as follows:\n" + "'a' - add a new entry to the list\n"
						+ "'p' - print an entry or the entire list\n"
						+ "'s' - search for a name and return all entries that match\n"
						+ "'e' - same as search but for email\n" + "'m' - modify an entry\n" + "'d' - delete an entry\n"
						+ "'q' - quit the program");
				break;
			}
			case "a": {
				System.out.println("Enter the name:");
				String name = kbd.nextLine();
				System.out.println("Enter the email:");
				String email = kbd.nextLine();
				System.out.println("Enter the phone number:");
				String phone = kbd.nextLine();
				book.add(name, email, phone);
				System.out.println("New entry [name=" + name + ", email=" + email + ", phone=" + phone + "] added.");
				break;
			}
			case "p": {
				System.out.println("Enter the index (use 0 to print all entries):");
				while (!kbd.hasNextInt()) {
					System.out.println("Invalid input. Enter the index as an integer (use 0 to print all entries):");
					kbd.nextLine();
				}
				int input = kbd.nextInt();
				if (input == 0) {
					book.printAll();
				} else {
					book.printIndex(input);
				}
				break;
			}
			case "s": {
				System.out.println("Enter the name to search:");
				String name = kbd.nextLine();
				book.search(name);
				break;
			}
			case "e": {
				System.out.println("Enter the email to search:");
				String email = kbd.nextLine();
				book.email(email);
				break;
			}
			case "m": {
				System.out.println("Enter the index to modify:");
				while (!kbd.hasNextInt()) {
					System.out.println("Invalid input. Enter the index as an integer:");
					kbd.nextLine();
				}
				int index = kbd.nextInt();
				kbd.nextLine();
				if (!book.printIndex(index)) { // check is index is valid, if it is print it, otherwise break
					break;
				}
				String name = null;
				String email = null;
				String phone = null;
				System.out.println("Modify the name? (y/n)");
				if (kbd.nextLine().toLowerCase().equals("y")) {
					System.out.println("Enter new name:");
					name = kbd.nextLine();
				}
				System.out.println("Modify the email? (y/n)");
				if (kbd.nextLine().toLowerCase().equals("y")) {
					System.out.println("Enter new email:");
					email = kbd.nextLine();
				}
				System.out.println("Modify the phone number? (y/n)");
				if (kbd.nextLine().toLowerCase().equals("y")) {
					System.out.println("Enter new phone number:");
					phone = kbd.nextLine();
				}
				book.modify(index, name, email, phone);
				System.out.println("Entry at index " + index + " succesfully modified.");
				book.printIndex(index);
				break;
			}
			case "d": {
				System.out.println("Enter the index to delete:");
				while (!kbd.hasNextInt()) {
					System.out.println("Invalid input. Enter the index as an integer:");
					kbd.nextLine();
				}
				int index = kbd.nextInt();
				kbd.nextLine();
				if(book.delete(index)) {
					System.out.println("Entry at index " + index + " succesfully deleted.");
				};
				break;
			}
			case "q": {
				done = true;
				break;
			}
			default:
				System.out.println("Unexpected value: " + command);
				break;
			}
		}
		kbd.close();
	}
}
