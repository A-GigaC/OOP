import org.example.CharIndex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharIndexTest {
    @Test
    public void constructorTest() {
        char character = 'f';
        int integer = 42;
        CharIndex ci = new CharIndex(character, integer);
        Assertions.assertEquals(integer, ci.index);
        Assertions.assertEquals(character, ci.character);
    }
}
