import java.util.Random;

public class CardDeck {
	private Card []deck;
	private int currentCard;
	
	public CardDeck() {
		deck = new Card[52];
		reinitialize();
		
	}
	
	public void reinitialize() {
		Card.SUIT suit = Card.SUIT.HEARTS;
		Card.FACE face;
		int count = 0;
		for (int i = 0; i < 4; i++) {
			face = Card.FACE.ACE;
			for (int j = 0; j < 13; j++) {
				deck[count] = new Card();
				deck[count].setSuit(suit);
				deck[count].setValue(face);
				deck[count].setInDeck(true);
				
				face = Card.FACE.values()[face.ordinal() + 1];
				count++;
			}
			suit = Card.SUIT.values()[suit.ordinal() + 1];
		}
		currentCard = 0;
		
	}
	
	void shuffle() {
		Random gen = new Random();
		
		// Pick 2 cards at random and swap them 1000 times
		for (int i = 0; i < 1000; i++) {
			int card1 = gen.nextInt(0,52);
			int card2 = gen.nextInt(0,52);
			
			if (deck[card1].isInDeck() == false) {
				continue;
			}

			if (deck[card2].isInDeck() == false) {
				continue;
			}
			// Swap the cards
			Card tmp = deck[card1];
			deck[card1] = deck[card2];
			deck[card2] = tmp;
			
		}
		currentCard = 0;
	}
	
	public Card drawCard() {
		if (currentCard == 52) {
			// End of deck, error!
			return null;
		}
		
		Card rtn = deck[currentCard++];
		rtn.setInDeck(false);
		
		return rtn;
	}
	
	public void returnCard(Card card) {
		for (int i = 0; i < 52; i++) {
			if (card.equals(deck[i])) {
				card.setInDeck(true);
			}
		}
	}
	
	public String toString() {
		String rtn = "";
		for (int i = 0; i < 52; i++) {
			rtn += deck[i] + "\n";
		}
		return rtn;
	}
}
