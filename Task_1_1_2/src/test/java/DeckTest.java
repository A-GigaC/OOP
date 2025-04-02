import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** All tests for Deck class. */
public class DeckTest {
    /** Check that there is no equal cards in deck. */
    @Test
    public void deckCardUniqueness() {
        Deck deck = new Deck();
        Card card1 = deck.peek();
        Card cardI;
        String card1String = card1.getRank() + " " + card1.getSuit();
        String cardIString;
        for (int i = 51; i > 0; i--) {
            cardI = deck.peek();
            Assertions.assertNotEquals(card1, cardI);

            cardIString = cardI.getRank() + " " + cardI.getSuit();
            Assertions.assertNotEquals(card1String, cardIString);
        }
    }
}
