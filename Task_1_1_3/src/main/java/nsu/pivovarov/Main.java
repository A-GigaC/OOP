package nsu.pivovarov;

/**
 * Main class.
 */
public class Main {
    /**
     * Program's entrypoint.
     */
    public static void main(String[] args) {
        Expression expression = new Mul(new Number(5), new Variable("x"));
        expression.derivative("x").print();
        System.out.println(expression.eval("x = 10000"));
    }
}