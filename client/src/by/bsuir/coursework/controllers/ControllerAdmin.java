package by.bsuir.coursework.controllers;

import by.bsuir.coursework.collections.CollectionUsers;
import by.bsuir.coursework.collections.UserInf;
import by.bsuir.coursework.connection.Connect;
import by.bsuir.coursework.entity.User;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControllerAdmin {
    @FXML
    private ImageView hideButton;

    @FXML
    private ImageView closeButton;

    @FXML
    private Label dateTime;

    @FXML
    private Button userButton;

    @FXML
    private Button listUsersButton;

    @FXML
    private Button addMovieButton;

    @FXML
    private Button listMovieButton;

    @FXML
    private Button makeScheduleButton;

    @FXML
    private Button viewScheduleButton;

    @FXML
    private Button estimateLossesButton;

    @FXML
    private Button cinemaInfoButton;

    @FXML
    private Pane listUsersPane;

    @FXML
    private Pane viewSchedulePane;

    @FXML
    private Pane placesCinemaPane;

    @FXML
    private Pane addMoviePane;

    @FXML
    private Pane listMoviePane;

    @FXML
    private Pane makeSchedulePane;

    @FXML
    private ScrollPane cinemaInfoPane;

    @FXML
    private Pane userPane;

    @FXML
    private Pane estimateLossesPane;

    @FXML
    private TableView<UserInf> userTable;

    @FXML
    private TableColumn<UserInf, Integer> id;

    @FXML
    private TableColumn<UserInf, String> surname;

    @FXML
    private TableColumn<UserInf, String> name;

    @FXML
    private TableColumn<UserInf, String> login;

    @FXML
    private TableColumn<UserInf, String> tel;

    @FXML
    private TableColumn<UserInf, String> email;

    @FXML
    private TableColumn<UserInf, String> password;

    public ControllerAdmin() { }

    @FXML
    void handleCliks(ActionEvent event) {
        if(event.getSource()==userButton){
            userPane.toFront();
        }
        else if(event.getSource()==listUsersButton){
            listUsersPane.toFront();
        }
        else if(event.getSource()==addMovieButton){
            addMoviePane.toFront();
        }
        else if(event.getSource()==listMovieButton){
            listMoviePane.toFront();
        }
        else if(event.getSource()==makeScheduleButton){
            makeSchedulePane.toFront();
        }
        else if(event.getSource()==viewScheduleButton){
            viewSchedulePane.toFront();
        }
        else if(event.getSource()==estimateLossesButton){
            estimateLossesPane.toFront();
        }
        else if(event.getSource()==cinemaInfoButton){
            cinemaInfoPane.toFront();
        }
    }

    @FXML
    void deleteUser(ActionEvent event) {
        UserInf selectedUser = (UserInf) userTable.getSelectionModel().getSelectedItem();
        CollectionUsers.getInstance().delete(selectedUser);
        Connect.send("deleteUser");
        Connect.send(selectedUser.getId());
    }

    @FXML
    void initialize() {
        //Connect.send("adminPanel");

        initClock();

        userInTable();

        closeButton.setOnMouseClicked(mouseEvent -> {
            Stage stages = (Stage) closeButton.getScene().getWindow();
            stages.close();

        });

        hideButton.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.setIconified(true);
        });
    }

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void userInTable() {
        CollectionUsers.getInstance().fillData();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        userTable.setItems(CollectionUsers.getInstance().getUsers());
    }



}
