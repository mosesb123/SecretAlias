package com.example.gregorypresser.secretalias;
import java.lang.Math;
import java.util.ArrayList;

class Deck {
    private ArrayList allAliases = new ArrayList; //all the aliases we have
    private Card currentDeck[][] = new Card[5][5]; //this specific game
//amount of types per deck
    private int purples = 7;
    private int greens = 7;
    private int spy = 1;
    private int passengers = 9;

    public Deck(boolean purpleIsFirst) {
        if (purpleIsFirst) //whoever goes first needs to guess one more card
            purples++;
        else
            greens++;
    int cR = 0; //Current Row
    int cC = 0; //Current Column
    int todaysAliasIndex = 0; // random index of alias we are using
    int todaysAliasesRemaining = allAliases.size; 
    ArrayList todaysAliases  = allAliases.clone(); //cloned list, because we will be removing some elements later
    for (int i = 0; i < 16; i++) { // purples + greens + spy = 16
        cR = (int)(Math.random() * 5); 
        cC = (int)(Math.random() * 5);
        todaysAliasIndex = (int)(Math.random() * todaysAliasesRemaining);
        if (!(currentDeck[cR][cC].getType().equals("passenger"))) //if this random spot is occupied, we pick a new one
            i--;
        else {
                currentDeck[cR][cC] = new Card(todaysAliases.get(todaysAliasIndex), typeSetter(i)); //putting in an alias and a type
                todaysAliasesRemaining--;
                todaysAliases.remove(todaysAliasIndex); //removing that alias from this game's pile
                
            }
        }
    }
    public Deck getDeck () {
        return currentDeck;
    }
    public String typeSetter (int i) {
        if (i == 0) //first one gives spy
            return "spy";
        else if (i < purples + 1) // 1 until 8 or 9 gives purple
            return "purple";
        return "green"; //the rest, which is 8 or 9 until 16 will be green. after it is 16 this method wont be called anymore anyway
    }
}