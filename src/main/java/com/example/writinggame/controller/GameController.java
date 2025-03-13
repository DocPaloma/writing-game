package com.example.writinggame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    private TextArea phraseToWriteTextArea;

    @FXML
    private ImageView sunImageView;

    @FXML
    private Label timeGameLabel;

    @FXML
    private TextField writingWordTextField;

    @FXML
    void onActionCheckPhraseButton(ActionEvent event) {

    }

}