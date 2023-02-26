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
				System.out.println("Commands are as follows:\n"
						+ "'a' - add a new entry to the list\n"
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

		AddressBook test = new AddressBook();
		test.add("Mary Jane", "mj@aol.com", "123456789");
		test.add("Mary Jane", "420@gmail.com", "4206969");
		test.add("Mary Jane", "blazeIt@gmail.com", "lul");
		test.add("John Doe", "jd@gmail.com", "8005555555");
		test.add("Joe Dangerous", "jd@gmail.com", "dont call me haha");
		test.add("Jane Goodall", "jg@gmail.com", "8082223535");
		test.add("Bill Rager", "gohard123@gmail.com", "whatever");
		Node test1 = new Node();
		Node test2 = new Node();
		test1.setName("John Doe");
		test2.setName("John Doe");
//		System.out.println(test1.getLast());
//		System.out.println(test2.getLast());
//		System.out.println(test1.getLast().compareTo(test2.getLast()));
		test.printAll();
		System.out.println();
		test.printIndex(1);
		test.printIndex(2);
		test.search("Joe Dangerous");
		test.modify(5, null, "jd@gmail.com", null);
//		test.printIndex(4);
//		test.delete(6);
//		test.delete(3);
//		test.delete(1);
//		test.delete(6);
//		test.search("Mary Jane");
//		test.printIndex(2);
		test.printIndex(-500);
		System.out.println();
		test.email("jd@gmail.com");

	}
}
