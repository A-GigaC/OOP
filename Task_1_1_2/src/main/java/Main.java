/** Main class of Blackjack game. */
public class Main {
    /** Program Entrypoint. */
    public static void main(String[] args) throws Exception {
        Blackjack blackjack = new Blackjack();
        try {
            blackjack.playGame();
        } catch (Exception e) {
            throw e;
        }
    }
}
