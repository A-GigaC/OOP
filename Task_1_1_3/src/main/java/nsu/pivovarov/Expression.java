package nsu.pivovarov;

import java.util.Stack;

/**
 * Abstract class for describing expressions.
 */
public abstract class Expression {
    /**
     * Take values of variables and returns integer value of expression.
     */
    public abstract int eval(String variablesWithValues);

    /**
     * Prints expression's string representation.
     */
    public void print() {
        System.out.println(stringRepresentation());
    }

    /**
     * Calculates the derivative.
     */
    public abstract Expression derivative(String variableName);

    /**
     * Gives string representation of and expression.
     */
    public abstract String stringRepresentation();
}
