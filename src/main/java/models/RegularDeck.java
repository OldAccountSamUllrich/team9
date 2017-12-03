package models;

/**
 * Created by Bubba on 12/2/2017.
 */
public class RegularDeck extends Deck {
    public RegularDeck(){
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
        this.shuffle();
        this.size= 52;
    }
}
