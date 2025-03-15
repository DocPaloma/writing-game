package com.example.writinggame.model;
;

/**
 * Class that works the logic for the dog, which is in charge to indicate if the word as been written correctly or not
 */
public class Dog {
    /**
     * phrase that the dog would say
     * @serialField
     */
    private String phrase;



    public Dog() {
        phrase = "";
    }

    /**
     * method to get the phrase
     * @return the dog phrase
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * method that chooses a phrase for easy difficulty
     * @param isWordCorrect: if the word is correct
     */
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

    /**
     * method that chooses a phrase for hard difficulty
     * @param isWordCorrect: if the word is correct
     */
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

    /**
     * method that chooses a phrase for medium difficulty
     * @param isWordCorrect: if the word is correct
     */
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
