import java.util.ArrayList;

/** Player class - describes the player's behaviour. */
public class Player extends Participant {

    /** Player constructor. */
    public Player(Deck deck) {
        this.cards = new ArrayList<>();
        this.score = 0;
        this.deck = deck;
    }

    /** Get player status as string. */
    // TODO: string-builder
    @Override
    public void getStatus() {
        StringBuilder statusBuilder = new StringBuilder("\tYour cards: [");
        int cardIndex = 1;
        for (Card card : cards) {
            statusBuilder.append(
                    card.getRank().name()
                            + " "
                            + card.getSuit().name()
                            + " ("
                            + card.getValue()
            );

            statusBuilder.append(cardIndex < cards.size() ? "), " : ") ");
        }

        System.out.println(statusBuilder.toString() + "] => " + score);
    }
}
