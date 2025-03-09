module com.example.writinggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.writinggame.controller to javafx.fxml;
}