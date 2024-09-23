import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**  All tests for Player class. */
public class PlayerTest {
    /** Check .getScore() correctness. */
    @Test
    public void playerGetScore() {
        Deck deck = new Deck();
        Player player = new Player(deck);

        Card card = player.getCard();

        Assertions.assertEquals(card.getValue(), player.getScore());
    }

    /** Check .getStatus correctness. */
    @Test
    public void playerGetStatus() {
        Deck deck = new Deck();
        Player player = new Player(deck);

        player.getStatus();
    }

}
