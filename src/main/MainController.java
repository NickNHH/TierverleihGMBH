package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public Button animalBtn;
    public Button loginBtn;

    //Opens the login page and closes title screen
    public void login() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("fxml/LoginFxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ((LoginController) fxmlLoader.getController()).init();
        Stage stage = new Stage();

        stage.setTitle("Mitarbeiter login");
        stage.setScene(scene);
        stage.show();

        stage = (Stage) loginBtn.getScene().getWindow();
        stage.close();
    }
}
