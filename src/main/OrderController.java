package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class OrderController {
    public Button backBtn;
    public TextField lastNameTf;
    public TextField firstNameTf;
    public TextField emailTf;
    public TextField streetTf;
    public TextField zipCodeTf;
    public TextField reasonTf;
    public Button orderBtn;

    void init() {
        //loads class
    }

    private Logic logic = new Logic();
    private FXMLLoader fxmlLoader = new FXMLLoader();

    //Opens cart window and closes this window.
    public void goBack() throws IOException {
        logic.switchScene("fxml/CartFxml.fxml", backBtn, fxmlLoader);
        ((OrderController) fxmlLoader.getController()).init();
    }

    public void sendOrder() {
        /*
         * TODO: - This window should close after button click
         *       - Save all data (Conent of shopping cart + personal data from this form) in an ArrayList or similar, so we can use this later again.
         */
    }
}
