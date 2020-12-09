package by.bsuir.coursework.controllers;

import by.bsuir.coursework.collections.*;
import by.bsuir.coursework.connection.Connect;
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
import javafx.scene.text.Text;
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
    private Text movieTitleText;

    @FXML
    private Text sessionPriceText;

    @FXML
    private Text movieDateText;

    @FXML
    private Text movieTimeText;

    @FXML
    private Button s11;

    @FXML
    private Button s12;

    @FXML
    private Button s13;

    @FXML
    private Button s14;

    @FXML
    private Button s15;

    @FXML
    private Button s16;

    @FXML
    private Button s17;

    @FXML
    private Button s18;

    @FXML
    private Button s19;

    @FXML
    private Button s110;

    @FXML
    private Button s21;

    @FXML
    private Button s22;

    @FXML
    private Button s23;

    @FXML
    private Button s24;

    @FXML
    private Button s25;

    @FXML
    private Button s26;

    @FXML
    private Button s27;

    @FXML
    private Button s28;

    @FXML
    private Button s29;

    @FXML
    private Button s210;

    @FXML
    private Button s31;

    @FXML
    private Button s32;

    @FXML
    private Button s33;

    @FXML
    private Button s34;

    @FXML
    private Button s35;

    @FXML
    private Button s36;

    @FXML
    private Button s37;

    @FXML
    private Button s38;

    @FXML
    private Button s39;

    @FXML
    private Button s310;

    @FXML
    private Button s41;

    @FXML
    private Button s42;

    @FXML
    private Button s43;

    @FXML
    private Button s44;

    @FXML
    private Button s45;

    @FXML
    private Button s46;

    @FXML
    private Button s47;

    @FXML
    private Button s48;

    @FXML
    private Button s49;

    @FXML
    private Button s410;

    @FXML
    private Button s51;

    @FXML
    private Button s52;

    @FXML
    private Button s53;

    @FXML
    private Button s54;

    @FXML
    private Button s55;

    @FXML
    private Button s56;

    @FXML
    private Button s57;

    @FXML
    private Button s58;

    @FXML
    private Button s59;

    @FXML
    private Button s510;

    @FXML
    private Button s61;

    @FXML
    private Button s62;

    @FXML
    private Button s63;

    @FXML
    private Button s64;

    @FXML
    private Button s65;

    @FXML
    private Button s66;

    @FXML
    private Button s67;

    @FXML
    private Button s68;

    @FXML
    private Button s69;

    @FXML
    private Button s610;

    @FXML
    private Button s71;

    @FXML
    private Button s72;

    @FXML
    private Button s73;

    @FXML
    private Button s74;

    @FXML
    private Button s75;

    @FXML
    private Button s76;

    @FXML
    private Button s77;

    @FXML
    private Button s78;

    @FXML
    private Button s79;

    @FXML
    private Button s710;

    @FXML
    private Button s81;

    @FXML
    private Button s82;

    @FXML
    private Button s83;

    @FXML
    private Button s84;

    @FXML
    private Button s85;

    @FXML
    private Button s86;

    @FXML
    private Button s87;

    @FXML
    private Button s88;

    @FXML
    private Button s89;

    @FXML
    private Button s810;

    @FXML
    private Button s91;

    @FXML
    private Button s92;

    @FXML
    private Button s93;

    @FXML
    private Button s94;

    @FXML
    private Button s95;

    @FXML
    private Button s96;

    @FXML
    private Button s97;

    @FXML
    private Button s98;

    @FXML
    private Button s99;

    @FXML
    private Button s910;

    @FXML
    private Text ticketMovieText;

    @FXML
    private Text ticketDateText;

    @FXML
    private Text ticketTimeText;

    @FXML
    private Text ticketRowText;

    @FXML
    private Text ticketPlaceText;

    @FXML
    private Text ticketPriceText;

    @FXML
    private Pane ticketPane;

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

    String userLoginName;

    private void initUserInfo(){
        userLoginName = Connect.get();

        userLogin.setText(userLoginName);
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
        FilteredList<MovieInf> filterMovie;
        filterMovie = new FilteredList<>(CollectionMovie.getInstance().getMovies(), e->true);
        searchMovieField.textProperty().addListener((observableValue, oldValue, newValue)->{
            filterMovie.setPredicate((MovieInf movie)->{

                String newVal = newValue.toLowerCase();
                return  movie.getMovieTitle().toLowerCase().contains(newVal)
                        || movie.getAge().toLowerCase().contains(newVal)
                        || movie.getDirector().toLowerCase().contains(newVal)
                        || movie.getGenre().toLowerCase().contains(newVal)
                        || movie.getProductionYear().toString().toLowerCase().contains(newVal)
                        || movie.getRating().toString().toLowerCase().contains(newVal)
                        || movie.getTime().toString().toLowerCase().contains(newVal)
                        || movie.getCountry().toLowerCase().contains(newVal);

            });
            movieTable.setItems(filterMovie);
        });
    }

    @FXML
    void searchSchedule(ActionEvent event) {
        FilteredList<ScheduleInf> filterSchedule;
        filterSchedule = new FilteredList<>(CollectionSchedule.getInstance().getSchedules(), e->true);
        searchScheduleField.textProperty().addListener((observableValue, oldValue, newValue)->{
            filterSchedule.setPredicate((ScheduleInf schedule)->{

                String newVal = newValue.toLowerCase();
                return  schedule.getMovieTitle().toLowerCase().contains(newVal)
                        || schedule.getAge().toLowerCase().contains(newVal)
                        || schedule.getFormat().toLowerCase().contains(newVal)
                        || schedule.getGenre().toLowerCase().contains(newVal)
                        || schedule.getPrice().toString().toLowerCase().contains(newVal)
                        || schedule.getSessionTime().toString().toLowerCase().contains(newVal)
                        || schedule.getSessionDate().toString().toLowerCase().contains(newVal);


            });
            scheduleTable.setItems(filterSchedule);
        });
    }

    @FXML
    void choosePlace(ActionEvent event) {
        placesCinemaPane.toFront();

        Connect.send("occupedPlaces");


        ScheduleInf selectedSchedule = (ScheduleInf) scheduleTable.getSelectionModel().getSelectedItem();

        movieTitleText.setText(selectedSchedule.getMovieTitle());
        sessionPriceText.setText(selectedSchedule.getPrice().toString());
        movieDateText.setText(selectedSchedule.getSessionDate().toString());
        movieTimeText.setText(selectedSchedule.getSessionTime().toString());

    }

    int row;
    int place;

    @FXML
    void seatSelection(ActionEvent event) {
        if(event.getSource()==s11){
            row = 1;
            place = 1;
        }
        else if(event.getSource()==s12){
            row = 1;
            place = 2;
        }
        else if(event.getSource()==s13){
            row = 1;
            place = 3;
        }
        else if(event.getSource()==s14){
            row = 1;
            place = 4;
        }
        else if(event.getSource()==s15){
            row = 1;
            place = 5;
        }
        else if(event.getSource()==s16){
            row = 1;
            place = 6;
        }
        else if(event.getSource()==s17){
            row = 1;
            place = 7;
        }
        else if(event.getSource()==s18){
            row = 1;
            place = 8;
        }
        else if(event.getSource()==s19){
            row = 1;
            place = 9;
        }
        else if(event.getSource()==s110){
            row = 1;
            place = 10;
        }
        else if(event.getSource()==s21){
            row = 2;
            place = 1;
        }
        else if(event.getSource()==s22){
            row = 2;
            place = 2;
        }
        else if(event.getSource()==s23){
            row = 2;
            place = 3;
        }
        else if(event.getSource()==s24){
            row = 2;
            place = 4;
        }
        else if(event.getSource()==s25){
            row = 2;
            place = 5;
        }
        else if(event.getSource()==s26){
            row = 2;
            place = 6;
        }
        else if(event.getSource()==s27){
            row = 2;
            place = 7;
        }
        else if(event.getSource()==s28){
            row = 2;
            place = 8;
        }
        else if(event.getSource()==s29){
            row = 2;
            place = 9;
        }
        else if(event.getSource()==s210){
            row = 2;
            place = 10;
        }
        else if(event.getSource()==s31){
            row = 3;
            place = 1;
        }
        else if(event.getSource()==s32){
            row = 3;
            place = 2;
        }
        else if(event.getSource()==s33){
            row = 3;
            place = 3;
        }
        else if(event.getSource()==s34){
            row = 3;
            place = 4;
        }
        else if(event.getSource()==s35){
            row = 3;
            place = 5;
        }
        else if(event.getSource()==s36){
            row = 3;
            place = 6;
        }
        else if(event.getSource()==s37){
            row = 3;
            place = 7;
        }
        else if(event.getSource()==s38){
            row = 3;
            place = 8;
        }
        else if(event.getSource()==s39){
            row = 3;
            place = 9;
        }
        else if(event.getSource()==s310){
            row = 3;
            place = 10;
        }
        else if(event.getSource()==s41){
            row = 4;
            place = 1;
        }
        else if(event.getSource()==s42){
            row = 4;
            place = 2;
        }
        else if(event.getSource()==s43){
            row = 4;
            place = 3;
        }
        else if(event.getSource()==s44){
            row = 4;
            place = 4;
        }
        else if(event.getSource()==s45){
            row = 4;
            place = 5;
        }
        else if(event.getSource()==s46){
            row = 4;
            place = 6;
        }
        else if(event.getSource()==s47){
            row = 4;
            place = 7;
        }
        else if(event.getSource()==s48){
            row = 4;
            place = 8;
        }
        else if(event.getSource()==s49){
            row = 4;
            place = 9;
        }
        else if(event.getSource()==s410){
            row = 4;
            place = 10;
        }
        else if(event.getSource()==s51){
            row = 5;
            place = 1;
        }
        else if(event.getSource()==s52){
            row = 5;
            place = 2;
        }
        else if(event.getSource()==s53){
            row = 5;
            place = 3;
        }
        else if(event.getSource()==s54){
            row = 5;
            place = 4;
        }
        else if(event.getSource()==s55){
            row = 5;
            place = 5;
        }
        else if(event.getSource()==s56){
            row = 5;
            place = 6;
        }
        else if(event.getSource()==s57){
            row = 5;
            place = 7;
        }
        else if(event.getSource()==s58){
            row = 5;
            place = 8;
        }
        else if(event.getSource()==s59){
            row = 5;
            place = 9;
        }
        else if(event.getSource()==s510){
            row = 5;
            place = 10;
        }
        else if(event.getSource()==s61){
            row = 6;
            place = 1;
        }
        else if(event.getSource()==s62){
            row = 6;
            place = 2;
        }
        else if(event.getSource()==s63){
            row = 6;
            place = 3;
        }
        else if(event.getSource()==s64){
            row = 6;
            place = 4;
        }
        else if(event.getSource()==s65){
            row = 6;
            place = 5;
        }
        else if(event.getSource()==s66){
            row = 6;
            place = 6;
        }
        else if(event.getSource()==s67){
            row = 6;
            place = 7;
        }
        else if(event.getSource()==s68){
            row = 6;
            place = 8;
        }
        else if(event.getSource()==s69){
            row = 6;
            place = 9;
        }
        else if(event.getSource()==s610){
            row = 6;
            place = 10;
        }
        else if(event.getSource()==s71){
            row = 7;
            place = 1;
        }
        else if(event.getSource()==s72){
            row = 7;
            place = 2;
        }
        else if(event.getSource()==s73){
            row = 7;
            place = 3;
        }
        else if(event.getSource()==s74){
            row = 7;
            place = 4;
        }
        else if(event.getSource()==s75){
            row = 7;
            place = 5;
        }
        else if(event.getSource()==s76){
            row = 7;
            place = 6;
        }
        else if(event.getSource()==s77){
            row = 7;
            place = 7;
        }
        else if(event.getSource()==s78){
            row = 7;
            place = 8;
        }
        else if(event.getSource()==s79){
            row = 7;
            place = 9;
        }
        else if(event.getSource()==s710){
            row = 7;
            place = 10;
        }
        else if(event.getSource()==s81){
            row = 8;
            place = 1;
        }
        else if(event.getSource()==s82){
            row = 8;
            place = 2;
        }
        else if(event.getSource()==s83){
            row = 8;
            place = 3;
        }
        else if(event.getSource()==s84){
            row = 8;
            place = 4;
        }
        else if(event.getSource()==s85){
            row = 8;
            place = 5;
        }
        else if(event.getSource()==s86){
            row = 8;
            place = 6;
        }
        else if(event.getSource()==s87){
            row = 8;
            place = 7;
        }
        else if(event.getSource()==s88){
            row = 8;
            place = 8;
        }
        else if(event.getSource()==s89){
            row = 8;
            place = 9;
        }
        else if(event.getSource()==s810){
            row = 8;
            place = 10;
        }
        else if(event.getSource()==s91){
            row = 91;
            place = 1;
        }
        else if(event.getSource()==s92){
            row = 9;
            place = 2;
        }
        else if(event.getSource()==s93){
            row = 9;
            place = 3;
        }
        else if(event.getSource()==s94){
            row = 9;
            place = 4;
        }
        else if(event.getSource()==s95){
            row = 9;
            place = 5;
        }
        else if(event.getSource()==s96){
            row = 9;
            place = 6;
        }
        else if(event.getSource()==s97){
            row = 9;
            place = 7;
        }
        else if(event.getSource()==s98){
            row = 9;
            place = 8;
        }
        else if(event.getSource()==s99){
            row = 9;
            place = 9;
        }
        else if(event.getSource()==s910){
            row = 9;
            place = 10;
        }
    }


    @FXML
    void openTicket(ActionEvent event) {
        ticketPane.toFront();

        ScheduleInf selectedSchedule = (ScheduleInf) scheduleTable.getSelectionModel().getSelectedItem();

        ticketMovieText.setText(selectedSchedule.getMovieTitle());
        ticketDateText.setText(selectedSchedule.getSessionDate().toString());
        ticketTimeText.setText(selectedSchedule.getSessionTime().toString());
        ticketRowText.setText(String.valueOf(row));
        ticketPlaceText.setText(String.valueOf(place));
        ticketPriceText.setText(selectedSchedule.getPrice().toString());
    }

    @FXML
    void buyTicket(ActionEvent event) {
        String paid = "Нет";
        String bron = "Да";

        Connect.send("buyTicket");

        ScheduleInf selectedSchedule = (ScheduleInf) scheduleTable.getSelectionModel().getSelectedItem();
        Integer idschedule = selectedSchedule.getIdschedule();
        Connect.send(idschedule);
        Connect.send(row);
        Connect.send(place);

        String idticket = Connect.get();

        Connect.send("getUserId");
        Connect.send(userLoginName);

        String iduser = Connect.get();

        Connect.send("makeOrder");
        Connect.send(iduser);
        Connect.send(idticket);
        Connect.send(paid);
        Connect.send(bron);
    }
}
