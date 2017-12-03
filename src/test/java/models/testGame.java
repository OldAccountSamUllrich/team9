package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {
    @Test
    public void testGameMove(){
        Game g = new Game();
        g.deck.dealFour(g.rows);
        g.move(0,1);
        assertEquals(1,g.rows.get(0).size()); //Test to make sure you can't move the card if the spot is full. 
    }

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        assertEquals(52,g.deck.deck.size());
    }


    /*@Test     //Need to come back to this eventually
    public void testGameStart(){
        Game g = new Game();
        g.deck.shuffle();
        g.deck.dealFour(g.rows);
        assertEquals(1,g.rows.get(0).cards.size());
        assertEquals(1,g.rows.get(1).cards.size());
        assertEquals(1,g.rows.get(2).cards.size());
        assertEquals(1,g.rows.get(3).cards.size());
    }*/

    /*@Test
    public void testCustomDeal(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs",g.columns.get(0).cards.get(0).toString());
        assertEquals("3Clubs",g.columns.get(1).cards.get(0).toString());
        assertEquals("4Clubs",g.columns.get(2).cards.get(0).toString());
        assertEquals("5Clubs",g.columns.get(3).cards.get(0).toString());
    }*/

    @Test //Andrew Unit Test
    public void testRemoveFunction(){
        Game g = new Game();
        //g.deck.dealfour(g.rows);
        //create cards for rows
        Card c1 = new Card(4,Suit.Clubs);
        g.rows.get(0).add(c1);
        Card c2 = new Card(2,Suit.Clubs);
        g.rows.get(1).add(c2);
        Card c3 = new Card(2,Suit.Hearts);
        g.rows.get(2).add(c3);
        Card c4 = new Card(5,Suit.Hearts);
        g.rows.get(3).add(c4);

        g.remove(1);
        assertEquals(0,g.rows.get(1).cards.size());
    }

    //can add test to check if column has cards returns true or false

}
