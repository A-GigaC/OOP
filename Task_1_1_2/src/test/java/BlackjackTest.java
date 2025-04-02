import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** TEets for Blackjack class. */
public class BlackjackTest {
    /** Check correct BJ creating. */
    @Test
    public void testBlackjackCreating() {
        Blackjack blackjack = new Blackjack();

        Assertions.assertNotNull(blackjack);
    }
}
