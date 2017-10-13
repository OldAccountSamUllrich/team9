package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards


    }

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
        Collections.shuffle(deck);


    }

    public void dealFour() 
    {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        for (int i = 0; i < 4; i++)
        {
            int cardsInDeck = deck.size();
            Card topCard = deck.get(deck.size() - 1);
            cols.get(i).add(topCard);
            deck.subList(cardsInDeck, cardsInDeck - 1);
            //deck.remove(topCard);
            //deck.trimToSize();
        }
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if(!columnHasCards(columnTo))
            {
            System.out.println("This column has cards. This is an invaild move");
        }
        else
        {
            addCardToCol(columnTo, getTopCard(columnFrom));
            // removing the top card from the previous column
            remove(columnFrom);
        }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
