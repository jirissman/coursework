
public class ArrayBag {

	Integer []bag;
	private static final int BAG_SIZE = 12;
	private int count;
	
	public ArrayBag() {
		bag = new Integer[BAG_SIZE];
		count = 0;
	}
	
	public ArrayBag(int initialCapacity) {
		bag = new Integer[initialCapacity];
		count = 0;
	}
	
	public int size() {
		return count;
	}
	
	public void ensureCapacity(int minimumCapacity) {
		
		if (bag.length > minimumCapacity) {
			// Bag is already big enough
			return;
		}
		
		Integer []newBag = new Integer[minimumCapacity];
		
		for (int i = 0; i < size(); i++) {
			newBag[i] = bag[i];
		}
		
		bag = newBag;
		
	}
	
	public int getCapacity() {
		return bag.length;
		
	}
	
	public void addMany(Integer... elements) {
		
		for (Integer d:elements) {
			add(d);
		}
		
	}
	
	public boolean add(Integer value) {
		
		if (size() == getCapacity()) {
			ensureCapacity(size() + BAG_SIZE);
		}
		
		bag[count++] = value;
		return true;
	}
	
	public int countOccurances(Integer value) {
		int counter = 0;
		
		for (int i = 0; i < size(); i++) {
			if (bag[i].equals(value)) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public boolean remove(Integer value) {
		int index = internalSearch(value);
		
		if (index < 0) {
			return false;
		}
		
		bag[index] = bag[--count];
		
		return true;
		
	}
	
	private int internalSearch(Integer value) {
		for (int i = 0; i < size(); i++ ) {
			if (bag[i].equals(value)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void trimToSize() {
		Integer []newBag = new Integer[size()];
		
		for (int i = 0; i < size(); i++) {
			newBag[i] = bag[i];
		}
		
		bag = newBag;
	}
	
	public boolean search(Integer value) {
		
		return (internalSearch(value) >= 0);
	}
	
	public String toString() {
		String rtn = "";
		
		if (size() == 0) {
			rtn += "<Empty>";
		} else {
			for (int i = 0; i < size(); i++) {
				rtn += "bag[" + i + "] = " + bag[i] + "\n";
			}
		}
		
		return rtn;
	}
}
