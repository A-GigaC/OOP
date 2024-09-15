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
}
