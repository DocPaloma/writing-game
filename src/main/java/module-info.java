module com.example.writinggame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.writinggame.controller to javafx.graphics, javafx.fxml;
    opens com.example.writinggame to javafx.graphics, javafx.fxml;
}