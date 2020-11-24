package by.bsuir.coursework.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerAdmin {
    @FXML
    private ImageView hideButton;

    @FXML
    private ImageView closeButton;

    @FXML
    void initialize() {
        closeButton.setOnMouseClicked(mouseEvent -> {
            Stage stages = (Stage) closeButton.getScene().getWindow();
            stages.close();

        });

        hideButton.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.setIconified(true);
        });
    }
}
