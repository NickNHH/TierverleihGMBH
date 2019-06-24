package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ChooseAnimalController {
    public Button backBtn;
    public Button cartBtn;
    public VBox vBox;

    private Gui gui = new Gui();
    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();

    void init() {
        //load class
        for (int i = 0; i < AnimalList.getChosenAnimals().size(); i++) {
            gui.createAnimalGUI(i, vBox, false);
            gui.addSplitPane();
        }
    }

    //opens cart window and closes this window.
    public void goToCart() throws IOException {
        logic.switchScene("fxml/CartFxml.fxml", cartBtn, fxmlLoader);
        ((CartController) fxmlLoader.getController()).init();
    }

    //Opens species choosing window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/ChooseSpeciesFxml.fxml", backBtn, fxmlLoader);
        ((ChooseSpeciesController) fxmlLoader.getController()).init();
    }
}
