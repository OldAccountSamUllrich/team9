package models;

        import org.junit.Test;

        import static org.junit.Assert.*;

public class testSpanishDeck{

    @Test
    public void testGetSpanishDeck(){

        Deck deck2 = new SpanishDeck();
        deck2.shuffle();
        assertEquals(deck2.size(),50);
    }
}