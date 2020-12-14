package by.bsuir.coursework.connection;

import by.bsuir.coursework.command.MainCommand;
import by.bsuir.coursework.command.BasicCommand;
import by.bsuir.coursework.command.CheckCommand;

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
            String start = get();
            System.out.println(start);

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
                        role = "null";
                        break;
                    }
                    case "loginExist":{
                        CheckCommand.loginExist();
                        role = "null";
                        break;
                    }
                    case "passwordRecovery":{
                        BasicCommand.passwordRecovery();
                        role = "null";
                        break;
                    }
                    case "getUserInfo":{
                        BasicCommand.getInfo();
                        role = "USER";
                        break;
                    }
                }
                switch (role){
                    case "ADMIN":{
                        openMenuAdmin();
                        break;
                    }
                    case "USER":{
                        openMenuUser();
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

            System.out.println("Closing connections & channels - DONE.\n Закрытие связи");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openMenuAdmin(){
        String menu = "work";

        try {

            MainCommand.sendUsersData();
            MainCommand.sendCinemaInfo();
            MainCommand.sendMoviesData();
            MainCommand.sendScheduleData();
            MainCommand.getUserId();
            MainCommand.getUserCash();

            while (!Objects.equals(menu, "back")) {
                menu = get();
                System.out.println(menu);

                if (menu != null) {
                    switch (menu){
                        case "deleteUser":{
                            MainCommand.deleteUser();
                            break;
                        }
                        case "updateCinemaInfo":{
                            MainCommand.updateCInfo();
                            break;
                        }
                        case "addMovie":{
                            MainCommand.addMovie();
                            break;
                        }
                        case "getNewMovie":{
                            MainCommand.getNewMovie();
                            break;
                        }
                        case "deleteMovie":{
                            MainCommand.deleteMovie();
                            break;
                        }
                        case "addMovieInSchedule":{
                            MainCommand.addMovieInSchedule();
                            break;
                        }
                        case "timeMatchCheck":{
                            CheckCommand.timeMatchCheck();
                            break;
                        }
                        case "getNewSchedule":{
                            MainCommand.getNewSchedule();
                            break;
                        }
                        case "deleteSchedule":{
                            MainCommand.deleteSchedule();
                            break;
                        }
                        case "occupedPlaces":{
                            MainCommand.getOccupedPlaces();
                            MainCommand.countOccupiedPl();
                            break;
                        }
                        case "calculateCloses":{
                            MainCommand.calculateCloses();
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

    private void openMenuUser(){
        String menu = "work";

        try {

            MainCommand.sendCinemaInfo();
            MainCommand.sendMoviesData();
            MainCommand.sendScheduleData();
            MainCommand.getUserId();
            MainCommand.getUserCash();

            while (!Objects.equals(menu, "back")) {
                menu = get();
                System.out.println(menu);

                if (menu != null) {
                    switch (menu){
                        case "buyTicket":{
                            MainCommand.buyTicket();
                            MainCommand.getNewTicket();
                            break;
                        }
                        case "getUserId":{
                            MainCommand.getUserId();
                            break;
                        }
                        case "makeOrder":{
                            MainCommand.makeOrder();
                            break;
                        }
                        case "occupedPlaces":{
                            MainCommand.getOccupedPlaces();
                            break;
                        }
                        case "pay":{
                            MainCommand.updateUserCash();
                            MainCommand.updateAdminCash();
                            break;
                        }
                        case "updateCash":{
                            MainCommand.getUserId();
                            MainCommand.updateUserCash();
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
