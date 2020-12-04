package by.bsuir.coursework.connection;

import by.bsuir.coursework.command.AdminCommand;
import by.bsuir.coursework.command.BasicCommand;
import by.bsuir.coursework.command.CheckCommand;
import by.bsuir.coursework.database.DataBaseHandler;
import by.bsuir.coursework.database.Role;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Objects;

public class MonoThreadClientHandler implements Runnable {
    private static DataInputStream ois;
    private static DataOutputStream oos;
    private final Socket clientDialog;
    //DataOutputStream oos;
    //DataInputStream ois;

    public MonoThreadClientHandler(Socket client) throws IOException {
        clientDialog = client;
        oos = new DataOutputStream(clientDialog.getOutputStream());
        ois = new DataInputStream(clientDialog.getInputStream());
        System.out.println("New client connected");
    }

    public static void send(String message) throws IOException {
        oos.writeUTF(message);
        System.out.println("Отправил: " + message);
        oos.flush();
    }

    public static String get(){
        try {
            return ois.readUTF();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void run() {
        try{

            while (true) {
                String role = null;

                String command = get();
                System.out.println("Я принял: " + command);
                if(command == null || command.equals("exit")){
                    break;
                }
                switch (command){
                    case "authorization":{
                        role = BasicCommand.authorization();
                        break;
                    }
                    case "registration":{
                        BasicCommand.registration();
                        role = "USER";
                        break;
                    }
                    case "loginExist":{
                        CheckCommand.loginExist();
                        role = "null";
                        break;
                    }
                }
                switch (role){
                    case "ADMIN":{
                        openMenuAdmin();
                        break;
                    }
                    case "USER":{
                        break;
                    }
                    case "null":{
                        break;
                    }
                    default:break;
                }
            }


            oos.close();
            ois.close();
            clientDialog.close();

            System.out.println("Closing connections & channels - DONE.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openMenuAdmin(){
        String menu = "work";

       // DataBaseHandler handler = new DataBaseHandler();
        //String users = handler.getUsers();


        try {
            //send(users);
            AdminCommand.sendUsersData();
            AdminCommand.sendCinemaInfo();

            while (!Objects.equals(menu, "back")) {
                menu = get();
                System.out.println(menu);

                if (menu != null) {
                    switch (menu){
                        case "deleteUser":{
                            AdminCommand.deleteUser();
                            break;
                        }
                        case "updateCinemaInfo":{
                            AdminCommand.updateCInfo();
                            break;
                        }
                        case "addMovie":{
                            AdminCommand.addMovie();
                            break;
                        }
                        case "back": {
                            menu = "back";
                            break;
                        }

                    }
                }
                else break;
            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
