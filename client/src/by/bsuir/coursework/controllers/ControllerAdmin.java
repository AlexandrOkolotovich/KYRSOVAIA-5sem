package by.bsuir.coursework.controllers;

import by.bsuir.coursework.collections.*;
import by.bsuir.coursework.connection.Connect;
import by.bsuir.coursework.entity.Movie;
import by.bsuir.coursework.entity.Role;
import by.bsuir.coursework.entity.User;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
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
    private TextField movieTitleField;

    @FXML
    private TextField productionYearField;

    @FXML
    private TextField countryField;

    @FXML
    private TextField genreField;

    @FXML
    private TextField directorField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField timeField;

    @FXML
    private TextArea descriptionArea;

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
    private DatePicker dateField;

    javafx.util.Callback<DatePicker, DateCell> callB = new javafx.util.Callback<DatePicker, DateCell>() {
        @Override
        public DateCell call(final DatePicker param) {
            return new DateCell() {
                @Override
                public void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    LocalDate today = LocalDate.now();
                    setDisable(empty || item.compareTo(today) < 0);
                }

            };
        }

    };


    @FXML
    private TableView<MovieInf> movieScheduleTable;

    @FXML
    private TableColumn<MovieInf, String> movieSchedule;

    @FXML
    private TextField searchMovieScheduleField;

    @FXML
    private ComboBox<String> timeComboBox;

    ObservableList<String> timeList = FXCollections.observableArrayList("08:00", "11:00", "13:00", "15:00", "17:00", "19:00", "21:00", "23:00", "01:00");//еще добавить

    @FXML
    private ComboBox<String> formatComboBox;

    ObservableList<String> formatList = FXCollections.observableArrayList("3D", "2D");

    @FXML
    private TextField priceField;

    @FXML
    private TableView<ScheduleInf> scheduleLittleTable;

    @FXML
    private TableColumn<ScheduleInf, Date> dateScheduleLittle;

    @FXML
    private TableColumn<ScheduleInf, Time> timeScheduleLittle;

    @FXML
    private TableColumn<ScheduleInf, String> movieScheduleLittle;

    @FXML
    private TableColumn<ScheduleInf, Double> priceScheduleLittle;

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
        movieInTable();
        scheduleInTable();


        timeComboBox.setItems(timeList);
        formatComboBox.setItems(formatList);

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

        dateField.setDayCellFactory(callB);

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
        Connect.send("getNewMovie");

        CollectionMovie.getInstance().fillNewData();
        setMovieInTable();
        initMovieScheduleTable();
    }

    void movieInTable(){
        CollectionMovie.getInstance().fillData();
        setMovieInTable();
        initMovieScheduleTable();
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

    void initMovieScheduleTable(){
        movieSchedule.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        movieScheduleTable.setItems(CollectionMovie.getInstance().getMovies());
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

    @FXML
    void deleteMovie(ActionEvent event) {
        MovieInf selectedMovie = (MovieInf) movieTable.getSelectionModel().getSelectedItem();
        CollectionMovie.getInstance().delete(selectedMovie);
        Connect.send("deleteMovie");
        Connect.send(selectedMovie.getIdmovie());
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

    private boolean validatePrice(String source) {
        Pattern pattern = Pattern.compile("^[0-9]+\\.[0-9]{1,2}$");
        Matcher matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    @FXML
    void addMovieInSchedule(ActionEvent event) {
        boolean key = true;
        String alertString = "Фильм не добавлен в расписание!\n";

        LocalDate movieDate = dateField.getValue();
        String sessionDate = movieDate.toString();
        MovieInf selectedMovie = (MovieInf) movieScheduleTable.getSelectionModel().getSelectedItem();
        String movieIdSchedule = String.valueOf(selectedMovie.getIdmovie());
        String sessionTime = timeComboBox.getValue();
        String format = formatComboBox.getValue();
        String price = priceField.getText();
        
        if (sessionDate.isEmpty()) {
            key = false;
            alertString+= "Не выбрана дата!\n";
        }
        if (movieIdSchedule.isEmpty()) {
            key = false;
            alertString+= "Не выбран фильм!\n";
        }
        if (sessionTime.isEmpty()) {
            key = false;
            alertString+= "Не выбрано время!\n";
        }
        if (format.isEmpty()) {//потом попробовать закоментить так как в бд стоит null
            key = false;
            alertString+= "Не выбран формат!\n";
        }
        if (price.isEmpty()  || price.length() > 4 || !validatePrice(price)) {
            key = false;
            alertString+= "Неверный ввод цены!\n";
        }
        if(timeMatchCheck()){
            key = false;
            alertString+= "В этот день и это время уже стоит фильм!\n";
        }
        if(key){
            Connect.send("addMovieInSchedule");
            Connect.send(movieIdSchedule);
            Connect.send(sessionDate);
            Connect.send(sessionTime);
            Connect.send(format);
            Connect.send(price);

            fillInTableNewSchedule();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успех");
            alert.setHeaderText("Фильм добавлен в расписание!");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(alertString);
            alert.showAndWait();
        }
    }

    boolean timeMatchCheck(){
        Connect.send("timeMatchCheck");

        LocalDate movieDate = dateField.getValue();
        String sessionDate = movieDate.toString();
        String sessionTime = timeComboBox.getValue();
        Connect.send(sessionDate);
        Connect.send(sessionTime);

        return Objects.equals(Connect.get(), "incorrectly");

    }

    void fillInTableNewSchedule(){
        Connect.send("getNewSchedule");

        CollectionSchedule.getInstance().fillNewData();
        setScheduleInTable();
        setScheduleInLittleTable();
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

    void setScheduleInLittleTable(){
        dateScheduleLittle.setCellValueFactory(new PropertyValueFactory<>("sessionDate"));
        timeScheduleLittle.setCellValueFactory(new PropertyValueFactory<>("sessionTime"));
        movieScheduleLittle.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        priceScheduleLittle.setCellValueFactory(new PropertyValueFactory<>("price"));
        scheduleLittleTable.setItems(CollectionSchedule.getInstance().getSchedules());

    }

    @FXML
    void searchMovieSchedule(ActionEvent event) {
        FilteredList<MovieInf> filterMovieSchedule;
        filterMovieSchedule = new FilteredList<>(CollectionMovie.getInstance().getMovies(), e->true);
        searchMovieScheduleField.textProperty().addListener((observableValue, oldValue, newValue)->{
            filterMovieSchedule.setPredicate((MovieInf movie)->{

                String newVal = newValue.toLowerCase();
                return  movie.getMovieTitle().toLowerCase().contains(newVal);

            });
            movieScheduleTable.setItems(filterMovieSchedule);
        });
    }

    void scheduleInTable(){
        CollectionSchedule.getInstance().fillData();
        setScheduleInTable();
        setScheduleInLittleTable();
    }


}
