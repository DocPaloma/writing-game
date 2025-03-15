package com.example.writinggame.controller;

import com.example.writinggame.model.Dog;
import com.example.writinggame.model.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameController {

    @FXML
    private Button checkPhraseButton;

    @FXML
    private TextArea dogSaysTextArea;

    @FXML
    private ImageView gameDogImageView;

    @FXML
    private Label levelGameLabel;

    @FXML
    private TextArea wordToWriteTextArea;

    @FXML
    private ImageView sunImageView;

    @FXML
    private Label timeGameLabel;

    @FXML
    private TextField writingWordTextField;

    private Game game;
    private Dog dog;
    private int timeGame;
    private Timeline timeline;

    @FXML
    void onActionCheckPhraseButton(ActionEvent event) {
        String wordWritten = writingWordTextField.getText();
        checkWord(wordWritten);
        System.out.printf(wordWritten);
    }


    @FXML
    void onActionWritingWordTextField(ActionEvent event) {
        String wordWritten = writingWordTextField.getText();
        checkWord(wordWritten);
        System.out.printf(wordWritten);
    }


    public void initialize(){
        game = new Game();
        dog = new Dog();
        timeGame = 20;
        dogSaysTextArea.setDisable(true);
        wordToWriteTextArea.setDisable(true);
        wordToWriteTextArea.setText(game.getWord());
        levelGameLabel.setText("Level: " + game.getLevelId());
        loadDog();
        startTimer();
        loadSun();
    }

    private void startTimer(){
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (timeGame > 0){
                timeGame --;
                timeGameLabel.setText("Tiempo: " + timeGame);
            }
            else {
                timeline.stop();
                endGame();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * method to finish the game due to time
     */
    private void endGame(){
        int levelsCompleted =game.getLevelId() - 1;
        dogSaysTextArea.setText("¡Te has quedao sin tiempo!\n" + "Has completado " + levelsCompleted + "niveles!\n");
        writingWordTextField.setDisable(true);
        checkPhraseButton.setDisable(true);

    }

    /**
     *  method to finish the game due to lack of chances
     */
    private void endGame02(){
        int levelsCompleted =game.getLevelId() - 1;
        dogSaysTextArea.setText("te has quedao sin oportunidades!\n"  + "Has completado " + levelsCompleted + "niveles!\n");
        writingWordTextField.setDisable(true);
        checkPhraseButton.setDisable(true);
    }

    /**
     * method to load dog image
     */
    private void loadDog(){
        Image neutralCheems = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/cheems.jpg"));
        gameDogImageView.setImage(neutralCheems);
    }

    /**
     * method to change the dog image when an error is made
     */
    private void errorDog(){
        Image neutralCheems = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/cheems.jpg"));
        Image error = new Image(getClass().getResourceAsStream("/com/example/writinggame/gifs/bonk-doge.gif"));
        int seconds = 1;
        gameDogImageView.setImage(error);
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(seconds), event -> {
            gameDogImageView.setImage(neutralCheems);
        }));
        timeline2.setCycleCount(1);
        timeline2.play();
    }

    /**
     * method to update the word label
     */
    private void updateWord(){
        wordToWriteTextArea.setText(game.getWord());
    }

    /**
     * method to update the game level
     */
    private void updateLevel(){
        levelGameLabel.setText("Level: " + game.getLevelId());
    }

    /**
     * method that implements the logic to compare the words
     * @param wordWritten: word input by the user
     */
    private void checkWord(String wordWritten){
        if (wordWritten.equals(game.getWord())) {
            if(game.getDifficulty().equals("easy")){
                Boolean a = true;
                dog.chooseEasyPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else if (game.getDifficulty().equals("medium")){
                Boolean a = true;
                dog.chooseMediumPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else{
                Boolean a = true;
                dog.chooseHardPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            writingWordTextField.clear();
            game.increaseLevelId();
            game.chooseWord();
            updateWord();
            updateLevel();
            reduceTime(game.getLevelId());
        }
        else{
            if(game.getDifficulty().equals("easy")){
                Boolean a = false;
                dog.chooseEasyPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else if (game.getDifficulty().equals("medium")){
                Boolean a = false;
                dog.chooseMediumPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else{
                Boolean a = false;
                dog.chooseHardPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            writingWordTextField.clear();
            errorDog();
            eclipse();
            if (game.getChances()==0){
                endGame02();
            }
            else {
                game.reduceChances();
            }

        }
    }

    /**
     * method to load initial sun
     */
    private void loadSun(){
        Image sun = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/sol.jpg"));
        sunImageView.setImage(sun);
    }

    /**
     * method that implements the logic to change the sun, showing how many tries are left
     */
    private void eclipse(){
        int chances  = game.getChances();
        Image eclipse1 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/Eclipse1.jpg"));
        Image eclipse2 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/Eclipse-25.jpg"));
        Image eclipse3 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/eclipse-50.jpg"));
        Image eclipse4 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/eclipse-75.jpg"));
        if (chances == 0){
            sunImageView.setImage(eclipse1);
        }
        else if (chances==1){
            sunImageView.setImage(eclipse4);
        }
        else if (chances==2){
            sunImageView.setImage(eclipse3);
        }
        else {
            sunImageView.setImage(eclipse2);
        }
    }

    /**
     * method that reduces time by 2 secs every 5 levels
     * @param levelId: level number
     */
    private void reduceTime(int levelId){
        int gameLevel = game.getLevelId();
        if (gameLevel%5==0){
            timeGame = timeGame-2;
        }
    }


}