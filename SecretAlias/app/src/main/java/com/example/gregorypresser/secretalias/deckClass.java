package com.example.gregorypresser.secretalias;
import java.lang.Math;

class Deck {
    private String allAliases [] = new String[100]; //all the aliases we have
    private Card currentDeck[][] = new Card [5][5]; //this specific game
    //amount of types per deck
    private int purples = 7;
    private int greens = 7;
    private int spy = 1;
    private int passengers = 9;

    public Deck (boolean purpleIsFirst){
    if(purpleIsFirst) //whoever goes first needs to guess one more card
        purples++;
    else
        greens++;
    int cR = 0; //Current Row
    int cC = 0; //Current Column
    int todaysAliasIndex = 0; 
    for(int i = 0; i<16; i++) {
        cR = (int) (Math.random() * 5);
        cC = (int) (Math.random() * 5);
        if(currentDeck[cR][cC].getType().equals("passenger"))
            i--;
        else
        {
           if(i == 0)
               currentDeck[cR][cC] = new Card(todaysAlias, "spy" );
        }
    }
}
}