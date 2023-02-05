package ContainerClasses;

import java.util.Arrays;
import java.util.Random;

public class CardDeck {
	private Card[] deck;
	private int currentCard;

	public CardDeck() {
		deck = new Card[52];

		int count = 0;
		Card.SUIT suit = Card.SUIT.HEARTS;
		for (int i = 0; i < 4; i++) {
			Card.FACE face = Card.FACE.ACE;
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
		for (int i = 0; i < 1000; i++) {
			int card1 = gen.nextInt(52);
			int card2 = gen.nextInt(52);
			if (deck[card1].isInDeck()==true && deck[card2].isInDeck()==true) {
			// swap the cards
			Card tmp = deck[card1];
			deck[card1] = deck[card2];
			deck[card2] = tmp;
			}
		}
	}
	
	public Card drawCard() {
		if (currentCard==52) {
			// out of deck
			return null;
		}
		Card rtn = deck[currentCard++];
		rtn.setInDeck(false);
		return rtn;
	}
	
	public void returnCard(Card card) {
		for (int i = 0; i < 52; i++) {
			if (deck[i].equals(card)) {
				deck[i].setInDeck(true);
			}
		}
	}

	@Override
	public String toString() {
		String rtn = "";
		for (int i = 0; i < 52; i++) {
			rtn += deck[i] + "\n";
		}
		return "CardDeck [deck=" + Arrays.toString(deck) + "]";
	}

}
