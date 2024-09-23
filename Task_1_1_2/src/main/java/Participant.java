import java.util.ArrayList;

/* This class inherited by Player and Dealer */
public abstract class Participant {
    protected ArrayList<Card> cards;
    protected int score;
    protected Deck deck;

    public int getScore() {
        return score;
    }

    // Peek a card
    public Card getCard() {
        Card card = deck.peek();

        cards.add(card);
        score += card.getValue();

        return card;
    }

    // Start round with new deck and clear hand
    public void resetGame(Deck deck) {
        this.deck = deck;
        this.cards = new ArrayList<>();
        this.score = 0;
    }
}
