package LinkedList.CoinCollection;

import java.util.Scanner;

public class CoinDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinDriver me = new CoinDriver();
		me.doIt();
	}

	private void doIt() {
		Scanner kbd = new Scanner(System.in);
		boolean done = false;
		String originalInput;
		String lowerInput;

		CoinInterface col = new LLCoinCollection();

		while (!done) {
			System.out.print("Enter command (? for help)\n-> ");
			originalInput = kbd.nextLine();
			lowerInput = originalInput.toLowerCase();

			switch (lowerInput) {
			case "?":
				System.out.println("Help goes here...");
				break;

			case "q":
				done = true;
				System.out.println("Bye...");
				break;

			case "a": {
				String inp;
				String condition;
				char mint = 'd';
				int year;

				System.out.print("Enter year: ");
				inp = kbd.nextLine();
				try {
					year = Integer.parseInt(inp);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid year!");
					break;
				}

				System.out.print("Enter mint: ");
				inp = kbd.nextLine();
				if (inp.length() != 1) {
					System.out.println("Mint must be a single character");
					break;
				}

				mint = inp.charAt(0);

				System.out.print("Enter cond: ");
				inp = kbd.nextLine();

				condition = inp;

				col.add(year, mint, condition);

				break;
			}

			case "d": {
				String inp;
				String condition;
				char mint = 'd';
				int year;

				System.out.print("Enter year: ");
				inp = kbd.nextLine();
				try {
					year = Integer.parseInt(inp);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid year!");
					break;
				}

				System.out.print("Enter mint: ");
				inp = kbd.nextLine();
				if (inp.length() != 1) {
					System.out.println("Mint must be a single character");
					break;
				}

				mint = inp.charAt(0);

				System.out.print("Enter cond: ");
				inp = kbd.nextLine();

				condition = inp;

				col.remove(year, mint, condition);

				break;
			}

			case "p":
				System.out.println(col);
				break;

			case "sm": {
				// Search by mint
				System.out.print("Enter mint character: ");
				String inp = kbd.nextLine();
				Coin rtn[] = col.search(inp.charAt(0));

				if (rtn.length == 0) {
					System.out.println("No Coins found");
				} else {
					System.out.println(rtn.length + " Coin(s) found");

					for (int i = 0; i < rtn.length; i++) {
						System.out.println(col.printCoin(rtn[i]));
					}
					System.out.println();
				}
				break;
			}

			case "sy": {
				// Search by year
				System.out.print("Enter year: ");
				String inp = kbd.nextLine();
				Coin rtn[] = col.search(Integer.parseInt(inp));

				if (rtn.length == 0) {
					System.out.println("No Coins found");
				} else {
					System.out.println(rtn.length + " Coin(s) found");

					for (int i = 0; i < rtn.length; i++) {
						System.out.println(col.printCoin(rtn[i]));
					}
					System.out.println();
				}
				break;
			}

			case "sc": {
				// Search by mint
				System.out.print("Enter Condition: ");
				String inp = kbd.nextLine();
				Coin rtn[] = col.search(inp);

				if (rtn.length == 0) {
					System.out.println("No Coins found");
				} else {
					System.out.println(rtn.length + " Coin(s) found");

					for (int i = 0; i < rtn.length; i++) {
						System.out.println(col.printCoin(rtn[i]));
					}
					System.out.println();
				}
				break;
			}
			}

		}
		kbd.close();
	}
}
