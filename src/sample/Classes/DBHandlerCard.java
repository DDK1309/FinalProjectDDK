package sample.Classes;

import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import  java.sql.SQLException;
import java.sql.ResultSet;

public class DBHandlerCard extends CardConfig{

    static Connection connection = null;
    String url = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, dbUser, dbPass);
        return connection;
    }
    public void saveCard(String number, String cvv, String nameofcard){
        String insert = "INSERT INTO "  + "`"+ "bankcards" + "`.`" + "infocards" + "` (`" + "number" + "`, `" +
                "cvv" + "`, `" + "nameofcard" +  "`)"+" VALUES (?,?,?);";
        try {PreparedStatement prSt =getDbConnection().prepareStatement(insert);
            prSt.setString(1,number);
            prSt.setString(2,cvv);
            prSt.setString(3,nameofcard);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
