import nsu.pivovarov.Add;
import nsu.pivovarov.Expression;
import nsu.pivovarov.Number;
import nsu.pivovarov.Variable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for Add class.
 */
public class AddTest {
    /**
     * Numbers addition test.
     */
    @Test
    public void addNumbers() {
        Expression add = new Add(new Number(3), new Number(7));
        Assertions.assertEquals(add.eval(""), 10);
    }

    /**
     * Number and variable addition test.
     */
    @Test
    public void addNumberAndVariable() {
        Expression add = new Add(new Variable("x"), new Number(7));
        Assertions.assertEquals(add.eval("x = 12"), 19);
    }

    /**
     * Check string representation.
     */
    @Test
    public void stringRepresentation() {
        Expression add = new Add(new Number(15), new Variable("y"));
        Assertions.assertEquals(add.stringRepresentation(), "(15 + y)");
    }

    /**
     * Test derivative.
     */
    @Test
    public void derivative() {
        Expression add = new Add(new Number(100000), new Variable("xyz"));
        Assertions.assertEquals(add.derivative("xyz").eval(""), 1);

        add.print();
    }
}
