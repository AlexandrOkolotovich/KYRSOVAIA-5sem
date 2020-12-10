package by.bsuir.coursework.command;

import by.bsuir.coursework.connection.Email;
import by.bsuir.coursework.connection.MonoThreadClientHandler;
import by.bsuir.coursework.database.DataBaseHandler;
import by.bsuir.coursework.database.Role;
import by.bsuir.coursework.database.User;

import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BasicCommand extends MonoThreadClientHandler {

    public BasicCommand(Socket client) throws IOException {
        super(client);
    }

    public static String authorization() throws IOException {

        String login = get();
        String password = get();
        String role = null;
        String userLogin = null;
        String userEmail = null;
        String userTel = null;

        DataBaseHandler handler = new DataBaseHandler();
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        ResultSet result = handler.signInUser(user);

        int counter = 0;
        try {
            while (result.next()) {
                counter++;
                role = result.getNString(8);
                userLogin = result.getNString(4);
                userTel = result.getNString(5);
                userEmail = result.getNString(6);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(counter>=1){
            send(role);
            System.out.println(role);
            send(userLogin);
            send(userEmail);
            send(userTel);
        }
        else {
            send("incorrectly");
            role = "null";
        }

        return role;
    }

    public static void registration() {
        String user;

        user = get();

        if (user != null) {
            System.out.println("я получил: " + user);

            String[] s = user.split(" ");
            String surname = s[0];
            String name = s[1];
            String login = s[2];
            String tel = s[3];
            String email = s[4];
            String password = s[5];
            String role = s[6];
            DataBaseHandler handler = new DataBaseHandler();
            handler.signUpUser(surname, name, login, tel, email, password, role);

            ResultSet result = handler.getUser(login);
            String userId = null;
            int counter = 0;

            try {
                while (result.next()) {
                    counter++;
                    userId = result.getString(1);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            if(counter>=1){
                int uid = Integer.parseInt(userId);

                handler.openCashAccount(uid, 0);
            }


        }
    }

    public static void passwordRecovery(){
        String email = get();
        String login = null;
        String password = null;

        DataBaseHandler handler = new DataBaseHandler();
        User user = new User();
        user.setEmail(email);

        ResultSet result = handler.passwordRecovery(user);

        int counter = 0;
        try {
            while (result.next()) {
                counter++;
                login = result.getNString(4);
                password = result.getNString(7);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(counter>=1){
            Email.mail(email, login, password);
        }

    }
}
