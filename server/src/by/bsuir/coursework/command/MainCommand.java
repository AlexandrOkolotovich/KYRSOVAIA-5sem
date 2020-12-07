package by.bsuir.coursework.command;

import by.bsuir.coursework.connection.MonoThreadClientHandler;
import by.bsuir.coursework.database.DataBaseHandler;
import by.bsuir.coursework.database.Schedule;

import java.io.IOException;
import java.net.Socket;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Objects;

public abstract class MainCommand extends MonoThreadClientHandler {

    public MainCommand(Socket client) throws IOException {
        super(client);
    }

    public static void sendUsersData() {
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


    public static void sendCinemaInfo() throws SQLException, IOException {
        DataBaseHandler handler = new DataBaseHandler();
        ResultSet result = handler.getCinemaInfo();

        String paragraph1;
        String paragraph2;
        String paragraph3;
        String paragraph4;

        paragraph1 = result.getString(2);
        paragraph2 = result.getString(3);
        paragraph3 = result.getString(4);
        paragraph4 = result.getString(5);

        send(paragraph1);
        send(paragraph2);
        send(paragraph3);
        send(paragraph4);
    }

    public static void updateCInfo() throws SQLException, ClassNotFoundException {
        String paragraph1 = get();
        String paragraph2 = get();
        String paragraph3 = get();
        String paragraph4 = get();

        DataBaseHandler handler = new DataBaseHandler();
        handler.updateCinemaInfo(paragraph1, paragraph2, paragraph3, paragraph4);
    }

    public static void addMovie() {
        String movie;

        String movieTitle = get();
        movie = get();

        if (movie != null) {
            System.out.println("я получил фильм: " + movie);

            String[] s = movie.split(" ");
            String prodYear = s[0];
            int productionYear = Integer.parseInt(prodYear);
            String country = s[1];
            String genre = s[2];
            String director = s[3];
            String age = s[4];
            String t = s[5];
            int time = Integer.parseInt(t);
            String description = get();

            DataBaseHandler handler = new DataBaseHandler();
            handler.addNewMovie(movieTitle, productionYear, country, genre, director, age, time, description);
        }
    }

    public static void getNewMovie() throws SQLException, IOException {
        DataBaseHandler handler = new DataBaseHandler();
        ResultSet result = handler.getNewMovie();

        int id;
        String movieTitle;
        int productYear;
        String country;
        String genre;
        String director;
        String age;
        int t;
        String description;
        int r;

        id = result.getInt(1);
        String idmovie = String.valueOf(id);
        movieTitle = result.getString(2);
        productYear = result.getInt(3);
        String productionYear = String.valueOf(productYear);
        country = result.getString(4);
        genre = result.getString(5);
        director = result.getString(6);
        age = result.getString(7);
        t = result.getInt(8);
        String time = String.valueOf(t);
        description = result.getString(9);
        r = result.getInt(10);
        String rating = String.valueOf(r);

        send(idmovie);
        send(movieTitle);
        send(productionYear);
        send(country);
        send(genre);
        send(director);
        send(age);
        send(time);
        send(description);
        send(rating);

    }

    public static void sendMoviesData(){
        DataBaseHandler handler = new DataBaseHandler();
        String movies = handler.getMovies();
        try {
            send(movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMovie() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Objects.requireNonNull(get()));

        DataBaseHandler handler = new DataBaseHandler();

        handler.deleteMovie(id);
    }

    public static void addMovieInSchedule(){
        String idMovieSchedule = get();
        int movie_idmovie = Integer.parseInt(idMovieSchedule);
        String date = get();
        Date sessionDate = Date.valueOf(date);
        String time = get();
        time+=":00";
        Time sessionTime = Time.valueOf(time);
        String format = get();
        String p = get();
        Double price = Double.valueOf(p);

        DataBaseHandler handler = new DataBaseHandler();
        Schedule schedule = new Schedule(movie_idmovie, sessionDate, sessionTime, format, price);
        handler.addNewMovieInSchedule(schedule);
    }

    public static void getNewSchedule() throws SQLException, IOException {
        DataBaseHandler handler = new DataBaseHandler();
        ResultSet result = handler.getNewSchedule();

        int id;
        Date movieDate;
        Time movieTime;
        String movieTitle;
        String genre;
        String format;
        String age;
        double p;

        id = result.getInt(1);
        String idscedule = String.valueOf(id);
        movieDate = result.getDate(2);
        String sessionDate = String.valueOf(movieDate);
        movieTime = result.getTime(3);
        String sessionTime = String.valueOf(movieTime);
        movieTitle = result.getString(4);
        genre = result.getString(5);
        format = result.getString(6);
        age = result.getString(7);
        p = result.getDouble(8);
        String price = String.valueOf(p);

        send(idscedule);
        send(sessionDate);
        send(sessionTime);
        send(movieTitle);
        send(genre);
        send(format);
        send(age);
        send(price);
    }

    public static void sendScheduleData(){
        DataBaseHandler handler = new DataBaseHandler();
        String schedule = handler.getSchedule();
        try {
            send(schedule);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSchedule() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(Objects.requireNonNull(get()));

        DataBaseHandler handler = new DataBaseHandler();

        handler.deleteSchedule(id);
    }

}