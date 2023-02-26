
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver me = new Driver();
		me.doIt();
	}
	
	private void doIt() {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		//System.out.println(deck);
//		for (int i = 0; i < 5; i++) {
//			System.out.println(deck.drawCard());
//		}
//		System.out.println();
		
		//System.out.println(deck);
		//System.out.println();
		deck.shuffle();
		System.out.println(deck);
		
		Card g = deck.drawCard();
		deck.shuffle();
		System.out.println(deck);
		
		deck.returnCard(g);
		deck.shuffle();
		System.out.println();
		System.out.println(deck);
	}

}
