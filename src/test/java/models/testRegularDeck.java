package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testRegularDeck{

    @Test
    public void testGetRegularDeck(){

        Deck deck2 = new RegularDeck();
        deck2.shuffle();
        assertEquals(deck2.size(),52);
    }
}