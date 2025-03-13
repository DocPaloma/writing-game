package com.example.writinggame.model;
;

public class Phrase {
    private String phrase;


    String mediumPhrases[]={};

    public Phrase() {
        phrase = "Algo";
    }

    public String getPhrase() {
        return phrase;
    }

    public void chooseEasyPhrases(boolean isWordCorrect) {
        if (isWordCorrect) {
            String easyPhrases[]={};
            int randomNumber = (int) (Math.random() * easyPhrases.length);
            phrase = easyPhrases[randomNumber];

        }
        else {
            String easyPhrases[]={};
            int randomNumber = (int) (Math.random() * easyPhrases.length);
            phrase = easyPhrases[randomNumber];

        }
    }

    public void chooseHardPhrases(boolean isWordCorrect) {
        if (isWordCorrect) {
            String hardPhrases[]={};
            int randomNumber = (int) (Math.random() * hardPhrases.length);
            phrase = hardPhrases[randomNumber];

        }
        else {
            String hardPhrases[] = {};
            int randomNumber = (int) (Math.random() * hardPhrases.length);
            phrase = hardPhrases[randomNumber];
        }
    }

    public void chooseMediumPhrases(boolean isWordCorrect) {
        if (isWordCorrect) {
            String mediumPhrases[]={};
            int randomNumber = (int) (Math.random() * mediumPhrases.length);
            phrase = mediumPhrases[randomNumber];

        }
        else {
            String mediumPhrases[]={};
            int randomNumber = (int) (Math.random() * mediumPhrases.length);
            phrase = mediumPhrases[randomNumber];

        }
    }

}
