import java.util.ArrayList;

public class Dealer extends Participant {
    private Card closedCard;

    public Dealer(Deck deck) {
        this.deck = deck;
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    public void getClosedCard() {
        closedCard = deck.peek();
        score += closedCard.getValue();
    }

    public Card openCard() {
        Card tmpForClosedCard = closedCard;
        cards.add(closedCard);
        closedCard = null;
        return tmpForClosedCard;
    }

    public void getStatus() {
        String status = "\tDealer cards: [";
        if (closedCard != null) {
            status = status.concat(
                    cards.getFirst().getRank().name() +
                            " " +
                            cards.getFirst().getSuit().name() +
                            " (" +
                            cards.getFirst().getValue() +
                            "), <closed card>]"
            );
        } else {
            int cardIndex = 1;
            for (Card card : cards) {
                status = status.concat(
                        card.getRank().name() +
                                " " +
                                card.getSuit().name() +
                                " (" +
                                card.getValue()
                );

                status = status.concat(cardIndex < cards.size() ? "), " : ")");
            }

            status += "] => " + score;
        }

        System.out.println(status);
    }
}
