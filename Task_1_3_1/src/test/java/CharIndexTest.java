import org.example.StatusCharIndex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test for CharIndex.
 */
public class CharIndexTest {
    /**
     * Test for CharIndex.
     */
    @Test
    public void constructorTest() {
        char character = 'f';
        int integer = 42;
        StatusCharIndex ci = new StatusCharIndex(0, character, integer);
        Assertions.assertEquals(integer, ci.index);
        Assertions.assertEquals(character, ci.character);
    }
}
