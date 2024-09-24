import java.util.ArrayList;

/** This class inherited by Player and Dealer. */
public abstract class Participant {
    protected ArrayList<Card> cards;
    protected int score;
    protected Deck deck;

    /** Get score of participant. */
    public int getScore() {
        return score;
    }

    /** Pop card from top of the deck. */
    public Card getCard() {
        Card card = deck.peek();

        cards.add(card);
        score += card.getValue();

        return card;
    }

    /**
     * 1. Participant gets new deck
     * 2. Clear it's hand.
     */
    public void resetGame(Deck deck) {
        this.deck = deck;
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    /** Get paricipant status as string. */
    abstract public void getStatus();
}
