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

    /**
     * Blackjack constructor.
     */
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

    /**
     * Round loop.
     */
    public void playGame() throws Exception {
        int roundStatus;
        while (true) {
            try {
                roundStatus = round();
                if (roundStatus != 0) {
                    break;
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /**
     * The main game logic.
     */
    // TODO: декомпозировать round
    private int round() throws Exception {
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
        int playerTurnStatus;
        try {
            playerTurnStatus = playersTurn();
            if (playerTurnStatus == 1) {
                return 0;
            } else if (playerTurnStatus == 2) {
                return 2;
            }
        } catch (Exception e) {
            throw e;
        }

        // Dealer's turn
        dealersTurn();

        return 0;
    }

    /**
     * PLayer's turn logic.
     */
    int playersTurn() throws Exception {
        // Player's turn
        System.out.println("Your turn\n-------");

        if (player.getScore() == 21) {
            playerWins();
            return 1;
        } else if (player.getScore() > 21) {
            dealerWins();
            return 1;
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
                playersGettedCard(player.getCard());
                player.getStatus();
                dealer.getStatus();

                // Check win/loosing/continuation
                if (player.getScore() == 21) {
                    playerWins();
                    return 0;
                } else if (player.getScore() > 21) {
                    dealerWins();
                    return 1;
                }
            } else if (input == '0') {
                break;
            } else if (input == 'q') {
                return 2;
            }
        }
        return 0;
    }

    /** Dealer's turn logic. */
    private void dealersTurn() {
        System.out.println("Dealer's turn\n-------");
        dealersGettedCard(dealer.openCard(), true);
        player.getStatus();
        dealer.getStatus();

        // Check dealer's score
        if (checkRoundEnd() > 0) {
            return ;
        }

        // Dealer peek cards
        while (dealer.getScore() < 17) {
            dealersGettedCard(dealer.getCard(), false);
            // Check dealer's score
            if (checkRoundEnd() > 0) {
                return ;
            }
        }

        return ;
    }
    /**
     * Say that player has won and increments player's wins counter.
     */
    private void playerWins() {
        playerWins++;
        System.out.println("\nYou won! " + playerWins + ":" + dealerWins + "\n");
    }

    /**
     * Say that dealer has won and increments dealer's wins counter.
     */
    private void dealerWins() {
        dealerWins++;
        System.out.println("\nDealer won :{) " + playerWins + ":" + dealerWins + "\n");
    }

    /**
     * Say that this round jas ended with draw.
     */
    private void draw() {
        System.out.println("\nDraw! " + playerWins + ":" + dealerWins + "\n");
    }

    /**
     * Dealers's getted card.
     */
    private void dealersGettedCard(Card gettedCard, boolean wasClosed) {
        System.out.println(
                wasClosed ? "The dealer opened a closed card " : "Dealer has got "
                        + gettedCard.getRank()
                        + " "
                        + gettedCard.getSuit()
                        + " ("
                        + gettedCard.getValue()
                        + ")"
        );
    }

    /**
     * Player's getted card.
     */
    private void playersGettedCard(Card gettedCard) {
        System.out.println(
                "You have got the card "
                        + gettedCard.getRank()
                        + " "
                        + gettedCard.getSuit()
                        + " ("
                        + gettedCard.getValue()
                        + ")"
        );
    }

    /**
     * Check that round ended.
     */
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