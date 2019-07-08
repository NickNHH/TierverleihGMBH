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

    private static Gui gui = new Gui();
    private SplitPane splitPaneHor;
    private ArrayList<SplitPane> allSplitPanes = new ArrayList<>();

    //Private constructor
    private Gui() {
    }

    //Static instance method
    static Gui getInstance() {
        return gui;
    }

    public ArrayList<SplitPane> getAllSplitPanes() {
        return allSplitPanes;
    }

    void addSplitPane() {
        allSplitPanes.add(splitPaneHor);
    }

    private ImageView createImageView(Animal animal, boolean isCart) {
        ImageView imageView = new ImageView();
        if (isCart) {
            imageView.setImage(new Image(CartItem.getCartItems().get(animal.getId()).getPicture()));
        } else {
            imageView.setImage(new Image(AnimalList.getChosenAnimals().get(animal.getId()).getPicture()));
        }

        imageView.setFitWidth(IMAGE_VIEW_SIZE);
        imageView.setFitHeight(IMAGE_VIEW_SIZE);
        imageView.setY((animal.getId() * SPACE_BETWEEN_VIEWS) + INIT_SPACE_FROM_TOP);

        return imageView;
    }

    private Label createNameLabel(Animal animal, boolean isCart) {
        Label name;
        if (isCart) {
            name = new Label(CartItem.getCartItems().get(animal.getId()).getName());
        } else {
            name = new Label(AnimalList.getChosenAnimals().get(animal.getId()).getName());
        }

        setLabel(animal, name, NAME_LABEL_WIDTH);
        name.setLayoutX(IMAGE_VIEW_SIZE);

        return name;
    }

    private Label createStatusLabel(Animal animal, boolean isCart) {
        Label status;
        if (isCart) {
            status = new Label(CartItem.getCartItems().get(animal.getId()).getStatus());
        } else {
            status = new Label(AnimalList.getChosenAnimals().get(animal.getId()).getStatus());
        }

        setLabel(animal, status, STATUS_LABEL_WIDTH);
        status.setLayoutX(IMAGE_VIEW_SIZE + NAME_LABEL_WIDTH);

        return status;
    }

    private Label createDescLabel(Animal animal, boolean isCart) {
        Label desc;
        if (isCart) {
            desc = new Label(CartItem.getCartItems().get(animal.getId()).getDescription());
        } else {
            desc = new Label(AnimalList.getChosenAnimals().get(animal.getId()).getDescription());
        }

        setLabel(animal, desc, DESC_LABEL_WIDTH);
        desc.setLayoutX(IMAGE_VIEW_SIZE);
        desc.setLayoutY((animal.getId() * SPACE_BETWEEN_VIEWS + LABEL_HEIGHT) + INIT_SPACE_FROM_TOP);

        return desc;
    }

    private Button createButton(Animal animal) {
        Button button = new Button();
        button.setFont(new Font(25));
        button.setAlignment(Pos.CENTER);
        button.setLayoutX(IMAGE_VIEW_SIZE + DESC_LABEL_WIDTH);
        button.setLayoutY((animal.getId() * SPACE_BETWEEN_VIEWS + LABEL_HEIGHT) + INIT_SPACE_FROM_TOP);
        button.setMinWidth(BUTTON_WIDTH);
        button.setPrefHeight(LABEL_HEIGHT);

        return button;
    }

    private Button createAddButton(Animal animal, VBox vBox) {
        Button button = createButton(animal);

        button.setText("Add");

        button.setOnAction(e -> {
            System.out.println("vor: " + allSplitPanes.size());
            CartItem.addItem(AnimalList.getChosenAnimals().get(animal.getId()));
            vBox.getChildren().remove(allSplitPanes.get(animal.getId()));
            allSplitPanes.remove(animal.getId());
            System.out.println("nach: " + allSplitPanes.size());
        });

        return button;
    }

    private Button createDeleteButton(Animal animal, VBox vBox) {
        Button button = createButton(animal);

        button.setText("Delete");
        button.setFont(new Font(22));

        button.setOnAction(e -> {
            CartItem.deleteItem(AnimalList.getChosenAnimals().get(animal.getId()));
            System.out.println(getAllSplitPanes().size());
            vBox.getChildren().removeAll(allSplitPanes);
            allSplitPanes.remove(animal.getId());
        });

        return button;
    }

    private void setLabel(Animal animal, Label label, int width) {
        label.setFont(new Font(25));
        label.setAlignment(Pos.CENTER);
        label.setLayoutY((animal.getId() * SPACE_BETWEEN_VIEWS) + INIT_SPACE_FROM_TOP);
        label.setMinWidth(width);
        label.setPrefHeight(LABEL_HEIGHT);
        label.setStyle("-fx-border-color: black");
    }

    void createAnimalGUI(Animal animal, VBox vBox, boolean isCart) {
        splitPaneHor = new SplitPane();
        splitPaneHor.setOrientation(Orientation.HORIZONTAL);
        SplitPane splitPaneVer = new SplitPane();
        splitPaneVer.setOrientation(Orientation.VERTICAL);
        HBox hBoxTop = new HBox();
        HBox hBoxBottom = new HBox();

        splitPaneHor.getItems().add(createImageView(animal, isCart));
        splitPaneHor.getItems().add(splitPaneVer);
        splitPaneVer.getItems().add(hBoxTop);
        splitPaneVer.getItems().add(hBoxBottom);
        hBoxTop.getChildren().add(createNameLabel(animal, isCart));
        hBoxTop.getChildren().add(createStatusLabel(animal, isCart));
        hBoxBottom.getChildren().add(createDescLabel(animal, isCart));

        if (isCart) {
            hBoxBottom.getChildren().add(createDeleteButton(animal, vBox));
        } else {
            hBoxBottom.getChildren().add(createAddButton(animal, vBox));
        }

        vBox.getChildren().add(splitPaneHor);
        /*vBox.getChildren().add(splitPaneVer);
        vBox.getChildren().add(hBoxTop);
        vBox.getChildren().add(hBoxBottom);*/
    }
}
