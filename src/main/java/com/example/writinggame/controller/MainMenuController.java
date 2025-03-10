package com.example.writinggame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController {

    @FXML
    private Button instructionsButtom;

    @FXML
    private Button startButtom;

    @FXML
    private ImageView mainMenuImage1;

    @FXML
    private ImageView mainMenuImage2;

    @FXML
    void onActionInstructionsButtom(ActionEvent event) {

    }

    @FXML
    void onActionStartButtom(ActionEvent event) {

    }

    public void initialize(URL location, ResourceBundle resources) {
        loadMainMenuImage();
    }

    private void loadMainMenuImage() {
        Image gifMainMenuImage1 = new Image(getClass().getResourceAsStream("com/example/writinggame/gifs/8a9122c51bcc5a09d30fba2efe6d75dd.gif"));
        Image gifMainMenuImage2 = new Image(getClass().getResourceAsStream("com/example/writinggame/gifs/giphy.gif"));
        mainMenuImage1.setImage(gifMainMenuImage1);
        mainMenuImage2.setImage(gifMainMenuImage2);
    }

}
