package by.bsuir.coursework.command;

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

    public static void authorization() throws IOException {

        String login = get();
        String password = get();
        String role = null;

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
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(counter>=1){
            send(role);
            System.out.println(role);
        }
        else {
            send("incorrectly");
        }
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

        }
    }
}
