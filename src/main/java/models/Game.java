package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public java.util.List<java.util.List<Card>> rows = new ArrayList<>(4);

    public Deck deck;

    public Game(){
        // initialize a new game such that each column can store cards
        rows.add(new ArrayList<Card>());
        rows.add(new ArrayList<Card>());
        rows.add(new ArrayList<Card>());
        rows.add(new ArrayList<Card>());

        deck = new Deck();
    }


   /* public void shuffle() {
        // shuffles the deck so that it is random
        long seed= System.nanoTime();
        Collections.shuffle(deck, new Random(seed));


    }*/

   /* public void dealFour()
    {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        for (int i = 0; i < 4; i++)
        {
            rows.get(i).add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
    }*/

    public void remove(int rowNumber) {
        if(columnHasCards(rowNumber)) {
            Card c = getTopCard(rowNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != rowNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.rows.get(rowNumber).remove(this.rows.get(rowNumber).size() - 1);
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
            removeCardFromCol(rowFrom);
        }
    }
        //Card cardToMove = getTopCard(rowFrom);
        //this.removeCardFromCol(rowFrom);
       // this.addCardToCol(rowTo,cardToMove);
    //}

    private void addCardToCol(int rowTo, Card rowToMove) {
        rows.get(rowTo).add(rowToMove);
    }

    private void removeCardFromCol(int rowFrom) {
        this.rows.get(rowFrom).remove(this.rows.get(rowFrom).size()-1);
    }
}
