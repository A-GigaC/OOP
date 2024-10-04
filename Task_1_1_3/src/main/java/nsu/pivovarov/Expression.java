package nsu.pivovarov;

import java.util.Stack;

/**
 * Abstract class for describing expressions.
 */
public abstract class Expression {
    protected Stack operandStack = new Stack();
    /**
     * Take values of variables and returns integer value of expression.
     */
    public abstract int eval();

    /**
     * Prints expression.
     */
    public void print() {
        if (operandStack.empty()) {
            System.out.println("Nothing to print");
        } else if (operandStack.size() == 1) {
            System.out.println(operandStack.pop());
        } else {
            Stack reversedOperandStack;
            // Reverse stack
            while (!operandStack.empty()) {

            }
        }
    }

}
