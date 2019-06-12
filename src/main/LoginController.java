package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    public Button backBtn;
    public TextField passwordTf;

    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();

    void init() {
        //Loads class
    }

    //Opens main window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/MainFxml.fxml", backBtn, fxmlLoader);
        ((MainController) fxmlLoader.getController()).init();
    }
}
