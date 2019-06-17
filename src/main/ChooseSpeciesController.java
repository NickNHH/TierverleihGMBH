package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        fillImageViews();
    }

    //Opens cart window and closes this window.
    public void goToCart() throws IOException {
        logic.switchScene("fxml/CartFxml.fxml", cartBtn, fxmlLoader);
        ((CartController) fxmlLoader.getController()).init();
    }

    //Opens main window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/MainFxml.fxml", backBtn, fxmlLoader);
        ((MainController) fxmlLoader.getController()).init();
    }

    public void loadGiraffes() throws IOException {
        //TODO: Load all giraffes in an List
        AnimalList.addGiraffes();
        switchScene();
    }

    public void loadLoris() throws IOException {
        //TODO: Load all loris' in an List
        switchScene();
    }

    public void loadRabbits() throws IOException {
        //TODO: Load all rabbits in an List
        AnimalList.addRabbits();
        switchScene();
    }

    public void loadGuenthers() throws IOException {
        //TODO: Load all guenthers in an List
        switchScene();
    }

    public void loadBats() throws IOException {
        //TODO: Load all bats in an List
        switchScene();
    }

    public void loadFoxes() throws IOException {
        //TODO: Load all foxes in an List
        switchScene();
    }

    public void handMouse() {
        pane.setCursor(Cursor.HAND);
    }

    public void normalMouse() {
        pane.setCursor(Cursor.DEFAULT);
    }

    private void fillImageViews() {
        giraffeView.setImage(new Image("giraffe.jpg"));
        lorisView.setImage(new Image("loris.jpg"));
        rabbitView.setImage(new Image("rabbit.jpg"));
        guentherdikdikView.setImage(new Image("guenther.jpg"));
        batView.setImage(new Image("bat.jpeg"));
        foxView.setImage(new Image("fox.jpg"));
    }

    private void switchScene() throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();

        logic.switchScene("fxml/ChooseAnimalFxml.fxml", null, fxmlLoader);
        ((ChooseAnimalController) fxmlLoader.getController()).init();
    }
}
