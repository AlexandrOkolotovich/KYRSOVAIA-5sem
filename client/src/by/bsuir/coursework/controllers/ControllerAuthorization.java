package by.bsuir.coursework.controllers;

import by.bsuir.coursework.connection.Connect;
import by.bsuir.coursework.entity.Role;
import by.bsuir.coursework.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerAuthorization {

    @FXML
    private ImageView closeButton;

    @FXML
    private ImageView hideButton;

    @FXML
    private Pane signUpPane;

    @FXML
    private Pane signInPane;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordText;

    @FXML
    private TextField signUpSurname;

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpLogin;

    @FXML
    private TextField signUpTel;

    @FXML
    private TextField signUpEmail;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private PasswordField signUpRepass;

    @FXML
    private ImageView eyeImage;

    private boolean isEye = false;

    @FXML
    private Text errorText;

    @FXML
    private Button signInButton;

    @FXML
    private Pane recoveryPane;

    @FXML
    private TextField mailForRecoveryField;

    @FXML
    void signUpLink() {
        signUpPane.toFront();
    }

    @FXML
    void signInLink() {
        signInPane.toFront();
    }

    @FXML
    void recoveryLink() {
        recoveryPane.toFront();
    }

    @FXML
    void sendMailForRecovery(ActionEvent event) {
        boolean key = true;

        String email = mailForRecoveryField.getText();

        if (email.isEmpty() || email.length() < 4 || email.length() > 32 || !checkMail(email)) {
            key = false;
        }
        if(key){
            Connect.send("passwordRecovery");
            Connect.send(email);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успех");
            alert.setHeaderText("Логин и пароль отправлены на почту!");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверно введён пароль!");
            alert.showAndWait();
        }
    }

    public void signIn(ActionEvent actionEvent) throws IOException {
        String login = loginField.getText();
        String password = passwordField.getText();
        String role;

        Connect.send("authorization");
        Connect.send(login);
        Connect.send(password);
        role = Connect.get();
        System.out.println(role);

        if (role != null && role.equals("ADMIN")) {
            openScene("/by/bsuir/coursework/view/sceneAdmin.fxml");
        }
        if (role != null && role.equals("USER")) {
            openScene("/by/bsuir/coursework/view/sceneUser.fxml");
        }
        if (role != null && role.equals("incorrectly")) {
            errorText.setVisible(true);
            errorText.setText("Неверно введен логин или пароль!");
        }

    }

    private void openScene(String directory) throws IOException {
        signInButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(directory));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setX(110);
        stage.setY(40);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @FXML
    void clickEye(MouseEvent event) {
        if(isEye) {
            eyeImage.setImage(new Image("by/bsuir/coursework/resource/img/closed_eye.png"));
            passwordField.setVisible(true);
            passwordText.setVisible(false);
            passwordField.setText(passwordText.getText());
            isEye = false;
        }
        else{
            eyeImage.setImage(new Image("by/bsuir/coursework/resource/img/eye.png"));
            passwordField.setVisible(false);
            passwordText.setVisible(true);
            passwordText.setText(passwordField.getText());
            isEye = true;
        }
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {

        boolean key = true;
        String alertText = "";

        String surname = signUpSurname.getText();
        String name = signUpName.getText();
        String login = signUpLogin.getText();
        String tel = signUpTel.getText();
        String email = signUpEmail.getText();
        String password = signUpPassword.getText();
        String repass = signUpRepass.getText();

        if (surname.isEmpty() || surname.length() < 2 || surname.length() > 12 || !checkName(surname)) {
            key = false;
            alertText = "Ошибка при вводе фамилии!\n";
        }
        if (name.isEmpty() || name.length() < 2 || name.length() > 12 || !checkName(name)) {
            key = false;
            alertText = "Ошибка при вводе имени!\n";
        }
        if (login.isEmpty() || login.length() < 4 || login.length() > 12 || !checkUserName(login) ||
            loginExist(login)) {
            key = false;
            alertText = "Ошибка при вводе логина!\n";
        }
        if (tel.isEmpty() || tel.length() < 12 || tel.length() > 14 || !checkTel(tel)) {
            key = false;
            alertText = "Ошибка при вводе номера телефона!\n";
        }
        if (email.isEmpty() || email.length() < 4 || email.length() > 32 || !checkMail(email)) {
            key = false;
            alertText = "Ошибка при вводе электронной почты!\n";
        }
        if (password.isEmpty() || password.length() < 4 || password.length() > 12) {
            key = false;
            alertText = "Ошибка при вводе пароля!\n";
        }
        if (!repass.equals(password)){
            key = false;
            alertText = "Пароли не совпадают!\n";
        }
        if(key){
            Connect.send("registration");
            User user = new User(surname, name, login, tel, email, password, Role.USER);
            Connect.send(user);
            Connect.send("getUserInfo");
            Connect.send(login);
            openScene("/by/bsuir/coursework/view/sceneUser.fxml");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(alertText);
            alert.showAndWait();
        }

    }

    private boolean checkMail(String source) {
        Pattern pattern = Pattern.compile("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkTel(String source) {
        Pattern pattern = Pattern.compile("^((\\+375)(29|44|33|25))[\\d]{7}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkName(String source) {
        Pattern pattern = Pattern.compile("^([А-Я][а-я]+)$");
        Matcher matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkUserName(String source) {
        Pattern pattern = Pattern.compile("^([A-z0-9_\\.-]+)$");
        Matcher matcher = pattern.matcher(source);

        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean loginExist(String source){
        Connect.send("loginExist");
        Connect.send(source);
        if(Objects.equals(Connect.get(), "incorrectly")){
            return true;
        }else {
            return false;
        }
    }

    @FXML
    void initialize() {
        Connect.send("start");

        errorText.setVisible(false);

        passwordField.textProperty().addListener( (ov,oldV,newV) -> {
            if (!newV.trim().isEmpty())
                eyeImage.setVisible(true);
            else
                eyeImage.setVisible(false);
        });

        passwordText.textProperty().addListener( (ov,oldV,newV) -> {
            if (!newV.trim().isEmpty())
                eyeImage.setVisible(true);
            else
                eyeImage.setVisible(false);
        });

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
