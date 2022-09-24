package utilities;

import java.sql.*;

public class ManageDataBase extends CommonOps{

    public static void openConnection(String dbUrl, String user, String pass){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, user, pass);
            statement = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred While Connecting to DataBase" + e);
        }
    }

    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred While Closing DataBase" + e);
        }
    }

}
