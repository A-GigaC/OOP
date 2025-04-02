package nsu.pivovarov;

/**
 * Non-atomic expression it's expressions, that have 1 operator and 2 operands.
 */
public abstract class NonAtomicExpression extends Expression {
    Expression leftOperand, rightOperand;
}
