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
        ((CartController) fxmlLoader.getController()).init();
    }

    public void sendOrder() throws IOException {
        Order order = new Order(firstNameTf.getText(), lastNameTf.getText(), emailTf.getText(), streetTf.getText(), zipCodeTf.getText(), reasonTf.getText());
        order.addOrders(order);

        logic.switchScene("fxml/ConfirmOrderFxml.fxml", orderBtn, fxmlLoader);
        ((ConfirmOrderController) fxmlLoader.getController()).init(order);
    }
}
