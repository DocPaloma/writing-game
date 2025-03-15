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
import javafx.stage.Stage;
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
    }


    @FXML
    void onActionWritingWordTextField(ActionEvent event) {
        String wordWritten = writingWordTextField.getText();
        checkWord(wordWritten);
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

    private void endGame(){
        dogSaysTextArea.setText("¡Te has quedao sin tiempo!");
        wordToWriteTextArea.setDisable(true);
    }

    private void loadDog(){
        Image neutralCheems = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/cheems.jpg"));
        gameDogImageView.setImage(neutralCheems);
    }

    private void errorDog(){
        Image neutralCheems = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/cheems.jpg"));
        Image error = new Image(getClass().getResourceAsStream("/com/example/writinggame/gifs/bonk-doge.gif"));
        int seconds = 1;
        gameDogImageView.setImage(error);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(seconds), event -> {
            gameDogImageView.setImage(neutralCheems);
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void updateWord(){
        wordToWriteTextArea.setText(game.getWord());
    }

    private void updateLevel(){
        levelGameLabel.setText("Level: " + game.getLevelId());
    }

    private void checkWord(String wordWritten){
        if (wordWritten == game.getWord()) {
            if(game.getDifficulty()== "easy"){
                Boolean a = true;
                dog.chooseEasyPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else if (game.getDifficulty() == "medium"){
                Boolean a = true;
                dog.chooseMediumPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else{
                Boolean a = true;
                dog.chooseHardPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            game.increaseLevelId();
            game.chooseWord();
            updateWord();
            updateLevel();
        }
        else{
            if(game.getDifficulty() == "easy"){
                Boolean a = false;
                dog.chooseEasyPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else if (game.getDifficulty() == "medium"){
                Boolean a = false;
                dog.chooseMediumPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            else{
                Boolean a = false;
                dog.chooseHardPhrases(a);
                dogSaysTextArea.setText(dog.getPhrase());
            }
            errorDog();
            if (game.getChances()==0){
                endGame();
            }
            else {
                game.reduceChances();
            }

        }
    }



}