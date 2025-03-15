package com.example.writinggame.controller;

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
    private int timeGame = 20;
    private Timeline timeline;
    private Stage wordWrittrn;

    @FXML
    void onActionCheckPhraseButton(ActionEvent event) {

    }

    public void initialize(){
        game = new Game();
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

}