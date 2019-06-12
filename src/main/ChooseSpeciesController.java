package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ChooseSpeciesController {
    public Button backBtn;
    public Button cartBtn;
    public ImageView giraffeView;
    public ImageView lorisView;
    public ImageView batView;
    public ImageView foxView;
    public ImageView rabbitView;
    public ImageView guentherdikdikView;
    public Pane pane;

    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();

    void init() {
        //Loads class
    }

    //Opens cart window and closes this window.
    public void goToCart() throws IOException {
        logic.switchScene("fxml/CartFxml.fxml", "Warenkorb", cartBtn, fxmlLoader);
        ((CartController) fxmlLoader.getController()).init();
    }

    //Opens main window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/MainFxml.fxml", "Tierverleih GMBH", backBtn, fxmlLoader);
        ((MainController) fxmlLoader.getController()).init();
    }

    /*
     * TODO: For ALL following 6 load methods:
     *       - Close this window and open the ChooseAnimalController page after mouse click
     *       - Load the correct animal in e.g. ArrayList, so we can call it from the ChooseAnimalController class
     */
    public void loadGiraffes() {
    }

    public void loadLoris() {
    }

    public void loadRabbits() {
    }

    public void loadGuenthers() {
    }

    public void loadBats() {
    }

    public void loadFoxes() {
    }

    public void handMouse() {
        pane.setCursor(Cursor.HAND);
    }

    public void normalMouse() {
        pane.setCursor(Cursor.DEFAULT);
    }
}
