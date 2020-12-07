package by.bsuir.coursework.controllers;

import by.bsuir.coursework.collections.CollectionMovie;
import by.bsuir.coursework.collections.CollectionSchedule;
import by.bsuir.coursework.collections.MovieInf;
import by.bsuir.coursework.collections.ScheduleInf;
import by.bsuir.coursework.connection.Connect;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControllerUser {
    @FXML
    private ImageView backButton;

    @FXML
    private ImageView hideButton;

    @FXML
    private ImageView closeButton;

    @FXML
    private Button userButton;

    @FXML
    private Button listMovieButton;

    @FXML
    private Button viewScheduleButton;

    @FXML
    private Button cinemaInfoButton;

    @FXML
    private Label userLogin;

    @FXML
    private Pane estimateLossesPane;

    @FXML
    private Pane viewSchedulePane;

    @FXML
    private TextField searchScheduleField;

    @FXML
    private TableView<ScheduleInf> scheduleTable;

    @FXML
    private TableColumn<ScheduleInf, Date> dateSchedule;

    @FXML
    private TableColumn<ScheduleInf, Time> timeSchedule;

    @FXML
    private TableColumn<ScheduleInf, String> movieTitleSchedule;

    @FXML
    private TableColumn<ScheduleInf, String> genreSchedule;

    @FXML
    private TableColumn<ScheduleInf, String> formatSchedule;

    @FXML
    private TableColumn<ScheduleInf, String> ageSchedule;

    @FXML
    private TableColumn<ScheduleInf, Double> priceSchedule;

    @FXML
    private Pane userPane;

    @FXML
    private Label dateTime;

    @FXML
    private Label moneyUser;

    @FXML
    private Label dateTime11;

    @FXML
    private Label userMail;

    @FXML
    private Label userTel;

    @FXML
    private Pane placesCinemaPane;

    @FXML
    private ScrollPane cinemaInfoPane;

    @FXML
    private TextArea paragraph1;

    @FXML
    private TextArea paragraph2;

    @FXML
    private TextArea paragraph3;

    @FXML
    private TextArea paragraph4;

    @FXML
    private Pane listMoviePane;

    @FXML
    private TableView<MovieInf> movieTable;

    @FXML
    private TableColumn<MovieInf, String> movieTitle;

    @FXML
    private TableColumn<MovieInf, Integer> productionYear;

    @FXML
    private TableColumn<MovieInf, String> country;

    @FXML
    private TableColumn<MovieInf, String> genre;

    @FXML
    private TableColumn<MovieInf, String> director;

    @FXML
    private TableColumn<MovieInf, String> age;

    @FXML
    private TableColumn<MovieInf, Integer> time;

    @FXML
    private TableColumn<MovieInf, String> description;

    @FXML
    private TableColumn<MovieInf, Integer> rating;

    @FXML
    private TextField searchMovieField;

    @FXML
    void initialize() {

        initClock();
        initUserInfo();
        initCinemaInfo();
        movieInTable();
        scheduleInTable();

        closeButton.setOnMouseClicked(mouseEvent -> {
            Stage stages = (Stage) closeButton.getScene().getWindow();
            stages.close();

        });

        hideButton.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) hideButton.getScene().getWindow();
            stage.setIconified(true);
        });

        backButton.setOnMouseClicked(mouseEvent -> {
            backButton.getScene().getWindow().hide();

            Connect.send("back");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/by/bsuir/coursework/view/authorization.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
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

    private void initUserInfo(){
        userLogin.setText(Connect.get());
        userMail.setText(Connect.get());
        userTel.setText(Connect.get());
    }

    private void initCinemaInfo(){
        String pf1;
        String pf2;
        String pf3;
        String pf4;

        pf1 = Connect.get();
        System.out.println(pf1);
        pf2 = Connect.get();
        pf3 = Connect.get();
        pf4 = Connect.get();
        System.out.println(pf4);

        paragraph1.setText(pf1);
        paragraph2.setText(pf2);
        paragraph3.setText(pf3);
        paragraph4.setText(pf4);
    }

    void movieInTable(){
        CollectionMovie.getInstance().fillData();
        setMovieInTable();
    }

    void setMovieInTable(){
        movieTitle.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        productionYear.setCellValueFactory(new PropertyValueFactory<>("productionYear"));
        country.setCellValueFactory(new PropertyValueFactory<>("country"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        director.setCellValueFactory(new PropertyValueFactory<>("director"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        movieTable.setItems(CollectionMovie.getInstance().getMovies());
    }

    void scheduleInTable(){
        CollectionSchedule.getInstance().fillData();
        setScheduleInTable();
    }

    void setScheduleInTable(){
        dateSchedule.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        timeSchedule.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        movieTitleSchedule.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        genreSchedule.setCellValueFactory(new PropertyValueFactory<>("genre"));
        formatSchedule.setCellValueFactory(new PropertyValueFactory<>("format"));
        ageSchedule.setCellValueFactory(new PropertyValueFactory<>("age"));
        priceSchedule.setCellValueFactory(new PropertyValueFactory<>("price"));
        scheduleTable.setItems(CollectionSchedule.getInstance().getSchedules());
    }

    @FXML
    void handleCliks(ActionEvent event) {
        if(event.getSource()==userButton){
            userPane.toFront();
        }
        else if(event.getSource()==listMovieButton){
            listMoviePane.toFront();
        }
        else if(event.getSource()==viewScheduleButton){
            viewSchedulePane.toFront();
        }
        else if(event.getSource()==cinemaInfoButton){
            cinemaInfoPane.toFront();
        }
    }

    @FXML
    void searchMovie(ActionEvent event) {

    }

    @FXML
    void searchSchedule(ActionEvent event) {

    }
}
