package com.example.gregorypresser.secretalias;
import java.lang.Math;
import java.util.ArrayList;

class Deck {
    private ArrayList<String> allAliases = new ArrayList<String>(); //all the aliases we have
    private Card currentDeck[][] = new Card[5][5]; //this specific game
//amount of types per deck
    private int purples = 7;
    private int greens = 7;
    private int spy = 1;
    private int passengers = 9;

    public Deck(boolean purpleIsFirst) {
        /*
        for(int a = 0;a<=100; a++)
        {
            allAliases.add("hi" + a);
        }
        */
        if (purpleIsFirst) //whoever goes first needs to guess one more card
            purples++;
        else
            greens++;
    int cR = 0; //Current Row
    int cC = 0; //Current Column
    int todaysAliasIndex = 0; // random index of alias we are using
    int todaysAliasesRemaining = allAliases.size(); 
    for (int r = 0; r < 5; r++) {
      for (int c = 0; c< 5; c++) {
                todaysAliasIndex = (int)(Math.random() * todaysAliasesRemaining);
                currentDeck[r][c] = new Card(allAliases.get(todaysAliasIndex), "passenger"); //putting in an alias and a type
                todaysAliasesRemaining--;
                allAliases.remove(todaysAliasIndex); //removing that alias from this game's pile
      }
    }
    for (int i = 0; i < 16; i++) { // purples + greens + spy = 16
        cR = (int)(Math.random() * 5); 
        cC = (int)(Math.random() * 5);
        todaysAliasIndex = (int)(Math.random() * todaysAliasesRemaining);
        if (currentDeck[cR][cC]!= null && !(currentDeck[cR][cC].getType().equals("passenger"))) //if this random spot is occupied, we pick a new one
            i--;
        else {
                currentDeck[cR][cC] = new Card(allAliases.get(todaysAliasIndex), typeSetter(i)); //putting in an alias and a type
                todaysAliasesRemaining--;
                allAliases.remove(todaysAliasIndex); //removing that alias from this game's pile
                
            }
        }
    }
    
    public Card[][] getDeck()
    {
        return currentDeck; 
    }   
    public String typeSetter (int i) {
        if (i == 0) //first one gives spy
            return "spy";
        else if (i < purples + 1) // 1 until 8 or 9 gives purple
            return "purple";
        return "green"; //the rest, which is 8 or 9 until 16 will be green. after it is 16 this method wont be called anymore anyway
    }
    
    /*
    public static void main(String args[])
    {
        Deck deck = new Deck(true);
        
        for(int i = 0; i<deck.getDeck().length; i++)
        {
            for(int j =0; j<deck.getDeck()[i].length; j++)
            {
                System.out.println(deck.getDeck()[i][j].getType());
            }
        }
    }
    */
}
