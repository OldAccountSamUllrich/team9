package models;

/**
 * Created by Bubba on 11/8/2017.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    public java.util.List<Card> deck= new ArrayList<>();
    public int size;
    public Deck(){

    }

    public void shuffle(){
        // shuffles the deck so that it is random
        long seed= System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    public void dealFour(java.util.List<java.util.List<Card>> rows)
    {
        if(deck.size()>= 4) {
            for (int i = 0; i < 4; i++) {
                rows.get(i).add(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
        }
        else if(deck.size() == 2){
            for (int i = 0; i < 2; i++) {
                rows.get(i).add(deck.get(deck.size() - 1));
                deck.remove(deck.size() - 1);
            }
        }
    }
}
