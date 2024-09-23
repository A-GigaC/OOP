/**
 * It's driver of our application
 * There will be the function that starts game
 * This function calls from Main.main once.
 */

import java.io.IOException;
/* BlackJack class - there is the main logic of the game */
public class Blackjack {
    private Deck deck;
    private final Player player;
    private final Dealer dealer;
    private int roundNumber;
    private int playerWins;
    private int dealerWins;

    /** Blackjack constructor. */
    public Blackjack() {
        deck = new Deck();
        player = new Player(deck);
        dealer = new Dealer(deck);
        roundNumber = 0;
        playerWins = 0;
        dealerWins = 0;

        // Welcome message
        System.out.println("Wellcome to blackjack");
    }

    /** The main game logcic. */
    public void playGame() throws Exception {
        while (true) {
            try {
                round();
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void round() throws IOException {
        if (roundNumber != 0) {
            deck = new Deck();
            player.resetGame(deck);
            dealer.resetGame(deck);
        }
        roundNumber++;

        // Start round message
        System.out.println("Round " + roundNumber);

        // Dealer dealt the cards
        player.getCard();
        player.getCard();

        dealer.getCard();
        dealer.getClosedCard();

        System.out.println("Dealer dealt the cards:");
        player.getStatus();
        dealer.getStatus();

        // Player's turn
        System.out.println("Your turn\n-------");

        if (player.getScore() == 21) {
            playerWins();
            return;
        } else if (player.getScore() > 21) {
            dealerWins();
            return;
        }

        System.out.println("Input '1' to peek the card and '0' to stop your turn; 'q' for exit");

        int input = 1;
        Card gettedCard;

        // User's input processing
        while (input != '0') {
            try {
                // read user input
                input = System.in.read();
            } catch (IOException e) {
                throw e;
            }

            if (input == '1') {
                // Output new status
                gettedCard = player.getCard();
                System.out.println(
                        "You have got "
                                + gettedCard.getRank()
                                + " "
                                + gettedCard.getSuit()
                                + " ("
                                + gettedCard.getValue()
                                + ")"
                );

                player.getStatus();
                dealer.getStatus();

                // Check win/loosing/continuation
                if (player.getScore() == 21) {
                    playerWins();
                    return;
                } else if (player.getScore() > 21) {
                    dealerWins();
                    return;
                }
            } else if (input == '0') {
                break;
            } else if (input == 'q') {
                return;
            }
        }

        // Dealer's turn
        System.out.println("Dealer's turn\n-------");

        Card closedCard = dealer.openCard();

        System.out.println(
                "The dealer opened a closed card "
                        + closedCard.getRank()
                        + " "
                        + closedCard.getSuit()
                        + " ("
                        + closedCard.getValue()
                        + ")"
        );
        player.getStatus();
        dealer.getStatus();

        // Check dealer's score
        if (checkRoundEnd() > 0) {
            return;
        }

        // Dealer peek cards
        while (dealer.getScore() < 17) {
            gettedCard = dealer.getCard();

            System.out.println(
                    "Dealer has got "
                            + gettedCard.getRank()
                            + " "
                            + gettedCard.getSuit()
                            + " ("
                            + gettedCard.getValue()
                            + ")"
            );

            // Check dealer's score
            if (checkRoundEnd() > 0) {
                return;
            }
        }
    }

    /** Say that player has won and increments player's wins counter. */
    private void playerWins() {
        playerWins++;
        System.out.println("\nYou won! " + playerWins + ":" + dealerWins + "\n");
    }

    /** Say that dealer has won and increments dealer's wins counter. */
    private void dealerWins() {
        dealerWins++;
        System.out.println("\nDealer won :{) " + playerWins + ":" + dealerWins + "\n");
    }

    /** Say that this round jas ended with draw. */
    private void draw() {
        System.out.println("\nDraw! " + playerWins + ":" + dealerWins + "\n");
    }

    /** Check that round ended. */
    private int checkRoundEnd() {
        if (dealer.getScore() == 21) {
            dealerWins();
            return 1;
        } else if (dealer.getScore() > 21) {
            playerWins();
            return 2;
        } else if (dealer.getScore() >= 17) {
            if (player.getScore() > dealer.getScore()) {
                playerWins();
                return 2;
            } else if (player.getScore() < dealer.getScore()) {
                dealerWins();
                return 1;
            } else {
                draw();
                return 3;
            }
        }
        return 0;
    }
}