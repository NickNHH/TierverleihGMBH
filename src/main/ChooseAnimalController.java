package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class ChooseAnimalController {
    public Pane pane;
    public Button backBtn;
    public Button cartBtn;

    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private ArrayList<Animal> animals;

    void init() {
        //load class
        animals = AnimalList.getChosenAnimals();

        for (int i = 0; i < animals.size(); i++) {
            ImageView imageView = new ImageView();
            imageView.setImage(new Image(animals.get(i).getPicture()));
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);
            imageView.setY((i + 1) * 200);

            pane.getChildren().add(imageView);
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
