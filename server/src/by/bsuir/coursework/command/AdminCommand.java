package by.bsuir.coursework.command;

import by.bsuir.coursework.connection.MonoThreadClientHandler;
import by.bsuir.coursework.database.DataBaseHandler;

import java.io.IOException;
import java.net.Socket;

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
}
