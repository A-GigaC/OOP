/*
 * Card class
 */

/**
 * Card class.
 * */
public class Card {
    private final Suit suit;
    private final Rank rank;

    /** Constructor. */
    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /** Getter for suit. */
    public Suit getSuit() {
        return suit;
    }

    /** Getter for rank. */
    public Rank getRank() {
        return rank;
    }

    /** Getter for value. */
    public int getValue() {
        switch (rank) {
            case Two:
                return 2;
            case Three:
                return 3;
            case Four:
                return 4;
            case Five:
                return 5;
            case Six:
                return 6;
            case Seven:
                return 7;
            case Eight:
                return 8;
            case Nine:
                return 9;
            case Ten:
                return 10;
            case Jack:
                return 10;
            case Queen:
                return 10;
            case King:
                return 10;
            case Ace:
                return 11;
            default:
                return 0;
        }
    }
}
