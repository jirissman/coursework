package ContainerClasses;

public class Card {
	public enum SUIT {HEARTS, CLUBS, DIAMONDS, SPADES, SUITERROR};
	public enum FACE {ACE, DUECE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, FACEERROR};
	
	private SUIT suit;
	private FACE value;
	private boolean inDeck;
	

	public boolean isInDeck() {
		return inDeck;
	}
	
	public void setInDeck(boolean inDeck) {
		this.inDeck = inDeck;
	}
	public char getSuit() {
		switch (suit) {
		case HEARTS: return '\u2665';
		case CLUBS: return '\u2663';
		case DIAMONDS: return '\u2666';
		case SPADES: return '\u2660';
		default: return '-';
		}
	}
	public void setSuit(SUIT suit) {
		this.suit = suit;
	}
	public FACE getValue() {
		return value;
	}
	public void setValue(FACE value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return getSuit() + " " + getValue() + " - " + isInDeck();
	}
	
	public boolean equals(Card other) {
		boolean rtn = false;
		if (this.getSuit()==other.getSuit()&&this.getValue()==other.getValue()) {
			rtn = true;
		}
		return rtn;
	}
}
