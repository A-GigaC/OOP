import nsu.pivovarov.Sub;
import nsu.pivovarov.Expression;
import nsu.pivovarov.Number;
import nsu.pivovarov.Variable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * All tests for Sub class.
 */
public class SubTest {
    /**
     * Substitution of two numbers.
     */
    @Test
    public void SubNumbers() {
        Expression sub = new Sub(new Number(3), new Number(7));
        Assertions.assertEquals(sub.eval(""), -4);
    }

    /**
     * Substitute variable from number.
     */
    @Test
    public void SubNumberAndVariable() {
        Expression sub = new Sub(new Variable("x"), new Number(7));
        Assertions.assertEquals(sub.eval("x = 12"), 5);
    }

    /**
     * Check string representation.
     */
    @Test
    public void stringRepresentation() {
        Expression sub = new Sub(new Number(15), new Variable("y"));
        Assertions.assertEquals(sub.stringRepresentation(), "(15 - y)");
    }

    /**
     * Check derivative.
     */
    @Test
    public void derivative() {
        Expression sub = new Sub(new Number(100000), new Variable("xyz"));
        Assertions.assertEquals(sub.derivative("xyz").eval(""), -1);

        sub.print();
    }
}