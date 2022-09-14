package agents;

import casino.BlackjackPlayer;
import casino.Card;
import casino.Move;

public class MyBlackjackPlayer extends BlackjackPlayer{
	int pay = 7;
	@Override
	public int getBet() {
		return pay;
			
		
	}

	@Override
	public Move getMove() {
		/* Hits until we get a score of 16 or better */
		int dealerHand = this.dealer.getVisibleCard().getRank();
		if (dealerHand > 10)
			dealerHand = 10;
		if (this.handScore() <= 8)
			return Move.HIT;
		if (this.handScore() == 9 && dealerHand == 3 || this.handScore() == 9 && dealerHand == 4 || this.handScore() == 9 && dealerHand == 5 || this.handScore() == 9 && dealerHand == 6) {
			return Move.DOUBLE;}
		if (this.handScore() == 9 && dealerHand <= 2 || this.handScore() == 9 && dealerHand <= 7) {
			return Move.HIT;}
		if (this.handScore() == 10 && dealerHand != 1)
			return Move.DOUBLE;
		if (this.handScore() == 1 && dealerHand != 1)
			return Move.DOUBLE;
		if (dealerHand >= 6 && this.handScore() <= 16 || dealerHand == 1 && this.handScore() <= 16 ) {
			return Move.HIT;}
			
		return Move.STAY;
	}

	@Override
	public void handOver(Card[] dealerHand) {
		int dealerHand2 = this.dealer.getVisibleCard().getRank();
		if (dealerHand2 > 10)
			dealerHand2 = 10;
		if(this.handScore() > 21)
			pay = pay * 2;
		if(dealerHand2 == 1)
			pay = pay * 2;
		if(this.handScore() <= 21)
			pay = 7;
		
		
			
		/**
		 * If you care about looking at the dealer's hand once
		 * the hand is over, then you can do it here. This method
		 * is called automatically after every hand and a copy of the dealer's
		 * final hand is given to you to process.
		 */
		
	}

	
}
