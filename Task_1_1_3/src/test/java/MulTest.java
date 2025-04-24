import nsu.pivovarov.Expression;
import nsu.pivovarov.Mul;
import nsu.pivovarov.Number;
import nsu.pivovarov.Variable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * All tests for Mul class.
 */
public class MulTest {
    /**
     * Check string representation.
     */
    @Test
    public void stringRepresentation() {
        Mul mul = new Mul(new Number(2), new Variable("dead_inside"));
        Assertions.assertEquals(mul.stringRepresentation(), "(2 * dead_inside)");
    }

    /**
     * Test evaluation.
     */
    @Test
    public void eval() {
        Mul mul = new Mul(new Number(5), new Variable("x"));
        Assertions.assertEquals(mul.eval("x = 10"), 50);
    }

    /**
     * Check derivative.
     */
    @Test
    public void derivative() {
        Mul mul = new Mul(new Number(5), new Variable("x"));
        Expression derivative = mul.derivative("x");
        Assertions.assertEquals(derivative.eval("x = 10000"), 5);
        Assertions.assertEquals(derivative.stringRepresentation(), "((0 * x) + (5 * 1))");
    }
}
