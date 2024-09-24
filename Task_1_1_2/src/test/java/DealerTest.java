import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** All tests for Dealer class. */
public class DealerTest {
    /** Check correctness of .getClosedCard(). */
    @Test
    public void openClosedCardTwice() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        dealer.getClosedCard();

        Card card = dealer.openCard();
        Assertions.assertNull(dealer.openCard());
    }

    /** Check correctness of .openCard(). */
    @Test
    public void getClosedCard() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        dealer.getClosedCard();

        int score = dealer.getScore();
        Card closedCard = dealer.openCard();

        Assertions.assertEquals(score, closedCard.getValue());
    }

    /** check .resetGame() correctness. */
    @Test
    public void dealerReset() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        deck = new Deck();
        dealer.resetGame(deck);
    }

    /** Check .getStatus() */
    @Test
    public void dealerGetStatus() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        dealer.getStatus();
    }

    /** Check .getCard(). */
    @Test
    public void dealerGetCard() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        Card card = dealer.getCard();

        Assertions.assertEquals(dealer.getScore(), card.getValue());
    }
}
