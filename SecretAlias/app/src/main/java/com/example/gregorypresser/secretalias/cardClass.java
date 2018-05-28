package com.example.gregorypresser.secretalias;
class Card {
    private String alias; //The alias listed on the card
    private boolean revealed; //The card was revealed by the guesser or not
    private String type = "passenger"; //The card must be: purple, green, passenger, spy

    public Card(String setAlias, String setType) { //initializes a new Card with the given alias, unrevealed status, and type
        alias = setAlias;
        revealed = false;
        type = setType;
    }
    //These functions return the values to the app
    public String getAlias () {
        return alias;
    }
    public boolean getRevealed () {
        return revealed;
    }
    public String getType() {
        return type;
    }
    public void cardFlip () { //if a card is tapped, it becomes revelaed to the guessers
        if(!revealed)
            revealed = !revealed;
    }
}