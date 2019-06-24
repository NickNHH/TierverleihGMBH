package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CartController {
    public Button backBtn;
    public Button orderBtn;
    public VBox vBox;

    private Gui gui = new Gui();
    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();

    void init() {
        //loads class
        for (int i = 0; i < CartItem.getCartItems().size(); i++) {
            gui.createAnimalGUI(i, vBox, true);
        }
    }

    //Opens species choosing window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/ChooseSpeciesFxml.fxml", backBtn, fxmlLoader);
        ((ChooseSpeciesController) fxmlLoader.getController()).init();
    }

    //Opens order form window and closes this window.
    public void order() throws IOException {
        logic.switchScene("fxml/OrderFxml.fxml", orderBtn, fxmlLoader);
        ((OrderController) fxmlLoader.getController()).init();
    }
}
