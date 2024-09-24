import java.util.ArrayList;

/**
 * Dealer class - describes the dealer's behaviour.
 * */
public class Dealer extends Participant {
    private Card closedCard;

    /**
     * Constructor.
     * */
    public Dealer(Deck deck) {
        this.deck = deck;
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    /**
     * *Dealer peeks card from deck and keep it closed.
     * */
    public void getClosedCard() {
        closedCard = deck.peek();
        score += closedCard.getValue();
    }

    /**
     * Dealer opens closed card.
     * */
    public Card openCard() {
        Card tmpForClosedCard = closedCard;
        cards.add(closedCard);
        closedCard = null;
        return tmpForClosedCard;
    }

    /**
     * Prints cards and total value of Dealer.
     * */
    @Override
    public void getStatus() {
        StringBuilder statusBuilder = new StringBuilder("\tDealer cards: [");
        if (closedCard != null) {
            statusBuilder.append(
                    cards.get(0).getRank().name()
                            + " "
                            + cards.get(0).getSuit().name()
                            + " ("
                            + cards.get(0).getValue()
                            + "), <closed card>]"
            );
        } else {
            int cardIndex = 1;
            for (Card card : cards) {
                statusBuilder.append(
                        card.getRank().name()
                                + " "
                                + card.getSuit().name()
                                + " ("
                                + card.getValue()
                );

                statusBuilder.append(cardIndex < cards.size() ? "), " : ")");
            }

            statusBuilder.append("] => " + score);
        }

        System.out.println(statusBuilder.toString());
    }
}