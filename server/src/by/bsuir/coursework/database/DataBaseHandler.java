package by.bsuir.coursework.database;

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


}
