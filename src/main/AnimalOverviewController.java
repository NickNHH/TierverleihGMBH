package main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AnimalOverviewController implements Initializable{
    public Pane pane;
    public Pane showList;
    public Button backBtn;
    public Button newAnimalBtn;
    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();

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
		for(Animal animal : AnimalFile.getAnimalList())
			
		showList.getChildren().add(animal);		
	}
}
