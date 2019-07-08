package main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AnimalOverviewController implements Initializable{
    public Pane pane;
    public VBox showList;
    public Button backBtn;
    public Button newAnimalBtn;
    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();
    
    private Gui gui = new Gui();

    void init() {
        //load class
    }

    //Opens main window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/MainFxml.fxml", backBtn, fxmlLoader);
        ((MainController) fxmlLoader.getController()).init();
    }

    //Create new entry for animal
    public void newAnimal() {
          /*
         * TODO: - On button click, add new GUI elements like for the other animals (Pic, name, status, description)
         */
    }
    //
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for(int i = 0; i < AnimalFile.getAnimalList().size(); i++) {
			gui.createAnimalGUI(i, showList, false);
			//showList.getChildren().add(animal.getName());
		}
	}
}
