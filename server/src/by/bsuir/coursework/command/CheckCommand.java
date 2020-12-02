package by.bsuir.coursework.command;

import by.bsuir.coursework.connection.MonoThreadClientHandler;
import by.bsuir.coursework.database.DataBaseHandler;
import by.bsuir.coursework.database.User;

import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CheckCommand extends MonoThreadClientHandler {
    public CheckCommand(Socket client) throws IOException {
        super(client);
    }

    public static void loginExist() throws IOException {
        String login = get();

        DataBaseHandler handler = new DataBaseHandler();
        User user = new User();
        user.setLogin(login);

        ResultSet result = handler.loginExist(user);

        int counter = 0;
        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        if(counter>=1){
            send("incorrectly");
        }
        else {
            send("correctly");
        }
    }

}
