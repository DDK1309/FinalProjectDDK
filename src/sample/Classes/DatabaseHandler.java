package sample.Classes;

import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import  java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Config {
        static Connection connection = null;
        String url = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, dbUser, dbPass);
        return connection;
    }
    public void signupUser(User user){
        String insert = "INSERT INTO "  + "`"+ "projectbookmaker" + "`.`" + "users" + "` (`" + Const.USERS_FIRSTNAME + "`, `" +
                Const.USERS_LASTNAME + "`, `" + Const.USERS_USERNAME + "`, `"+Const.USERS_EMAIL+"`, `" + Const.USERS_PASSWORD  +
                 "`)"+" VALUES (?,?,?,?,?);";
        try {PreparedStatement prSt =getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getFirstname());
            prSt.setString(2,user.getLastname());
            prSt.setString(3,user.getUsername());
            prSt.setString(4,user.getEmail());
            prSt.setString(5,user.getPassword());
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM `" +"projectbookmaker" + "`.`" + "users" +"` WHERE (`" +
                Const.USERS_USERNAME+ "`=?) AND (`" +Const.USERS_PASSWORD+ "`=?);";
        try {PreparedStatement prSt =getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getUsername());
            prSt.setString(2,user.getPassword());

            resSet =prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }
}
