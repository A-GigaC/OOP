package nsu.pivovarov;

/**
 * Subtraction of two expressions.
 */
public class Sub extends NonAtomicExpression {
    /**
     * Constructor gets left and right operand.
     */
    public Sub(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    /**
     * Implements eval.
     */
    public int eval(String variablesWithValues) {
        return leftOperand.eval(variablesWithValues) - rightOperand.eval(variablesWithValues);
    }

    /**
     * Implements derivative.
     */
    public Expression derivative(String variableName) {
        return new Sub(leftOperand.derivative(variableName), rightOperand.derivative(variableName));
    }

    /**
     * Implements string representation.
     */
    public String stringRepresentation() {
        return "("
                + leftOperand.stringRepresentation()
                + " - "
                + rightOperand.stringRepresentation()
                + ")";
    }
}
