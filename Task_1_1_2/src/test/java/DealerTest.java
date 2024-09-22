import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    public void openClosedCardTwiceTest() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        dealer.getClosedCard();

        Card card = dealer.openCard();
        Assertions.assertNull(dealer.openCard());
    }

    @Test
    public void getClosedCardTest() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        dealer.getClosedCard();

        int score = dealer.getScore();
        Card closedCard = dealer.openCard();

        Assertions.assertEquals(score, closedCard.getValue());
    }
}
