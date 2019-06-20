package main;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

class Logic {

    private static final int IMAGE_VIEW_SIZE = 150;
    private static final int NAME_LABEL_WIDTH = 450;
    private static final int STATUS_LABEL_WIDTH = 200;
    private static final int DESC_LABEL_WIDTH = 550;
    private static final int BUTTON_WIDTH = 100;
    private static final int LABEL_HEIGHT = 75;
    private static final int SPACE_BETWEEN_VIEWS = 200;
    private static final int INIT_SPACE_FROM_TOP = 80;

    //Closes one window and opens another one.
    void switchScene(String fxml, Button clickedButton, FXMLLoader fxmlLoader) throws IOException {
        fxmlLoader.setLocation(getClass().getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage = new Stage();

        stage.setTitle("Tierverleih GMBH");
        stage.setScene(scene);
        stage.show();

        if (clickedButton != null) {
            stage = (Stage) clickedButton.getScene().getWindow();
            stage.close();
        }
    }

    ImageView createImageView(int i) {
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(AnimalList.getChosenAnimals().get(i).getPicture()));
        imageView.setFitWidth(IMAGE_VIEW_SIZE);
        imageView.setFitHeight(IMAGE_VIEW_SIZE);
        imageView.setY((i * SPACE_BETWEEN_VIEWS) + INIT_SPACE_FROM_TOP);

        return imageView;
    }

    Label createNameLabel(int i) {
        Label name = new Label(AnimalList.getChosenAnimals().get(i).getName());
        setLabel(name, i, NAME_LABEL_WIDTH);
        name.setLayoutX(IMAGE_VIEW_SIZE);

        return name;
    }

    Label createStatusLabel(int i) {
        Label status = new Label(AnimalList.getChosenAnimals().get(i).getStatus());
        setLabel(status, i, STATUS_LABEL_WIDTH);
        status.setLayoutX(IMAGE_VIEW_SIZE + NAME_LABEL_WIDTH);

        return status;
    }

    Label createDescLabel(int i) {
        Label desc = new Label(AnimalList.getChosenAnimals().get(i).getDescription());
        setLabel(desc, i, DESC_LABEL_WIDTH);
        desc.setLayoutX(IMAGE_VIEW_SIZE);
        desc.setLayoutY((i * SPACE_BETWEEN_VIEWS + LABEL_HEIGHT) + INIT_SPACE_FROM_TOP);

        return desc;
    }

    Button createAddButton(int i) {
        Button button = new Button("Add");
        button.setFont(new Font(25));
        button.setAlignment(Pos.CENTER);
        button.setLayoutX(IMAGE_VIEW_SIZE + DESC_LABEL_WIDTH);
        button.setLayoutY((i * SPACE_BETWEEN_VIEWS + LABEL_HEIGHT) + INIT_SPACE_FROM_TOP);
        button.setMinWidth(BUTTON_WIDTH);
        button.setPrefHeight(LABEL_HEIGHT);

        return button;
    }

    private void setLabel(Label label, int i, int width) {
        label.setFont(new Font(25));
        label.setAlignment(Pos.CENTER);
        label.setLayoutY((i * SPACE_BETWEEN_VIEWS) + INIT_SPACE_FROM_TOP);
        label.setMinWidth(width);
        label.setPrefHeight(LABEL_HEIGHT);
        label.setStyle("-fx-border-color: black");
    }
}
