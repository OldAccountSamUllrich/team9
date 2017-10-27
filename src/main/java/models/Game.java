package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<Card> deck = new ArrayList<>();

    public java.util.List<java.util.List<Card>> rows = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        rows.add(new ArrayList<Card>());
        rows.add(new ArrayList<Card>());
        rows.add(new ArrayList<Card>());
        rows.add(new ArrayList<Card>());

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
            rows.get(i).add(topCard);
            deck.subList(cardsInDeck, cardsInDeck - 1);
            //deck.remove(topCard);
            //deck.trimToSize();
        }
    }

    public void remove(int rowNumber) {
        // remove the top card from the indicated column
        if(columnHasCards(rowNumber)) {
            for (int i = 0; i <= 4; i++) {
                if (i == rowNumber) {
                    //increase by one to not be the same column
                    i++;
                }
                //checks suit and value
                if (getTopCard(rowNumber).suit == getTopCard(i).suit) {
                    if (getTopCard(rowNumber).value < getTopCard(i).value) {
                        removeCardFromCol(rowNumber);
                        i = 4;
                    }
                }
            }
        }

    }

    private boolean columnHasCards(int rowNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(this.rows.get(rowNumber).size() > 0){
                return true;
        }
        return false;
    }

    private Card getTopCard(int rowNumber) {
        return this.rows.get(rowNumber).get(this.rows.get(rowNumber).size()-1);
    }


    public void move(int rowFrom, int rowTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        rowFrom--; //To turn the input from base 1- 4 to 0 - 3
        rowTo--;
        if(!columnHasCards(rowTo))
        {
            //Check to make sure the move is valid
            System.out.println("This column has cards. This is an invaild move");
        }
        if(rowFrom < 0 || rowFrom > 3 )
        {
            //check to make sure the columnFrom is a valid column number
            System.out.println("In the 'From' field, you have entered a incorrect row number\n Row numbers range from the interger values 1 - 4");
        }
        if(rowTo < 0 || rowTo > 3 )
        {
            //check to make sure the columnTo is a valid column number
            System.out.println("In the 'To' field, you have entered a incorrect row number\n Row numbers range from the interger values 1 - 4");
        }
        {
            addCardToCol(rowTo, getTopCard(rowFrom));
            // removing the top card from the previous column
            remove(rowFrom);
        }
    }

    private void addCardToCol(int rowTo, Card rowToMove) {
        rows.get(rowTo).add(rowToMove);
    }

    private void removeCardFromCol(int rowFrom) {
        this.rows.get(rowFrom).remove(this.rows.get(rowFrom).size()-1);
    }
}
