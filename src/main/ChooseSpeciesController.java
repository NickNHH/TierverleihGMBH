package main;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ChooseSpeciesController {
    public Button backBtn;
    public Button cartBtn;
    public ImageView giraffeView;
    public ImageView lorisView;
    public ImageView batView;
    public ImageView foxView;
    public ImageView rabbitView;
    public ImageView guentherdikdikView;
    public Pane pane;

    public void loadGiraffes() {
    }

    public void loadLoris() {
    }

    public void loadRabbits() {
    }

    public void loadGuenthers() {
    }

    public void loadBats() {
    }

    public void loadFoxes() {
    }

    public void handMouse() {
        pane.setCursor(Cursor.HAND);
    }

    public void normalMouse() {
        pane.setCursor(Cursor.DEFAULT);
    }
}
