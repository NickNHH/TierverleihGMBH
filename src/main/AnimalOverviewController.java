package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AnimalOverviewController {
    public Pane pane;
    public Button backBtn;
    public Button newAnimalBtn;

    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();

    void init() {
        //load class
    }

    //Opens main window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/MainFxml.fxml", "Tierverleih GMBH", backBtn, fxmlLoader);
        ((MainController) fxmlLoader.getController()).init();
    }

    //Create new entry for animal
    public void newAnimal() {
        /*
         * TODO: - On button click, add new GUI elements like for the other animals (Pic, name, status, description)
         */
    }
}
