package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class dealFour {

    @Test
    public void testDeal()
    {
        Game g = new Game();
        Player p = new Player();
        g.buildDeck();
        p.dealFour(g.deck, g.cols);
        for(int i = 0; i < 4; i++)
        {
            assertEquals(1, g.cols.get(i).size());
        }

    }

}