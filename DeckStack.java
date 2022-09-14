package casino;

/**
 * A stack of more than one deck used in a casino game
 *
 */
public class DeckStack {
	private Deck[] decks;
	private int top = 0;
	private int numDecks2 = 0;
	private int amount = 0;
	
	public DeckStack(int numDecks) {
		decks = new Deck[numDecks];
		int numDecks2 = numDecks;
		for (int i = 0; i < numDecks; i++) {
			decks[i] = new Deck();
		}
	}
	
	public Card dealTopCard() {
		int amountofdecks = 0;
		amount ++;
		for(Deck i : decks) {
			amountofdecks ++;
		}
		int deckrandom = (int)(Math.random()*(amountofdecks-1))+1;
			return decks[deckrandom].dealTopCard();
			
		
		
		
	}
		
	
	
	protected void restoreDecks() {
		int amountofdecks3 = 0;
		amount = 0;
		for(Deck i : decks) {
			amountofdecks3 ++;
		}
		for(int i = 0; i < amountofdecks3; i++) {
			decks[i].restockDeck();
		}
		
	}
	
	public int cardsLeft() {
		int amountofdecks4 = 0;
		for(Deck i : decks) {
			amountofdecks4 ++;
		}
		
		int crds = amountofdecks4 * 52 - amount;
		
				
		return amountofdecks4 * 52 - amount;
	}
	
	
}
