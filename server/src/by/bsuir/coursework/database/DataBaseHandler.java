package by.bsuir.coursework.database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;


public class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionSting="jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName  + "?serverTimezone=Europe/Minsk&useSSL=false";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection= DriverManager.getConnection(connectionSting, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String surname, String name, String login, String tel, String email,
                           String password, String role) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_SURNAME + "," + Const.USER_NAME + "," +
                Const.USER_LOGIN + "," + Const.USER_TEL + "," + Const.USER_EMAIL + "," + Const.USER_PASSWORD + "," +
                Const.USER_ROLE + ")" + "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, surname);
            prSt.setString(2, name);
            prSt.setString(3, login);
            prSt.setString(4, tel);
            prSt.setString(5, email);
            prSt.setString(6, password);
            prSt.setString(7, role);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet loginExist(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM "+ Const.USER_TABLE + " WHERE "+ Const.USER_LOGIN + "= ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return resSet;
    }

    public ResultSet signInUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM "+ Const.USER_TABLE + " WHERE "+ Const.USER_LOGIN + "= ? AND " + Const.USER_PASSWORD +
                "= ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return resSet;
    }

    public ResultSet passwordRecovery(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM "+ Const.USER_TABLE + " WHERE "+ Const.USER_EMAIL + "= ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getEmail());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getUser(String userLogin){
        ResultSet resSet = null;
        String select = "SELECT * FROM "+ Const.USER_TABLE + " WHERE "+ Const.USER_LOGIN + "= ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, userLogin);

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return resSet;
    }

    public String getUsers() {
        User user;
        JSONObject userJson;
        JSONArray users = new JSONArray();
        try {

            String select = "SELECT * FROM "+Const.USER_TABLE;
            PreparedStatement prep1 = getDbConnection().prepareStatement(select);
            ResultSet rs = prep1.executeQuery();
            while (rs.next()){

                user = new User();
                user.setId(rs.getInt(1));
                user.setSurname(rs.getString(2));
                user.setName(rs.getString(3));
                user.setLogin(rs.getString(4));
                user.setTel(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPassword(rs.getString(7));

                userJson = new JSONObject();
                userJson.put("id", user.getId());
                userJson.put("surname", user.getSurname());
                userJson.put("name", user.getName());
                userJson.put("login", user.getLogin());
                userJson.put("tel", user.getTel());
                userJson.put("email", user.getEmail());
                userJson.put("password", user.getPassword());

                users.put( userJson );
            }

        } catch (SQLException | ClassNotFoundException | JSONException e) {
            e.printStackTrace();
        }

        return users.toString();
    }

    public void deleteUser(Integer userId) throws SQLException, ClassNotFoundException {
        String deletion = "DELETE FROM " + Const.USER_TABLE+ " WHERE "+ Const.USER_ID +" = ?";
        PreparedStatement prSt=getDbConnection().prepareStatement(deletion);
        prSt.setInt(1,userId);
        prSt.executeUpdate();
    }

    public ResultSet getCinemaInfo(){
        ResultSet resSet = null;

        String select = "SELECT * FROM "+Const.CINEMAINFO_TABLE;

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();

            resSet.next();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return resSet;
    }

    public void updateCinemaInfo(String paragraph1, String paragraph2, String paragraph3, String paragraph4) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + Const.CINEMAINFO_TABLE + " SET " + Const.CINEMAINFO_PARAGRAPH1 +
                "= ?, " + Const.CINEMAINFO_PARAGRAPH2 + "= ?, " + Const.CINEMAINFO_PARAGRAPH3 +
                "= ?, " + Const.CINEMAINFO_PARAGRAPH4 + "=? " + "WHERE " + Const.CINEMAINFO_ID + " = ?";

        PreparedStatement prSt = getDbConnection().prepareStatement(update);

        prSt.setString(1, paragraph1);
        prSt.setString(2, paragraph2);
        prSt.setString(3, paragraph3);
        prSt.setString(4, paragraph4);
        prSt.setInt(5, 1);

        prSt.executeUpdate();
        prSt.close();
    }

    public void addNewMovie(String movieTitle, int productionYear, String country, String genre, String director,
                           String age, int time, String description) {
        String insert = "INSERT INTO " + Const.MOVIE_TABLE + "(" + Const.MOVIE_TITLE + "," + Const.MOVIE_YEAR + "," +
                Const.MOVIE_COUNTRY + "," + Const.MOVIE_GENRE + "," + Const.MOVIE_DIRECTOR + "," + Const.MOVIE_AGE + "," +
                Const.MOVIE_TIME + "," + Const.MOVIE_DESCRIPTION + ")" +
                "VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, movieTitle);
            prSt.setInt(2, productionYear);
            prSt.setString(3, country);
            prSt.setString(4, genre);
            prSt.setString(5, director);
            prSt.setString(6, age);
            prSt.setInt(7, time);
            prSt.setString(8, description);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getNewMovie(){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.MOVIE_TABLE + " ORDER BY " + Const.MOVIE_ID + " DESC LIMIT 1";

        try {
            PreparedStatement prSt  =  getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();

            resSet.next();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return resSet;
    }

    public String getMovies() {
        Movie movie;
        JSONObject movieJson;
        JSONArray movies = new JSONArray();
        try {
            String select = "SELECT * FROM "+Const.MOVIE_TABLE;
            PreparedStatement prep = getDbConnection().prepareStatement(select);
            ResultSet rs = prep.executeQuery();
            while (rs.next()){

                movie = new Movie();
                movie.setIdmovie(rs.getInt(1));
                movie.setMovieTitle(rs.getString(2));
                movie.setProductionYear(rs.getInt(3));
                movie.setCountry(rs.getString(4));
                movie.setGenre(rs.getString(5));
                movie.setDirector(rs.getString(6));
                movie.setAge(rs.getString(7));
                movie.setTime(rs.getInt(8));
                movie.setDescription(rs.getString(9));
                movie.setRating(rs.getInt(10));

                movieJson = new JSONObject();
                movieJson.put("idmovie", movie.getIdmovie());
                movieJson.put("movieTitle", movie.getMovieTitle());
                movieJson.put("productionYear", movie.getProductionYear());
                movieJson.put("country", movie.getCountry());
                movieJson.put("genre", movie.getGenre());
                movieJson.put("director", movie.getDirector());
                movieJson.put("age", movie.getAge());
                movieJson.put("time", movie.getTime());
                movieJson.put("description", movie.getDescription());
                movieJson.put("rating", movie.getRating());

                movies.put( movieJson );
            }

        } catch (SQLException | ClassNotFoundException | JSONException e) {
            e.printStackTrace();
        }

        return movies.toString();
    }

    public void deleteMovie(Integer movieId) throws SQLException, ClassNotFoundException {
        String deletion = "DELETE FROM " + Const.MOVIE_TABLE+ " WHERE "+ Const.MOVIE_ID +" = ?";
        PreparedStatement prSt=getDbConnection().prepareStatement(deletion);
        prSt.setInt(1,movieId);
        prSt.executeUpdate();
    }

    public void addNewMovieInSchedule(Schedule schedule){
        String insert = "INSERT INTO " + Const.SCHEDULE_TABLE + "(" + Const.SCHEDULE_MOVIE_ID + "," + Const.SCHEDULE_SESSION_DATE + "," +
                Const.SCHEDULE_SESSION_TIME + "," + Const.SCHEDULE_FORMAT + "," + Const.SCHEDULE_PRICE + ")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setInt(1, schedule.getMovie_idmovie());
            prSt.setDate(2, schedule.getSessionDate());
            prSt.setTime(3, schedule.getSessionTime());
            prSt.setString(4, schedule.getFormat());
            prSt.setDouble(5, schedule.getPrice());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet timeMatchExist(Schedule schedule){
        ResultSet resSet = null;
        String select = "SELECT * FROM "+ Const.SCHEDULE_TABLE + " WHERE "+ Const.SCHEDULE_SESSION_DATE + "= ? AND " + Const.SCHEDULE_SESSION_TIME +
                "= ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setDate(1, schedule.getSessionDate());
            prSt.setTime(2, schedule.getSessionTime());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getNewSchedule(){
        ResultSet resSet = null;

        String select = "SELECT " + Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_ID + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_SESSION_DATE + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_SESSION_TIME + ", " +
                Const.MOVIE_TABLE + "." + Const.MOVIE_TITLE + ", " +
                Const.MOVIE_TABLE + "." + Const.MOVIE_GENRE + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_FORMAT + ", " +
                Const.MOVIE_TABLE + "." + Const.MOVIE_AGE + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_PRICE +
                " FROM " + Const.SCHEDULE_TABLE + ", " + Const.MOVIE_TABLE +
                " WHERE " + Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_MOVIE_ID + "=" +
                Const.MOVIE_TABLE + "." + Const.MOVIE_ID +
                " ORDER BY "+ Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_ID + " DESC LIMIT 1";

        try {
            PreparedStatement prSt  =  getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();

            resSet.next();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return resSet;
    }

    public String getSchedule(){
        Schedule schedule;
        Movie movie;
        JSONObject scheduleJson;
        JSONArray schedules = new JSONArray();

        String select = "SELECT " + Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_ID + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_SESSION_DATE + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_SESSION_TIME + ", " +
                Const.MOVIE_TABLE + "." + Const.MOVIE_TITLE + ", " +
                Const.MOVIE_TABLE + "." + Const.MOVIE_GENRE + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_FORMAT + ", " +
                Const.MOVIE_TABLE + "." + Const.MOVIE_AGE + ", " +
                Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_PRICE +
                " FROM " + Const.SCHEDULE_TABLE + ", " + Const.MOVIE_TABLE +
                " WHERE " + Const.SCHEDULE_TABLE + "." + Const.SCHEDULE_MOVIE_ID + "=" +
                Const.MOVIE_TABLE + "." + Const.MOVIE_ID;

        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(select);

            ResultSet rs = prSt.executeQuery();

            while (rs.next()){
                schedule = new Schedule();
                movie = new Movie();

                schedule.setIdschedule(rs.getInt(1));
                schedule.setSessionDate(rs.getDate(2));
                schedule.setSessionTime(rs.getTime(3));
                movie.setMovieTitle(rs.getString(4));
                movie.setGenre(rs.getString(5));
                schedule.setFormat(rs.getString(6));
                movie.setAge(rs.getString(7));
                schedule.setPrice(rs.getDouble(8));

                scheduleJson = new JSONObject();
                scheduleJson.put("idschedule", schedule.getIdschedule());
                scheduleJson.put("sessionDate", schedule.getSessionDate());
                scheduleJson.put("sessionTime", schedule.getSessionTime());
                scheduleJson.put("movieTitle", movie.getMovieTitle());
                scheduleJson.put("genre", movie.getGenre());
                scheduleJson.put("format", schedule.getFormat());
                scheduleJson.put("age", movie.getAge());
                scheduleJson.put("price", schedule.getPrice());

                schedules.put( scheduleJson );
            }
        } catch (SQLException | ClassNotFoundException | JSONException e) {
            e.printStackTrace();
        }

        return schedules.toString();
    }

    public void deleteSchedule(Integer scheduleId) throws SQLException, ClassNotFoundException {
        String deletion = "DELETE FROM " + Const.SCHEDULE_TABLE+ " WHERE "+ Const.SCHEDULE_ID +" = ?";
        PreparedStatement prSt=getDbConnection().prepareStatement(deletion);
        prSt.setInt(1, scheduleId);
        prSt.executeUpdate();
    }

    public void addTicket(Ticket ticket){
        String insert = "INSERT INTO " + Const.TICKET_TABLE + "(" + Const.TICKET_SCHEDULE_ID + "," + Const.TICKET_ROW_NUMBER + "," +
                Const.TICKET_PLACE_NUMBER + ")" +
                "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setInt(1, ticket.getSchedule_idschedule());
            prSt.setInt(2, ticket.getRowNumber());
            prSt.setInt(3, ticket.getPlaceNumber());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet getNewTicket(){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.TICKET_TABLE + " ORDER BY " + Const.TICKET_ID + " DESC LIMIT 1";

        try {
            PreparedStatement prSt  =  getDbConnection().prepareStatement(select);

            resSet = prSt.executeQuery();

            resSet.next();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return resSet;
    }

    public void addOrder(Order order){
        String insert = "INSERT " + Const.ORDER_TABLE + "(" + Const.ORDER_USERS_ID + "," + Const.ORDER_TICKET_ID + "," +
                Const.ORDER_PAID + "," + Const.ORDER_BRON + ") " + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setInt(1, order.getUsers_id());
            prSt.setInt(2, order.getTicket_idticket());
            prSt.setString(3, order.getPaid());
            prSt.setString(4, order.getBron());


            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public String getOccupiedPlaces(int ticketScheduleId){
        Ticket ticket;
        JSONObject ticketJson;
        JSONArray tickets = new JSONArray();
        String select = "SELECT * FROM " + Const.TICKET_TABLE + " WHERE " + Const.TICKET_SCHEDULE_ID + "= ?";

        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(select);

            prSt.setInt(1, ticketScheduleId);

            ResultSet rs = prSt.executeQuery();

            while (rs.next()){
                ticket = new Ticket();

                ticket.setIdticket(rs.getInt(1));
                ticket.setSchedule_idschedule(rs.getInt(2));
                ticket.setRowNumber(rs.getInt(3));
                ticket.setPlaceNumber(rs.getInt(4));

                ticketJson = new JSONObject();
                ticketJson.put("idticket", ticket.getIdticket());
                ticketJson.put("schedule_idschedule", ticket.getSchedule_idschedule());
                ticketJson.put("rowNumber", ticket.getRowNumber());
                ticketJson.put("placeNumber", ticket.getPlaceNumber());

                tickets.put( ticketJson );
            }
        } catch (SQLException | ClassNotFoundException | JSONException e) {
            e.printStackTrace();
        }

        return tickets.toString();
    }

    public void openCashAccount(int userId, int cash){
        String insert = "INSERT " + Const.SOLVENCY_TABLE + "(" + Const.SOLVENCY_USERS_ID + "," + Const.SOLVENCY_CASH + ") " +
                "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setInt(1, userId);
            prSt.setInt(2, cash);

            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public ResultSet getUserCash(int userId){
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.SOLVENCY_TABLE + " WHERE " + Const.SOLVENCY_USERS_ID + "= ?";

        try {
            PreparedStatement prSt  =  getDbConnection().prepareStatement(select);

            prSt.setInt(1, userId);

            resSet = prSt.executeQuery();

            resSet.next();

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }

        return resSet;
    }

    public void updateBalance(Solvency solvency) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + Const.SOLVENCY_TABLE + " SET " + Const.SOLVENCY_CASH +
                "=? " + "WHERE " + Const.SOLVENCY_USERS_ID + " = ?";

        PreparedStatement prSt = getDbConnection().prepareStatement(update);

        prSt.setDouble(1, solvency.getCash());
        prSt.setInt(2, solvency.getUsers_id());

        prSt.executeUpdate();
        prSt.close();
    }


}
