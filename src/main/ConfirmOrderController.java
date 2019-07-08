package main;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ConfirmOrderController {
    public Label reasonLb;
    public Label zipLb;
    public Label streetLb;
    public Label emailLb;
    public Label lastNameLb;
    public Label firstNameLb;
    public TextArea listItemsTa;

    void init(Order order) {
        reasonLb.setText(order.getReason());
        zipLb.setText(order.getZipCode());
        streetLb.setText(order.getStreet());
        emailLb.setText(order.getEmail());
        lastNameLb.setText(order.getLastname());
        firstNameLb.setText(order.getFirstName());

        listItems();
    }

    private void listItems() {
        for (Animal animal : CartItem.getCartItems()) {
            listItemsTa.setText(listItemsTa.getText() + animal.getName() + "\n");
        }
    }


}
