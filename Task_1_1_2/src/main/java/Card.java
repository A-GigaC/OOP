/*
 * Card class
 */

public class Card {
    // Class parameters
    private final Suit suit;
    private final Rank rank;

    // Constructor
    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getters
    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return switch (rank) {
            case Two -> 2;
            case Three -> 3;
            case Four -> 4;
            case Five -> 5;
            case Six -> 6;
            case Seven -> 7;
            case Eight -> 8;
            case Nine -> 9;
            case Ten -> 10;
            case Jack -> 10;
            case Queen -> 10;
            case King -> 10;
            case Ace -> 11;
            default -> 0;
        };
    }
}
