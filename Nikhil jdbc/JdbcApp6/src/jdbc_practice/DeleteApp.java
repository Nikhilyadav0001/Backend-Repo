package jdbc_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public class DeleteApp {

    private static final String SQL_DELQUERY = "DELETE FROM student WHERE sid = ?";

	public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        int rowCount = 0;
        Scanner sc = new Scanner(System.in);

        try {
            connection = DbUtil.getMySQLConnection();

            if (connection != null) {
                statement = connection.prepareStatement(SQL_DELQUERY);
            }

            System.out.print("Enter student id to delete: ");
            int sid = sc.nextInt();
            statement.setInt(1, sid);

            if (statement != null) {
               
                rowCount = statement.executeUpdate();
            }

            if (rowCount == 0) {
                System.out.println("No record found with ID " + sid);
            } else {
                System.out.println("Record deleted successfully.");
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
            DbUtil.cleanUpResources(null, statement, connection);
        }
    }
}
