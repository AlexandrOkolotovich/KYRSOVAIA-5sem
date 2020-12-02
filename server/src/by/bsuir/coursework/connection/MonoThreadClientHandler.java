package by.bsuir.coursework.connection;

import by.bsuir.coursework.command.AdminCommand;
import by.bsuir.coursework.command.BasicCommand;
import by.bsuir.coursework.command.CheckCommand;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
                String command = get();
                System.out.println("Я принял: " + command);
                if(command == null || command.equals("exit")){
                    break;
                }
                switch (command){
                    case "authorization":{
                        BasicCommand.authorization();
                        break;
                    }
                    case "registration":{
                        BasicCommand.registration();
                        break;
                    }
                    case "loginExist":{
                        CheckCommand.loginExit();
                        break;
                    }
                    case "adminPanel":{
                        AdminCommand.getUsersData();
                        break;
                    }
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
}
