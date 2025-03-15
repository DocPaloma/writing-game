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

    private void endGame(){
        dogSaysTextArea.setText("¡Te has quedao sin tiempo!");
        wordToWriteTextArea.setDisable(true);
    }

    private void endGame02(){
        dogSaysTextArea.setText("te has quedao sin oportunidades!");
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
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(seconds), event -> {
            gameDogImageView.setImage(neutralCheems);
        }));
        timeline2.setCycleCount(1);
        timeline2.play();
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
                endGame02();
            }
            else {
                game.reduceChances();
                eclipse();
            }

        }
    }

    private void loadSun(){
        Image sun = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/sol.jpg"));
        sunImageView.setImage(sun);
    }

    private void eclipse(){
        Image eclipse1 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/Eclipse1.jpg"));
        Image eclipse2 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/Eclipse-25.jpg"));
        Image eclipse3 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/eclipse-50.jpg"));
        Image eclipse4 = new Image(getClass().getResourceAsStream("/com/example/writinggame/images/eclipse-75.jpg"));
        if (game.getChances()==0){
            sunImageView.setImage(eclipse1);
        }
        else if (game.getChances()==1){
            sunImageView.setImage(eclipse4);
        }
        else if (game.getChances()==2){
            sunImageView.setImage(eclipse3);
        }
        else {
            sunImageView.setImage(eclipse2);
        }
    }


}