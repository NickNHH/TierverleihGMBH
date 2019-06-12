package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public Button animalBtn;
    public Button loginBtn;

    private FXMLLoader fxmlLoader = new FXMLLoader();
    private Logic logic = new Logic();

    //Opens the login page and closes title screen
    public void login() throws IOException {
        logic.switchScene("fxml/LoginFxml.fxml", "Mitarbeiter Login", loginBtn, fxmlLoader);
        ((LoginController) fxmlLoader.getController()).init();
    }

    //Opens the animal species choosing page and closes title screen
    public void goToAnimals() throws IOException {
        logic.switchScene("fxml/ChooseSpeciesFxml.fxml", "Tierverleih GMBH", animalBtn, fxmlLoader);
        ((ChooseSpeciesController) fxmlLoader.getController()).init();
    }
}
