package nsu.pivovarov;

/**
 * Number class extends AtomicExpression.
 */
public class Number extends AtomicExpression {
    public int value;
    /**
     * Constructor gets integer value of number.
     */
    public Number (int value) {
        this.value = value;
    }

    /**
     * Implements eval.
     */
    public int eval(String variablesWithValues) {
        return value;
    }

    /**
     * Implements derivative.
     */
    public Expression derivative(String variableName) {
        return new Number(0);
    }

    /**
     * Implements string representation.
     */
    public String stringRepresentation() {
        return "" + value;
    }
}
