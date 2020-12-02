package by.bsuir.coursework.command;

import by.bsuir.coursework.connection.MonoThreadClientHandler;
import by.bsuir.coursework.database.DataBaseHandler;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Objects;

public abstract class AdminCommand extends MonoThreadClientHandler {

    public AdminCommand(Socket client) throws IOException {
        super(client);
    }

    public static void getUsersData() {
        DataBaseHandler handler = new DataBaseHandler();
        String users = handler.getUsers();
        try {
            send(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Objects.requireNonNull(get()));

        DataBaseHandler handler = new DataBaseHandler();

        handler.deleteUser(id);
    }

}
