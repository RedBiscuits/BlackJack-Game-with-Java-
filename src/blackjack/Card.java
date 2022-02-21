package blackjack;

public class Card {
    //encapsulation
    final private int suit;
    final private int value;
    final private int rank;


    public Card(int suit, int value, int rank) {
        this.suit = suit;
        this.value = value;
        this.rank = rank;

    }public Card(Card card) {
        this.suit = card.suit;
        this.value = card.value;
        this.rank = card.rank;

    }
    public Card(){
        this.suit = 0;
        this.value = 0;
        this.rank = 0;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }


    //to check whether the Cards are declared correctly or not
    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                ", rank=" + rank +
                '}';
    }
}
