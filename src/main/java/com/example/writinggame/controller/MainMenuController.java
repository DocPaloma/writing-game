package com.example.writinggame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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
        Stage instructionsStage = new Stage();
        instructionsStage.setTitle("Instructions");
        Label instructionsLabel = new Label("Instrucciones del juego: \n\n" + "");
        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(e -> instructionsStage.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(instructionsLabel, closeButton);

        Scene scene = new Scene(layout, 300, 200);
        instructionsStage.setScene(scene);
        instructionsStage.initModality(Modality.APPLICATION_MODAL);
        instructionsStage.setResizable(false);
        instructionsStage.show();

    }

    @FXML
    void onActionStartButtom(ActionEvent event) throws IOException {
        Parent secondView = FXMLLoader.load(getClass().getResource("/com/example/writinggame/game-view.fxml"));
        Stage stage = (Stage) instructionsButtom.getScene().getWindow();
        stage.setScene(new Scene(secondView));

    }

    public void initialize() {
        loadMainMenuImage();
    }

    private void loadMainMenuImage() {
        Image gifMainMenuImage1 = new Image(getClass().getResourceAsStream("/com/example/writinggame/gifs/8a9122c51bcc5a09d30fba2efe6d75dd.gif"));
        Image gifMainMenuImage2 = new Image(getClass().getResourceAsStream("/com/example/writinggame/gifs/giphy.gif"));
        mainMenuImage1.setImage(gifMainMenuImage1);
        mainMenuImage2.setImage(gifMainMenuImage2);
    }

}
