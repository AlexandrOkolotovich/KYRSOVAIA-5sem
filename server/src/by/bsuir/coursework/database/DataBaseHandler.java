package by.bsuir.coursework.database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.*;

public class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionSting="jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName  + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

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


}
