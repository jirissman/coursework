package LinkedList.CoinCollection;


public interface CoinInterface {

	boolean add(int year, char mint, String condition);

	boolean remove(int year, char mint, String condition);

	Coin[] search(int year);

	Coin[] search(char mint);

	Coin[] search(String condition);

	String printCoin(Coin coin);

}