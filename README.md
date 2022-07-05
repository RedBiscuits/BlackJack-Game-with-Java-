# BlackJack Java game

 This project is a simplified version of the popular card game Blackjack (aka : '21') without bets.

## How to play

* At the beginning of the game, 3 players and a dealer are dealt 2 cards each.  <br>
* all players' cards are visible but only 1 of the dealer’s cards is not flipped. <br>
* The aim of the game is to have the sum of the card values (score) in a player's hand be 21 (BLACKJACK), or as close to 21 as possible.  <br>
* You lose if you go over 21. The players go first in turns and have two choices: Hit or Stand.
 
 <br>
 
HIT means the player wants to pick another card. You make this move to increase your score.

<br>

STAND means that the player is done picking new cards (i.e. Hitting) and their turn ends.  You do this move when you are comfortable with your score
(e.g. score=19 is very close to 21, picking another card could make you lose the game by going over 21
(Player BUSTED).

<br>

* When the player’s turn ends, the next players starts to play in turns.
*  If the maximum score of all players is
less than the value of the two cards of the dealer’s then the dealer will win the game and doesn’t need to
hit more cards.
* Other than that, then the dealer starts hitting until he either scores 21, scores a score bigger
than all of the other players or go over 21 (Dealer BUSTED). 

<br>

* Finally, if more than one player have the same high score then it’s a tie situation (PUSH) 
* but if only a single player had the maximum score then that player WINs the game

<br>

The strategy is to increase your score by hitting to get close to 21 (but not more), while also taking into
consideration what the dealer’s score could be.

## Gameplay
- Getting each player's name <br> <br> ![Names input](https://github.com/Mohamed-Samy26/BlackJack-Java-game/blob/main/screenshots/names.jpg?raw=true "Names input") <br> <br> 
- Game begins <br> <br> ![Start](https://github.com/Mohamed-Samy26/BlackJack-Java-game/blob/main/screenshots/2.jpg "Start") <br> <br> 
- Drawing a new card <br> <br> ![Card draw](https://github.com/Mohamed-Samy26/BlackJack-Java-game/blob/main/screenshots/3.jpg "Card draw") <br> <br> 
- Game over <br> <br> ![GameOver](https://github.com/Mohamed-Samy26/BlackJack-Java-game/blob/main/screenshots/4.jpg "GameOver")
