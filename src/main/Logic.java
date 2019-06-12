package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

class Logic {

    //Closes one window and opens another one.
    void switchScene(String fxml, Button clickedButton, FXMLLoader fxmlLoader) throws IOException {
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage = new Stage();

        stage.setTitle("Tierverleih GMBH");
        stage.setScene(scene);
        stage.show();

        stage = (Stage) clickedButton.getScene().getWindow();
        stage.close();
    }
}
