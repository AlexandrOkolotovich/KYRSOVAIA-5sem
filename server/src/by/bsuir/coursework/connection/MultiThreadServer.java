package by.bsuir.coursework.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    static ExecutorService executeSocket = Executors.newFixedThreadPool(2);

    //static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        // стартуем сервер на порту 3345 и инициализируем переменную для обработки консольных команд с самого сервера
        try {


            ServerSocket server = new ServerSocket(3345);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Server socket created, command console reader for listen to server commands/\nСокет создан, консольль готова к чтению команд\nСервер стартовал на порту 3345");
            executeSocket.execute(new AcceptSocket(server));
            // стартуем цикл при условии что серверный сокет не закрыт
            while (!server.isClosed()) {
                // проверяем поступившие комманды из консоли сервера если такие
                // были
                if (br.ready()) {
                    System.out.println("Main Server found any messages in channel, let's look at them.");
                    // если команда - quit то инициализируем закрытие сервера и
                    // выход из цикла раздачии нитей монопоточных серверов
                    String serverCommand = br.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...");
                        server.close();
                    }
                }

            }

            executeSocket.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
