
public class LLCoinCollection implements CoinInterface {
	private Node head;
	private int count;
	
	public boolean add(int year, char mint, String condition) {
		Coin nca = new Coin();
		nca.setCondition(condition);
		nca.setYear(year);
		nca.setMint(mint);
		
		Node n = new Node();
		n.setCoin(nca);
		
		if (count == 0) {
			head = n;
			count = 1;
			return true;
		} 
		
		// Add to the list
		n.setNext(head);
		head = n;
		count++;
		return true;
	}

	public boolean remove(int year, char mint, String condition) {
		
		Node cur = head;
		Node prev = null;
		
		while(cur != null) {
			if (cur.getCoin().getYear() == year) {
				if (cur.getCoin().getMint() == mint) {
					if (cur.getCoin().getCondition().equals(condition)) {
						// Delete this coin
						if (prev == null) {
							// Coin is first in line
							head = head.getNext();
							count--;
							return true;
						} else {
							prev.setNext(cur.getNext());
							count--;
							return true;
						}
					}
				}
			}

			prev = cur;
			cur = cur.getNext();
		}

		return false;
	}

	public Coin[] search(int year) {
		int cnt = 0;
		
		Node tmp = head;
		while(tmp != null) {
			if (tmp.getCoin().getYear() == year) {
				cnt++;
			}
			
			tmp = tmp.getNext();
		}
		
		if (cnt == 0) {
			// We did not find any coins
			return null;
		}
		
		Coin nca[] = new Coin[cnt];
		int cnt2 = 0;
		tmp = head;
		while(tmp != null) {
			if (tmp.getCoin().getYear() == year) {
				nca[cnt2++] = tmp.getCoin();
			}
			
			tmp = tmp.getNext();
		}
		
		return nca;
	}
	
	public Coin[] search(char mint) {
		int cnt = 0;
		
		Node tmp = head;
		while(tmp != null) {
			if (tmp.getCoin().getMint() == mint) {
				cnt++;
			}
			
			tmp = tmp.getNext();
		}
		
		if (cnt == 0) {
			// We did not find any coins
			return null;
		}
		
		Coin nca[] = new Coin[cnt];
		int cnt2 = 0;
		tmp = head;
		for(tmp = head; tmp != null; tmp = tmp.getNext()) {
			if (tmp.getCoin().getMint() == mint) {
				nca[cnt2++] = tmp.getCoin();
			}
			
			//tmp = tmp.getNext();
		}
		
		return nca;
	}
	
	public Coin[] search(String condition) {
		int cnt = 0;
		
		Node tmp = head;
		while(tmp != null) {
			if (tmp.getCoin().getCondition().equals(condition)) {
				cnt++;
			}
			
			tmp = tmp.getNext();
		}
		
		if (cnt == 0) {
			// We did not find any coins
			return null;
		}
		
		Coin nca[] = new Coin[cnt];
		int cnt2 = 0;
		tmp = head;
		for(tmp = head; tmp != null; tmp = tmp.getNext()) {
			if (tmp.getCoin().getCondition().equals(condition)) {
				nca[cnt2++] = tmp.getCoin();
			}
			
			//tmp = tmp.getNext();
		}
		
		return nca;
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
		
		Node tmp = head;
		
		String rtn = "";
		while(tmp != null) {
			rtn += "Year: " + tmp.getCoin().getYear() + ", ";
			rtn += "Mint: " + tmp.getCoin().getMint() + ", ";
			rtn += "Cond: " + tmp.getCoin().getCondition();
			if (tmp.getNext() != null) {
				rtn += "\n";
			}
			
			tmp = tmp.getNext();
		}
		return rtn ;
	}


}
