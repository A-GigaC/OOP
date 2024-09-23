import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTest {
    @Test
    public void deckCardUniqueness() {
        Deck deck = new Deck();
        Card card1 = deck.peek();
        Card card2 = deck.peek();
        String card1String = card1.getRank() + " " + card1.getSuit();
        String card2String = card2.getRank() + " " + card2.getSuit();

        Assertions.assertNotEquals(card1, card2);
        Assertions.assertNotEquals(card1String, card2String);
    }
}
