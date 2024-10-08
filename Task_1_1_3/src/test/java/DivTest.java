import nsu.pivovarov.Div;
import nsu.pivovarov.Expression;
import nsu.pivovarov.Number;
import nsu.pivovarov.Variable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * All test fir Div class.
 */
public class DivTest {
    /**
     * Check string representation.
     */
    @Test
    public void stringRepresentation() {
        Div div = new Div(new Number(8), new Variable("x7"));
        Assertions.assertEquals("(8 / x7)", div.stringRepresentation());

        div.print();
    }

    /**
     * Test evaluation.
     */
    @Test
    public void eval() {
        Div div = new Div(new Number(10), new Variable("x"));
        Assertions.assertEquals(div.eval("x = 2"), 5);
    }

    /**
     * Check derivative.
     */
    @Test
    public void derivative() {
        Div div = new Div(new Number(10), new Variable("x"));
        Expression divDerivative = div.derivative("x");
        Assertions.assertEquals(divDerivative.stringRepresentation(), "(((0 * x) - (10 * 1)) / (x * x))");
    }
}
