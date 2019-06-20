package main;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
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
            SplitPane splitPaneHor = new SplitPane();
            splitPaneHor.setOrientation(Orientation.HORIZONTAL);
            SplitPane splitPaneVer = new SplitPane();
            splitPaneVer.setOrientation(Orientation.VERTICAL);
            HBox hBoxTop = new HBox();
            HBox hBoxBottom = new HBox();

            splitPaneHor.getItems().add(gui.createImageView(i));
            splitPaneHor.getItems().add(splitPaneVer);
            splitPaneVer.getItems().add(hBoxTop);
            splitPaneVer.getItems().add(hBoxBottom);
            hBoxTop.getChildren().add(gui.createNameLabel(i));
            hBoxTop.getChildren().add(gui.createStatusLabel(i));
            hBoxBottom.getChildren().add(gui.createDescLabel(i));
            hBoxBottom.getChildren().add(gui.createAddButton(i));

            vBox.getChildren().add(splitPaneHor);
            vBox.getChildren().add(splitPaneVer);
            vBox.getChildren().add(hBoxTop);
            vBox.getChildren().add(hBoxBottom);

            gui.addSplitPane(splitPaneHor);
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
