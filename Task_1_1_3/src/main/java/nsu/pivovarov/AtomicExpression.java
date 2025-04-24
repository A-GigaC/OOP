package nsu.pivovarov;

/**
 * Atomic expression class, that extended by Number and Variable.
 */
public abstract class AtomicExpression extends Expression {
    @Override
    public void print() {
        System.out.println("(" + stringRepresentation() + "(");
    }
}
