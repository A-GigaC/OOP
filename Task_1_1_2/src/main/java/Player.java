import java.util.ArrayList;

public class Player extends Participant {

    public Player(Deck deck) {
        this.cards = new ArrayList<>();
        this.score = 0;
        this.deck = deck;
    }

    // Get user status as string
    public void getStatus() {
        String status = "\tYour cards: [";

        int cardIndex = 1;
        for (Card card : cards) {
            status = status.concat(
                    card.getRank().name() +
                            " " +
                            card.getSuit().name() +
                            " (" +
                            card.getValue()
            );

            status = status.concat(cardIndex < cards.size() ? "), " : ") ");
        }

        System.out.println(status.concat("] => " + score));
    }
}
