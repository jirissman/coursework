package Hashing;


public class OAHash {
	private static final int TABLE_SIZE = 31;
	private static final int NEVER_USED = -1;
	private static final int PREV_USED = -2;
	private static final int NOT_FOUND = -1;

	private int []table;

	public OAHash() {
		table = new int[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = NEVER_USED;
		}
	}

	private int hashFunction(int data) {
		return data % TABLE_SIZE;
	}

	private int probeVal = 1;

	private void resetProbe() {
		probeVal = 1;
	}

	private int quadProbe(int location) {
		int rtn = (location + (probeVal * probeVal)) % TABLE_SIZE;
		probeVal++;
		
		return rtn;
	}

	public boolean add(int value) {

		// Return true if it is already there
		if (search(value)) {
			return true;
		}
		
		// If we need to probe reset the value
		resetProbe();
		int loc = hashFunction(value);
		int probeLoc = loc;

		// Loop this so we don't spin forever trying to add
		for (int i = 0; i < TABLE_SIZE; i++) {
			//System.out.println("probeLoc = " + probeLoc);
			if ((table[probeLoc] == NEVER_USED) || (table[probeLoc] == PREV_USED)) {
				table[probeLoc] = value;
				return true;
			}

			// Getting here means there was a collision
			probeLoc = quadProbe(loc);

		}
		return false;
	}

	public boolean search(int value) {
		return (internalSearch(value) != NOT_FOUND);
	}

	private int internalSearch(int value) {
		resetProbe();
		int loc = hashFunction(value);
		int probeLoc = loc;

		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[probeLoc] == value) {
				return probeLoc;
			}

			if (table[probeLoc] == NEVER_USED) {
				return -1;
			} else {
				// Must be a PREV_USED or other value
				probeLoc = quadProbe(loc);
			}
		}
		
		return NOT_FOUND;
	}
	
	public boolean delete(int value) {
		int loc = internalSearch(value);
		if (loc == NOT_FOUND) {
			return false; 
		}
		
		table[loc] = PREV_USED;
		return true;
	}
	
	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < TABLE_SIZE; i++) {
			rtn += "table[" + i + "] = " + 
		           ((table[i] == NEVER_USED) ? "NEVER_USED\n" : (table[i] == PREV_USED) ? "PREV_USED\n" :
				     table[i] + "\n");
		}
		
		return rtn;
	}
}
