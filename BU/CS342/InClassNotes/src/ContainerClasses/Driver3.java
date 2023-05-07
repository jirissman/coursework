package ContainerClasses;

public class Driver3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver3 me = new Driver3();
		me.doIt();
	}

	public void doIt() {
		CardDeck deck = new CardDeck();
		System.out.println(deck.toString());
		deck.shuffle();
//		for ( int i = 0; i < 5; i++) {
//			System.out.println(deck.drawCard());
//		}
//		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		Card g = deck.drawCard();
		deck.shuffle();
		System.out.println(deck);
		deck.returnCard(g);
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
	}
}
