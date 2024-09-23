import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackjackTest {
    @Test
    public void testBlackjackCreating() {
        Blackjack blackjack = new Blackjack();

        Assertions.assertNotNull(blackjack);
    }
}
