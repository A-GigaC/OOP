package nsu.pivovarov;

/**
 * Division of two expressions.
 */
public class Div extends NonAtomicExpression {
    /**
     * Constructor gets left and right operand.
     */
    public Div(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    /**
     * Implements eval.
     */
    public int eval(String variablesWithValues) {
        return leftOperand.eval(variablesWithValues) / rightOperand.eval(variablesWithValues);
    }

    /**
     * Implements derivative.
     */
    public Expression derivative(String variableName) {
        return new Div(
            new Sub(
                new Mul(leftOperand.derivative(variableName), rightOperand),
                new Mul(leftOperand, rightOperand.derivative(variableName))
            ),
            new Mul(rightOperand, rightOperand)
        );
    }

    /**
     * Implements string representation.
     */
    public String stringRepresentation() {
        return "("
                + leftOperand.stringRepresentation()
                + " / "
                + rightOperand.stringRepresentation()
                + ")";
    }
}
