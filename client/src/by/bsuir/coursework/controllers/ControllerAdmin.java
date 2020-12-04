package by.bsuir.coursework.controllers;

import by.bsuir.coursework.collections.CollectionMovie;
import by.bsuir.coursework.collections.CollectionUsers;
import by.bsuir.coursework.collections.MovieInf;
import by.bsuir.coursework.collections.UserInf;
import by.bsuir.coursework.connection.Connect;
import by.bsuir.coursework.entity.Movie;
import by.bsuir.coursework.entity.Role;
import by.bsuir.coursework.entity.User;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.transformation.FilteredList;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FXML
    private TextField searchField;


    @FXML
    private Label userMail;

    @FXML
    private Label userTel;

    @FXML
    private Label userLogin;

    @FXML
    private TextArea paragraph1;

    @FXML
    private TextArea paragraph2;

    @FXML
    private TextArea paragraph3;

    @FXML
    private TextArea paragraph4;

    @FXML
    private ImageView backButton;

    @FXML
    protected TextField movieTitleField;

    @FXML
    protected TextField productionYearField;

    @FXML
    protected TextField countryField;

    @FXML
    protected TextField genreField;

    @FXML
    protected TextField directorField;

    @FXML
    protected TextField ageField;

    @FXML
    protected TextField timeField;

    @FXML
    protected TextArea descriptionArea;

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
    void searchUser(ActionEvent event) {
        FilteredList<UserInf> filterUsers;
        filterUsers = new FilteredList<>(CollectionUsers.getInstance().getUsers(), e->true);
        searchField.textProperty().addListener((observableValue, oldValue, newValue)->{
            filterUsers.setPredicate((UserInf user)->{

                String newVal = newValue.toLowerCase();
                return  user.getSurname().toLowerCase().contains(newVal)
                        || user.getName().toLowerCase().contains(newVal)
                        || user.getLogin().toLowerCase().contains(newVal)
                        || user.getTel().toLowerCase().contains(newVal)
                        || user.getEmail().toLowerCase().contains(newVal)
                        || user.getPassword().toLowerCase().contains(newVal);

            });
            userTable.setItems(filterUsers);
        });
    }

    @FXML
    void initialize() {

        initClock();
        initUserInfo();
        userInTable();
        initCinemaInfo();

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

    @FXML
    void updateCInfo(ActionEvent event) {
        Connect.send("updateCinemaInfo");

        String pf1;
        String pf2;
        String pf3;
        String pf4;

        pf1 = paragraph1.getText();
        pf2 = paragraph2.getText();
        pf3 = paragraph3.getText();
        pf4 = paragraph4.getText();

        Connect.send(pf1);
        Connect.send(pf2);
        Connect.send(pf3);
        Connect.send(pf4);

    }

    @FXML
    void addMovie(ActionEvent event) {
        boolean key = true;

        String movieTitle;
        String productionYear;
        String country;
        String genre;
        String director;
        String age;
        String time;
        String description;

        movieTitle = movieTitleField.getText();
        productionYear = productionYearField.getText();
        country = countryField.getText();
        genre = genreField.getText();
        director = directorField.getText();
        age = ageField.getText();
        time = timeField.getText();
        description = descriptionArea.getText();

        if (movieTitle.isEmpty() || movieTitle.length() > 45 ) {
            key = false;
        }
        if (productionYear.isEmpty() || productionYear.length() < 3 || productionYear.length() > 5 || !validateNum(productionYear)) {
            key = false;
        }
        if (country.isEmpty() || country.length() < 2 || country.length() > 35 || validateNum(country)) {
            key = false;
        }
        if (genre.isEmpty() || genre.length() < 3 || genre.length() > 30 || !validateString(genre)) {
            key = false;
        }
        if (director.isEmpty() || director.length() < 4 || director.length() > 32 || !validateString(director)) {
            key = false;
        }
        if (age.isEmpty() || age.length() > 5) {
            key = false;
        }
        if (time.isEmpty()  || time.length() > 4 || !validateNum(time)) {
            key = false;
        }
        if (description.isEmpty() || description.length() > 600) {
            key = false;
        }
        if(key){
            Connect.send("addMovie");
            Movie movie = new Movie( productionYear, country, genre, director, age, time);
            Connect.send(movieTitle);
            Connect.send(movie);
            Connect.send(description);

            fillInTableNewMovie();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успех");
            alert.setHeaderText("Фильм добавлен!");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Фильм не добавлен!");
            alert.showAndWait();
        }
    }

    void fillInTableNewMovie(){
        CollectionMovie.getInstance().fillNewData();
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

    @FXML
    void clearMovie(ActionEvent event) {
        movieTitleField.setText("");
        productionYearField.setText("");
        countryField.setText("");
        genreField.setText("");
        directorField.setText("");
        ageField.setText("");
        timeField.setText("");
        descriptionArea.setText("");
    }

    private boolean validateNum(String source) {
        Pattern pattern = Pattern.compile("^([0-9]+)$");
        Matcher matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateString(String source) {
        Pattern pattern = Pattern.compile("^([А-Я][а-я]+)$");
        Matcher matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }


}
