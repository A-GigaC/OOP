import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/* All tests for Player class */
public class PlayerTest {
    @Test
    public void playerGetScore() {
        Deck deck = new Deck();
        Player player = new Player(deck);

        Card card = player.getCard();

        Assertions.assertEquals(card.getValue(), player.getScore());
    }

    @Test
    public void playerGetStatus() {
        Deck deck = new Deck();
        Player player = new Player(deck);

        player.getStatus();
    }

}
