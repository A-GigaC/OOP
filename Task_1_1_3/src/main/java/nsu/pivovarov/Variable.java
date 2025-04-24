package nsu.pivovarov;

import java.util.Arrays;

/**
 * Variable class extends AtomicExpression.
 */
public class Variable extends AtomicExpression {
    String name;

    /**
     * Constructor gets string name of variable.
     */
    public Variable(String name) {
        this.name = name;
    }

    /**
     * Implements eval.
     */
    public int eval(String variablesWithValues) {
        String[] splitVariablesList = variablesWithValues.split(" ");
        if (!Arrays.asList(splitVariablesList).contains(name)) {
            throw new RuntimeException("Variable '" + name + "' not found");
        }
        return Integer.parseInt(
                splitVariablesList[Arrays.asList(splitVariablesList).indexOf(name) + 2]);
    }

    /**
     * Implements derivative.
     */
    public Expression derivative(String variableName) {
        if (variableName.equals(name)) {
            return new Number(1);
        }
        return new Number(0);
    }

    /**
     * Implements string representation.
     */
    public String stringRepresentation() {
        return name;
    }
}
