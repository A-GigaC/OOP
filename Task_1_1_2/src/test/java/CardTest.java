import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    public void suitEquation() {
        Suit suit = Suit.Hearts;
        Rank rank = Rank.Two;
        Card card = new Card(suit, rank);

        Assertions.assertEquals(card.getSuit(), suit);
    }

    @Test
    public void rankEquation() {
        Rank rank = Rank.Jack;
        Suit suit = Suit.Spades;
        Card card = new Card(suit, rank);

        Assertions.assertEquals(card.getRank(), rank);
    }

    @Test
    public void valueEquation() {
        Rank rank = Rank.Queen;
        Suit suit = Suit.Diamonds;
        Card card = new Card(suit, rank);

        Assertions.assertEquals(card.getValue(), 10);
    }
}
