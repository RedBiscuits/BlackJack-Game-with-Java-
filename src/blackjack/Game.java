package blackjack;

import java.util.Random;

public class Game {
    private final byte NO_OF_PLAYERS = 4;
    public Player []player = new Player[NO_OF_PLAYERS];
    public Card []cards = new Card[52];
    public static byte highScore;
    Random rand ;

    //constructor to set all cards
    public  Game(){
        //allocating memory for each player and declaring their cards
        for (int i = 0 ; i < NO_OF_PLAYERS ; i++)
            player[i] = new Player();
        final int NO_CARDS=52;
        final int SUIT_CARDS = 13;
        int suit;
        int value;
        int rank;
        //Deck declaration
        for (int i = 0 ; i <NO_CARDS;i++){
            suit = i / SUIT_CARDS;//it will ignore all fractions so suit will be 0,1,2,3
            value = i % SUIT_CARDS;//value will always be greater than i with 1
            ++value;
            rank = i % SUIT_CARDS;

            if(value>= 10 )
                value = 10;

            cards[i] = new Card(suit,value,rank);
        }

        //You can use this to check the deck initialization
        /*       for (int i = 0 ;i < 52 ; i++)
            System.out.println(cards[i]);
    */
    }
    //Random card generation
    public Card PickCard(int size){
        //random integer generator
        rand = new Random();
        int random = rand.nextInt(size);
        //loop to assure that each picked card is not null
        while (cards[random]==null)
            random = rand.nextInt(size);
        //returning card and nulling the deck card
        Card randomCard = new Card(cards[random]);
        cards[random] = null;
        return randomCard;
    }

    public void setInfo(int index,String name){
        //name
        player[index].setName(name);
        //cards
        player[index].cards[0] = PickCard(52);
        player[index].cards[1] = PickCard(52);
        //score
        player[index].calcScore();

    }

    public byte setHighScore(){
        //array to hold all scores
        byte []scores = new byte[NO_OF_PLAYERS];
        //temp variable to determine the highest score
        byte max = 0;

        for (int i = NO_OF_PLAYERS-1 ; i >=0; i--)
        //loop to get  highest (linear search -N is too small for more sophisticated Algorithms-)
        {
            scores[i] = (byte) (player[i].getScore() % (byte)22);
            if(i == 3)
                max = scores[3];
            else
            if( scores[i] > max && scores[i] <= 21)
                max = scores[i];
            else
                continue;
        }

        return max;
    }
}
