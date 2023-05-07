package LinkedList.CoinCollection;


public class ArrCoinCollection implements CoinInterface {

	private Coin []array;
	private int count;
	private static final int ARRAY_SIZE = 16;
	
	public ArrCoinCollection() {
		array = new Coin[ARRAY_SIZE];
		count = 0;
	}
	

	public boolean add(int year, char mint, String condition) {
		if (isFull()) {
			return false;
		} else {
			Coin newCoin = new Coin();
			newCoin.setCondition(condition);
			newCoin.setMint(mint);
			newCoin.setYear(year);
			
			array[count++] = newCoin;
		}
		return true;
	}
	

	public boolean remove(int year, char mint, String condition) {
		
		for (int i = 0; i < count; i++) {
			if (array[i].getYear() == year) {
				if (array[i].getMint() == mint) {
					if (array[i].getCondition().equals(condition)) {
						// Delete this coin
						array[i] = array[--count];
						return true;
					}
				}
			}
		}
		return false;
	}
	

	public Coin[] search(int year) {
		int cnt = 0;
		for (int i = 0; i < count; i++) {
			if (array[i].getYear() == year) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			// We did not find any coins
			return null;
		}
		
		Coin nca[] = new Coin[cnt];
		int cnt2 = 0;
		for (int i = 0; i < count; i++) {
			if (array[i].getYear() == year) {
				nca[cnt2++] = array[i];
			}
		}
		
		return nca;
	}
	
	public Coin[] search(char mint) {
		int cnt = 0;
		for (int i = 0; i < count; i++) {
			if (array[i].getMint() == mint) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			// We did not find any coins
			return null;
		}
		
		Coin nca[] = new Coin[cnt];
		int cnt2 = 0;
		for (int i = 0; i < count; i++) {
			if (array[i].getMint() == mint) {
				nca[cnt2++] = array[i];
			}
		}
		
		return nca;
		
	}
	
	public Coin[] search(String condition) {
		int cnt = 0;
		for (int i = 0; i < count; i++) {
			if (array[i].getCondition().equals(condition)){
				cnt++;
			}
		}
		
		if (cnt == 0) {
			// We did not find any coins
			return null;
		}
		
		Coin nca[] = new Coin[cnt];
		int cnt2 = 0;
		for (int i = 0; i < count; i++) {
			if (array[i].getCondition().equals(condition)) {
				nca[cnt2++] = array[i];
			}
		}
		
		return nca;
		
	}
	
	private boolean isFull() {
		return (count == array.length);
	}
	
	public String printCoin(Coin coin) {
		
		if (coin == null) {
			return null;
		}
		
		String rtn = "";
		rtn += "Year: " + coin.getYear() + ", ";
		rtn += "Mint: " + coin.getMint() + ", ";
		rtn += "Cond: " + coin.getCondition();
		return rtn;
	}
	
	public String toString() {
		
		if (count == 0) {
			return "<Empty>";
		}
		
		String rtn = "";
		for (int i = 0; i < count; i++) {
			rtn += "Year: " + array[i].getYear() + ", ";
			rtn += "Mint: " + array[i].getMint() + ", ";
			rtn += "Cond: " + array[i].getCondition();
			if (i != count-1) {
				rtn += "\n";
			}
		}
		return rtn ;
	}
}
