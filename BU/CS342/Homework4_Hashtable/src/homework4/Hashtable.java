package homework4;

public class Hashtable {

	private static final int TABLE_SIZE = 31;
	private static final String NEVER_USED = "NEVER_USED";
	private static final String PREV_USED = "PREV_USED";
	private static final int BAD_DATA = -1;
	private static final int NOT_FOUND = -1;
	private String[] table;

	public Hashtable() {
		table = new String[TABLE_SIZE];
		for (int i = 0; i < table.length; i++) {
			table[i] = NEVER_USED;
		}
	}

	private int hashFunction(String data) {
		if (data.equals(NEVER_USED) || data.equals(PREV_USED)) {
			// prevent input of values reserved for hashtable
			return BAD_DATA;
		}
		return data.length() % TABLE_SIZE; // simple hash function to ensure collisions
	}

	private int probeVal = 1;

	private void resetProbe() {
		probeVal = 1;
	}

	private int quadraticProbe(int location) {
		return (location + (probeVal * probeVal++)) % TABLE_SIZE;
	}

	public void add(String value) {

		// Return if it is already there
		if (search(value)) {
			return;
		}

		// If we need to probe reset the value
		resetProbe();
		int loc = hashFunction(value);
		int probeLoc = loc;

		// Loop this so we don't spin forever trying to add
		for (int i = 0; i < TABLE_SIZE; i++) {
			if ((table[probeLoc].equals(NEVER_USED)) || (table[probeLoc].equals(PREV_USED))) {
				table[probeLoc] = value;
				return;
			}

			// There was a collision
			probeLoc = quadraticProbe(loc);

		}
		System.out.println("Unable to add " + value);
		return;
	}

	public boolean search(String value) {
		return (internalSearch(value) != NOT_FOUND);
	}

	private int internalSearch(String value) {
		resetProbe();
		int loc = hashFunction(value);
		int probeLoc = loc;

		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[probeLoc].equals(value)) {
				// found it on the first try!
				return probeLoc;
			}
			if (table[probeLoc].equals(NEVER_USED)) {
				// it's definitely not here
				return -1;
			} else {
				// we haven't found it yet, let's look at the next spot
				probeLoc = quadraticProbe(loc);
			}
		}
		// we tried enough times and never found it
		return NOT_FOUND;
	}

	public void delete(String value) {
		// try to find where the value is in the table
		int loc = internalSearch(value);
		if (loc == NOT_FOUND) {
			// the value isn't there
			System.out.println("Value not found");
		} else {
			// remove from table
			table[loc] = PREV_USED;
			System.out.println("Value " + value + " deleted");
		}
	}

	public void printHash() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			System.out.printf("table[%02d] = %s%n", i, table[i]);
		}
	}
}
