package LinkedList.CoinCollection;


public class CoinNode {
	private Coin coin;
	private CoinNode next;
	
	public Coin getCoin() {
		return coin;
	}
	public void setCoin(Coin coin) {
		this.coin = coin;
	}
	public CoinNode getNext() {
		return next;
	}
	public void setNext(CoinNode next) {
		this.next = next;
	}
}
