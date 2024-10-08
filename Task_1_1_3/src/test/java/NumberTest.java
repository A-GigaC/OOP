import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import nsu.pivovarov.Number;

public class NumberTest {
    /**
     * Check string representation.
     */
    @Test
    public void stringRepresentation() {
        Number number = new Number(8);
        Assertions.assertEquals("8", number.stringRepresentation());
    }

    /**
     * Test evaluation.
     */
    @Test
    public void eval() {
        Number number = new Number(8);
        Assertions.assertEquals(number.eval("") + 1, 9);
    }

    /**
     * Check derivative.
     */
    @Test
    public void derivative() {
        Number number = new Number(8);
        Assertions.assertEquals(number.derivative("aboba").eval(""), 0);

        number.print();
    }
}
