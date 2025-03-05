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
    public int levelId;
    /**
     * The difficulty of a level
     * @serialField
     */
    public String difficulty;

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
}
