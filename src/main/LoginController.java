package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
	public Button backBtn;
	public PasswordField passwordTf;
	public Pane pane;

	private Logic logic = new Logic();
	private FXMLLoader fxmlLoader = new FXMLLoader();

	void init() {
		// Loads class
	}

	// Opens main window and closes this window.
	public void goBack() throws IOException {
		logic.switchScene("fxml/MainFxml.fxml", backBtn, fxmlLoader);
		((MainController) fxmlLoader.getController()).init();
	}

	public void enter() {
		pane.setOnKeyPressed(event -> {
            if (passwordTf.getText().equals("tierequaelen")) {
                try {
                    logic.switchScene("fxml/AnimalOverviewFxml.fxml", null, fxmlLoader);
                      Stage stage = (Stage) pane.getScene().getWindow();
                        stage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Incorrect Password");
                alert.setHeaderText("Are you really an Employee?");
                alert.setContentText(
                        "Please try again! And if you fail again we will come to you and burn down your home!");

                alert.showAndWait();
            }
        });
	}

}
