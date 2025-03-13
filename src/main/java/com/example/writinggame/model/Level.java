package com.example.writinggame.model;

/**
 * Creation of Level class to do a simple level management
 * @author Alejandro Medina
 * @version 0.0.1
 */
public class Level {
    /**
     * The ID or number of a level
     * @serialField
     */
    private int levelId;
    /**
     * The difficulty of a level
     * @serialField
     */
    private String difficulty;
    /**
     * The word to be written
     * @serialField
     */
    private String word;

    /**
     * Creator method for a level.
     * @param levelId: ID of a level
     */
    public Level(int levelId) {
        this.levelId = levelId;
        setDifficulty(levelId);
    }

    /**
     * Method that gets a level ID
     * @return the ID of a level
     */
    public int getLevelId() {
        return levelId;
    }

    /**
     * Method that gets a level difficulty
     * @return the difficulty of a level
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Method that sets the difficulty of a level based on the level id
     * @param levelId: level number
     */
    public void setDifficulty(int levelId) {
        if (levelId >= 1 && levelId <= 10) {
            difficulty = "easy";
        }
        else if (levelId >= 11 && levelId <= 20) {
            difficulty = "medium";
        }
        else if (levelId >= 21) {
            difficulty = "hard";
        }
    }

    /**
     * Method that sets the Word to write
     * @param difficulty: level difficulty
     */
    public void chooseWord (String difficulty) {

        if (difficulty == "easy"){
            String easyWords[]={};
            int randomNumber = (int) (Math.random() * easyWords.length);
            word = easyWords[randomNumber];

        }

        else if (difficulty == "hard"){
            String hardWords[]={};
            int randomNumber = (int) (Math.random() * hardWords.length);
            word = hardWords[randomNumber];

        }

        else {
            String mediumWords[] = {};
            int randomNumber = (int) (Math.random() * mediumWords.length);
            word = mediumWords[randomNumber];

        }
    }

    public String getWord() {
        return word;
    }

    /**
     * Method that increases the level
     * @param levelUP: variable that defines if the level needs to be increased
     */
    public void increaseLevelId(boolean levelUP) {
        this.levelId = levelId + 1;
    }

}
