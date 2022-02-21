package blackjack;


import java.util.Scanner;

public class BlackJack {
    static Game game = new Game();
    static GUI gui = new GUI();
    final static byte NO_OF_PLAYERS = 4 ;
    public static void main(String[] args) {
        //Deck is auto generated at the game constructor

        //Setting all players names and giving em cards
        for (int i = 0; i < NO_OF_PLAYERS; i++) {

            if(i != 3) {
                Scanner scanner= new Scanner(System.in);

                //Picking cards and setting name
                System.out.println(">>>Please enter player name : ");
                String name = scanner.nextLine();
                game.setInfo(i,name);
                System.out.println("->"+game.player[i].getName() +"'s score is : "+game.player[i].getScore()+"\n");
            }

            else//Dealer
                game.setInfo(3,"Dealer");
        }
        //Calculating the highest score of all
        // Game.highScore = game.setHighScore();

        gui.runGUI(game.cards,game.player[0].cards,game.player[1].cards
                ,game.player[2].cards,game.player[3].cards);


        //Game loop
        for (int i = 0; i < NO_OF_PLAYERS; i++) {
            //Dealer's picks -no console manipulation-
            if (i == 3) {
                if(game.player[0].getScore() >21&&game.player[1].getScore() > 21
                        &&game.player[2].getScore()>21){
                    Game.highScore = game.player[3].getScore();
                    gui.updateDealerHand(game.player[3].cards[1],game.cards);//it is hopeless , no way to last card once without optimizing GUI
                    continue;
                }else
                    BlackJack.DealerPlay();
            }
            //Player's picks
            else{

                BlackJack.Play(i);
            }
            //Game.highScore = game.setHighScore();
        }
        for (int i = 0 ; i < NO_OF_PLAYERS ; i++) {
            System.out.print("\n >>>" + game.player[i].getName()+"'s score : " + game.player[i].getScore());
            if (game.player[i].isBlackjack())
                System.out.print(" BlackJack!!");
            else if(game.player[i].isLost())
                System.out.print(" Busted. ");
            //System.out.println("\n");
        }


        if(isTie()>1)
            System.out.println(">>PUSH!!");

        else {
            for (int i = 0; i < NO_OF_PLAYERS; i++)
            {
                Game.highScore = game.setHighScore();
                if(game.player[i].getScore() <= 21 )
                    if(game.player[i].getScore()==Game.highScore)
                        System.out.print("\n\n >> "+ game.player[i].getName()+" has won !!");
            }
        }
    }


    public static void DealerPlay() {
        //Card tempCard;

        boolean updated = false;
        while (game.player[3].getScore()<21 && (game.player[3].getScore() <= game.player[0].getScore()
                ||game.player[3].getScore()<=game.player[1].getScore()
                ||game.player[3].getScore()<=game.player[2].getScore()))
        //could not handle this normally, so I had to make some italian spaghetti xD .
        {
            //drawing a card
            Card tempCard = game.PickCard(52);

            //assigning card
            game.player[3].cards[game.player[3].NO_cards] = tempCard;
            game.player[3].NO_cards++;

            //updating GUI and Score
            gui.updateDealerHand(game.player[3].cards[game.player[3].NO_cards-1],game.cards);
            updated= true;
            game.player[3].setScore((byte) 0);
            game.player[3].calcScore();

            //Determining whether it is BlackJack or Busted
            if(game.player[3].getScore()==21)
                game.player[3].setBlackjack(true);
            else if(game.player[3].getScore()>21)
                game.player[3].setLost(true);
            //Updating game high score
            Game.highScore = game.setHighScore();
        }

        if(!updated)//updating GUI in case dealer did not pick
            gui.updateDealerHand(game.player[3].cards[game.player[3].NO_cards-1],game.cards);

    }

    public static int isTie() {
        int c=0;//integer to determine tie situation if exceeds 1
        if(game.player[0].getScore()==Game.highScore)
            c++;
        if(game.player[1].getScore()==Game.highScore)
            c++;
        if(game.player[2].getScore()==Game.highScore)
            c++;
        if(game.player[3].getScore()==Game.highScore)
            c++;
        return c;
    }

    public static void Play(int i){

        //Temp variables used for game play
        Scanner scanner = new Scanner(System.in);
        String command;
        boolean exit = false;
        Card tempCard;
        byte currentPlayerScore;

        while (!exit) {
            //getting command
            System.out.println("Player ("+ game.player[i].getName()+") type 'H' for Hit or 'S' for Stand : ");
            command = scanner.nextLine();
            command=command.toUpperCase();//to deal with h at comparison

            //manipulating command
            if(command.equals("H")){

                //random card
                tempCard = game.PickCard(52);
                game.player[i].setCards(tempCard,game.player[i].NO_cards);//assigning the card for the current player
                //calculating score by setting it to 0 and recalculate as it is cumulative
                game.player[i].setScore( (byte) 0);
                game.player[i].calcScore();

                //showing score and updating cards
                System.out.println("your score is : "+game.player[i].getScore());
                gui.updatePlayerHand(tempCard,i);
                currentPlayerScore = game.player[i].getScore();

                //calculating the new high score
                Game.highScore = game.setHighScore();

                if (currentPlayerScore >=21)//loop terminator checker
                {
                    if(currentPlayerScore > 21 )
                    {//is lost
                        game.player[i].setLost(true);
                        System.out.println("Busted");
                    }else if(currentPlayerScore == 21)//is Black Jack
                        game.player[i].setBlackjack(true);

                    exit = true;//true at both conditions
                }
            }
            else if(command.equals("S")){//when the player types 'S'
                exit = true;
            }
            else//when any unknown command is given it will loop over
                continue;
        }

    }

}


