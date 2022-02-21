package blackjack;

public class Player {
    private final byte NO_OF_CARDS_PER_PLAYER = 11;
    private String name;
    private byte score;
    Card[] cards = new Card[NO_OF_CARDS_PER_PLAYER];//at worst scenario player will hit 4 aces
    // + 4 2 cards + 3 3 cards = 11 total cards
    private boolean isBlackjack;
    private boolean isLost;
    public int NO_cards = 2;

    public Player(){
        //card initialization with player's declaration
        for(int i = 0 ; i <NO_OF_CARDS_PER_PLAYER ;i++)
            this.cards[i] = new Card();
        //default values -will be entered later-
        this.name = null;
        this.score=0;
        this.isBlackjack=false;
        this.isLost=false;
    }

    public boolean isBlackjack() {
        return isBlackjack;
    }

    public boolean isLost() {
        return isLost;
    }

    public byte getScore() {
        return score;
    }

    public void calcScore(){
        for (int i = 0 ; i <NO_cards;i++){
            this.score += (byte) this.cards[i].getValue();
        }
    }

    public String getName() {
        return name;
    }

    public Card getCard(int index) {
        return cards[index];
    }

    public void setScore(byte score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCards(Card card,int index ) {
        this.cards[index] =  card;
        NO_cards++;
    }

    public void setBlackjack(boolean blackjack) {
        isBlackjack = blackjack;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }
}
