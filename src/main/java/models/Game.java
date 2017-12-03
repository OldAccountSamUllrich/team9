package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game { //hey there buddy

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

    

    public void remove(int rowNumber) {
       if(Game.ableToRemove(rows, rowNumber)){
           rows.get(rowNumber).remove(rows.get(rowNumber).size()-1);
       }
    }

    public static boolean ableToRemove(java.util.List<java.util.List<Card>> rows, int row){
        if(rows.get(row).size()>0) {
            java.util.List<Card> removeRow = rows.get(row);
            for (int i = 0; i < 4; i++) {
                java.util.List<Card> testRow = rows.get(i);
                if (removeRow.get(removeRow.size() - 1).suit == testRow.get(testRow.size() - 1).suit && removeRow.get(removeRow.size() - 1).value < testRow.get(testRow.size() - 1).value) {
                    return true;
                }
            }
        }
        return false;
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
        if(columnHasCards(rowTo))
        {
            //Check to make sure the move is valid
            System.out.println("This column has cards. This is an invaild move");
        }
        else if(rowFrom < 0 || rowFrom > 3 )
        {
            //check to make sure the columnFrom is a valid column number
            System.out.println("In the 'From' field, you have entered a incorrect row number\nRow numbers range from the interger values 1 - 4");
        }
        else if(rowTo < 0 || rowTo > 3 )
        {
            //check to make sure the columnTo is a valid column number
            System.out.println("In the 'To' field, you have entered a incorrect row number\nRow numbers range from the interger values 1 - 4");
        }
        else if(getTopCard(rowFrom).getValue() != 14)
        {
            //Check to make sure the Value is an ace
            System.out.println("You can only move cards which are an ace");
        }
        else {
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
