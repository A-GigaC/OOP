import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import nsu.pivovarov.Variable;

/**
 * All test for Variable class.
 */
public class VariableTest {
    /**
     * Check string representation.
     */
    @Test
    public void stringRepresentation() {
        Variable variable = new Variable("x");
        Assertions.assertEquals("x", variable.stringRepresentation());
    }

    /**
     * Check evaluation.
     */
    @Test
    public void eval() {
        Variable variable = new Variable("x");
        Assertions.assertEquals(variable.eval("x = 159") + 1, 160);
    }

    /**
     * Test derivative.
     */
    @Test
    public void derivative() {
        Variable variable = new Variable("x");
        Assertions.assertEquals(variable.derivative("x"), 1);
    }

    /**
     * Test derivative on other variable.
     */
    @Test
    public void derivativeOnOtherVariable() {
        Variable variable = new Variable("x");
        Assertions.assertEquals(variable.derivative("aboba"), 0);

        variable.print();
    }
}