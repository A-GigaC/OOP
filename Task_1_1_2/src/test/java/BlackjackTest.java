import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackjackTest {
    // Correct BJ creating
    @Test
    public void testBlackjackCreating() {
        Blackjack blackjack = new Blackjack();

        Assertions.assertNotNull(blackjack);
    }
}
