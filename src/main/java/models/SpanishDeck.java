package models;

/**
 * Created by Bubba on 12/2/2017.
 */
public class SpanishDeck extends Deck {
    public SpanishDeck(){
        buildSpanishDeck();
        shuffle();
    }

    public void buildSpanishDeck(){
        for(int i = 1; i < 13; i++) {
            deck.add(new Card(i, Suit.Bastos));
            deck.add(new Card(i, Suit.Oros));
            deck.add(new Card(i, Suit.Copas));
            deck.add(new Card(i, Suit.Espadas));
        }
        //after loop add the two jokers
        deck.add(new Card(13, Suit.Comodines));
        deck.add(new Card(13, Suit.Comodines));

        this.size = 50;
    }
}
