package main;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.animals.Giraffe;

import java.util.ArrayList;

public class Gui {

    private static final int IMAGE_VIEW_SIZE = 150;
    private static final int NAME_LABEL_WIDTH = 450;
    private static final int STATUS_LABEL_WIDTH = 200;
    private static final int DESC_LABEL_WIDTH = 550;
    private static final int BUTTON_WIDTH = 100;
    private static final int LABEL_HEIGHT = 75;
    private static final int SPACE_BETWEEN_VIEWS = 200;
    private static final int INIT_SPACE_FROM_TOP = 80;

    private SplitPane splitPaneHor;
    private ArrayList<SplitPane> allSplitPanes = new ArrayList<>();

    public ArrayList<SplitPane> getAllSplitPanes() {
        return allSplitPanes;
    }

    void addSplitPane() {
        allSplitPanes.add(splitPaneHor);
    }

    private ImageView createImageView(int i, boolean isCart) {
        ImageView imageView = new ImageView();
        if (isCart) {
            imageView.setImage(new Image(CartItem.getCartItems().get(i).getPicture()));
        }
        else {
            imageView.setImage(new Image(AnimalList.getChosenAnimals().get(i).getPicture()));
        }

        imageView.setFitWidth(IMAGE_VIEW_SIZE);
        imageView.setFitHeight(IMAGE_VIEW_SIZE);
        imageView.setY((i * SPACE_BETWEEN_VIEWS) + INIT_SPACE_FROM_TOP);

        return imageView;
    }

    private Label createNameLabel(int i, boolean isCart) {
        Label name;
        if (isCart) {
            name = new Label(CartItem.getCartItems().get(i).getName());
        }
        else {
            name = new Label(AnimalList.getChosenAnimals().get(i).getName());
        }

        setLabel(name, i, NAME_LABEL_WIDTH);
        name.setLayoutX(IMAGE_VIEW_SIZE);

        return name;
    }

    private Label createStatusLabel(int i, boolean isCart) {
        Label status;
        if (isCart) {
            status = new Label(CartItem.getCartItems().get(i).getStatus());
        }
        else {
            status = new Label(AnimalList.getChosenAnimals().get(i).getStatus());
        }

        setLabel(status, i, STATUS_LABEL_WIDTH);
        status.setLayoutX(IMAGE_VIEW_SIZE + NAME_LABEL_WIDTH);

        return status;
    }

    private Label createDescLabel(int i, boolean isCart) {
        Label desc;
        if (isCart) {
            desc = new Label(CartItem.getCartItems().get(i).getDescription());
        }
        else {
            desc = new Label(AnimalList.getChosenAnimals().get(i).getDescription());
        }

        setLabel(desc, i, DESC_LABEL_WIDTH);
        desc.setLayoutX(IMAGE_VIEW_SIZE);
        desc.setLayoutY((i * SPACE_BETWEEN_VIEWS + LABEL_HEIGHT) + INIT_SPACE_FROM_TOP);

        return desc;
    }

    private Button createAddButton(int i, VBox vBox, boolean isCart) {
        Button button = new Button("Add");
        button.setFont(new Font(25));
        button.setAlignment(Pos.CENTER);
        button.setLayoutX(IMAGE_VIEW_SIZE + DESC_LABEL_WIDTH);
        button.setLayoutY((i * SPACE_BETWEEN_VIEWS + LABEL_HEIGHT) + INIT_SPACE_FROM_TOP);
        button.setMinWidth(BUTTON_WIDTH);
        button.setPrefHeight(LABEL_HEIGHT);

        if (isCart) {
            button.setText("Added");
            button.setFont(new Font(22));
            button.setDisable(true);
        }

        button.setOnAction(e -> {
            CartItem.addItem(AnimalList.getChosenAnimals().get(i));
            for (Animal animal1 : CartItem.getCartItems()) {
                System.out.println(animal1.getName());
            }
            vBox.getChildren().remove(allSplitPanes.get(i));
        });

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

    void createAnimalGUI(int i, VBox vBox, boolean isCart) {
        splitPaneHor = new SplitPane();
        splitPaneHor.setOrientation(Orientation.HORIZONTAL);
        SplitPane splitPaneVer = new SplitPane();
        splitPaneVer.setOrientation(Orientation.VERTICAL);
        HBox hBoxTop = new HBox();
        HBox hBoxBottom = new HBox();

        splitPaneHor.getItems().add(createImageView(i, isCart));
        splitPaneHor.getItems().add(splitPaneVer);
        splitPaneVer.getItems().add(hBoxTop);
        splitPaneVer.getItems().add(hBoxBottom);
        hBoxTop.getChildren().add(createNameLabel(i, isCart));
        hBoxTop.getChildren().add(createStatusLabel(i, isCart));
        hBoxBottom.getChildren().add(createDescLabel(i, isCart));
        hBoxBottom.getChildren().add(createAddButton(i, vBox, isCart));

        vBox.getChildren().add(splitPaneHor);
        vBox.getChildren().add(splitPaneVer);
        vBox.getChildren().add(hBoxTop);
        vBox.getChildren().add(hBoxBottom);
    }
}
