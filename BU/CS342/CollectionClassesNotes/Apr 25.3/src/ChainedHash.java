
public class ChainedHash {
	private static final int TABLE_SIZE = 31;
	private Node []table;
	
	public ChainedHash() {
		table = new Node[TABLE_SIZE];
	}
	
	public int hashFunction(int value) {
		return value % TABLE_SIZE;
	}
	
	public boolean search(int value) {
		
		int loc = hashFunction(value);
		
		Node tmp = table[loc];
		while(tmp != null) {
			if (tmp.getData() == value) {
				return true;
			}
			
			tmp = tmp.getNext();
		}
		
		return false;
	}
	
	public void add(int value) {
		if (search(value)) {
			// Already there
			return;
		}
		
		int loc = hashFunction(value);
		
		Node newNode = new Node();
		newNode.setData(value);
		newNode.setNext(table[loc]);
		table[loc] = newNode;
	}
	
	public boolean delete(int value) {
		if (!search(value)) {
			return false;
		}
		
		int loc = hashFunction(value);

		Node prev = null;
		Node cur = table[loc];
		
		while(cur != null) {
			if (cur.getData() == value) {
				if (prev == null) {
					// Beginning of list
					table[loc] = table[loc].getNext();
					return true;
				} else {
					prev.setNext(cur.getNext());
					return true;
				}
			}
			
			prev = cur;
			cur = cur.getNext();
		}
		
		return false;
	}
	
	public String toString() {
		String rtn = "";
		
		for (int i = 0; i < TABLE_SIZE; i++) {
			rtn += "table[" + i + "] = ";
			if (table[i] == null) {
				rtn += "<null>\n";
			} else {
				Node tmp = table[i];
				while(tmp != null) {
					rtn += tmp.getData() + " -> ";
					tmp = tmp.getNext();
				}
				rtn += "<null>\n";
			}
		}
		
		return rtn;
	}

}
