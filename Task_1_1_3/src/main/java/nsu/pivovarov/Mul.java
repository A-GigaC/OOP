package nsu.pivovarov;

/**
 * Multiplication of two expressions.
 */
public class Mul extends NonAtomicExpression {
    /**
     * Constructor gets left and right operand.
     */
    public Mul(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    /**
     * Implements eval.
     */
    public int eval(String variablesWithValues) {
        return leftOperand.eval(variablesWithValues) * rightOperand.eval(variablesWithValues);
    }

    /**
     * Implements derivative.
     */
    public Expression derivative(String variableName) {
        return new Add(
            new Mul(leftOperand.derivative(variableName), rightOperand),
            new Mul(leftOperand, rightOperand.derivative(variableName))
        );
    }

    /**
     * Implements string representation.
     */
    public String stringRepresentation() {
        return "("
                + leftOperand.stringRepresentation()
                + " * "
                + rightOperand.stringRepresentation()
                + ")";
    }
}
