import java.util.ArrayList;

/* *
 * Dealer class - describes the dealer's behaviour.
 * */
public class Dealer extends Participant {
    private Card closedCard;

    /* *
     * Constructor.
     * */
    public Dealer(Deck deck) {
        this.deck = deck;
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    /* *
     * *Dealer peeks card from deck and keep it closed.
     * */
    public void getClosedCard() {
        closedCard = deck.peek();
        score += closedCard.getValue();
    }

    /* *
     * Dealer opens closed card.
     * */
    public Card openCard() {
        Card tmpForClosedCard = closedCard;
        cards.add(closedCard);
        closedCard = null;
        return tmpForClosedCard;
    }

    /* *
     * Prints cards and total value of Dealer.
     * */
    public void getStatus() {
        String status = "\tDealer cards: [";
        if (closedCard != null) {
            status = status.concat(
                    cards.getFirst().getRank().name()
                            + " "
                            + cards.getFirst().getSuit().name()
                            + " ("
                            + cards.getFirst().getValue()
                            + "), <closed card>]"
            );
        } else {
            int cardIndex = 1;
            for (Card card : cards) {
                status = status.concat(
                        card.getRank().name()
                                + " "
                                + card.getSuit().name()
                                + " ("
                                + card.getValue()
                );

                status = status.concat(cardIndex < cards.size() ? "), " : ")");
            }

            status += "] => " + score;
        }

        System.out.println(status);
    }
}