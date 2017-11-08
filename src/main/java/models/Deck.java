package models;

/**
 * Created by Bubba on 11/8/2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public java.util.List<Card> deck= new ArrayList<>();

    public Deck(){
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
        this.shuffle();
    }

    public void shuffle(){
        // shuffles the deck so that it is random
        long seed= System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealFour(java.util.List<java.util.List<Card>> rows)
    {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        for (int i = 0; i < 4; i++)
        {
            rows.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }
}
