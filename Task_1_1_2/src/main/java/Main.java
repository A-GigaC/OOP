/* Program entrypoint */
public class Main {
    public static void main(String[] args) throws Exception {
        Blackjack blackjack = new Blackjack();
        try {
            blackjack.playGame();
        } catch (Exception e) {
            throw e;
        }
    }
}
