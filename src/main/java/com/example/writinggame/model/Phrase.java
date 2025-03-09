package com.example.writinggame.model;
;

public class Phrase {
    private String phrase;
    private String easyPhrases[]={};
    private String hardPhrases[]={};
    private String mediumPhrases[]={};

    public Phrase(String difficulty) {

        if (difficulty == "easy"){
            phrase = chooseEasyPhrases();
        }

        else if (difficulty == "hard"){
            phrase = chooseHardPhrases();
        }

        else if (difficulty == "medium"){
            phrase = chooseMediumPhrases();
        }
    }

    public String getPhrase() {
        return phrase;
    }

    public String chooseEasyPhrases() {
        int randomNumber = (int) (Math.random() * easyPhrases.length);
        phrase = easyPhrases[randomNumber];
        return phrase;
    }

    public String chooseHardPhrases() {
        int randomNumber = (int) (Math.random() * hardPhrases.length);
        phrase = hardPhrases[randomNumber];
        return phrase;
    }

    public String chooseMediumPhrases() {
        int randomNumber = (int) (Math.random() * mediumPhrases.length);
        phrase = mediumPhrases[randomNumber];
        return phrase;
    }

}
