package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get Credentials from Database")
    public static List<String> getCredentials(String query) {
        List <String> credentials = new ArrayList<>();
        try {
            resultSet = statement.executeQuery(query);
            resultSet.next();
            credentials.add(resultSet.getString(1));
            credentials.add(resultSet.getString(2));
        } catch (Exception e) {
            System.out.println("Error Occurred While Printing Table Data" + e);
        }
        return credentials;
    }

    @Step("Get Number Of Rows in Database")
    public static int getNumberOfRowsInDB(String query) {
        int count = 0;
        try {
            resultSet = statement.executeQuery(query);
            resultSet.toString();
            resultSet.next();
            count = resultSet.getInt("Username");
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error Occurred While Counting Rows in DataBase:" + e);
        }
        return count;
    }

    @Step("Delete Rows in Database")
    public static void deleteRowsFromDB(String query) {
        try {
            statement.executeUpdate(query);
            System.out.println("Deleted successfully");
        } catch (SQLException e) {
            System.out.println("Error Occurred While Deleting Rows in DataBase:" + e);
        }
    }

    @Step("Insert Rows into Database")
    public static void insertRowsIntoDB(String query2) {
        String query = "INSERT INTO SauseDemoUsers (Username, Password, Details)" + query2;
        try {
            statement.execute(query);
            System.out.println("Added successfully");
        } catch (SQLException e) {
            System.out.println("Error Occurred While Adding Rows in DataBase:" + e);
        }
    }

}
