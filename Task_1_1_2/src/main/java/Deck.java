/*
* The class name is Deck
* but inside it works on the stack
* 😂😂😂😂😂😂😂😂😂
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/** Deck class as a wrapper on stack. */
public class Deck {
    // The basement of Deck-class
    private Stack<Card> deck;

    /** 1. Initialize deck
     * 2. Use freshDeck().
    */
    public Deck() {
        // Init deck (stack object)
        this.deck = new Stack<>();
        freshDeck();
    }

    /** Pop a card from the top of the deck. */
    public Card peek() {
        if (deck.isEmpty()) {
            freshDeck();
        }
        return deck.pop();
    }

    /**
     * a. shuffle cards
     * b. Fill the deck.
     * */
    private void freshDeck() {
        // Init cardsList
        ArrayList<Card> cardsList = new ArrayList<Card>();

        // Generate cards
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardsList.add(new Card(suit, rank));
            }
        }

        // Shuffle cardsList
        Collections.shuffle(cardsList);

        // Fill the deck
        for (Card card : cardsList) {
            deck.push(card);
        }
    }
}
