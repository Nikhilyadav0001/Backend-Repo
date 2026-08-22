package jdbc_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Utility_Classes.DbUtil;

/**
 * A simple program to insert a new student record into the database.
 * 
 * Steps:
 * 1. Connect to the database using DbUtil.
 * 2. Take user input for student ID, name, and address.
 * 3. Build and execute an SQL INSERT query.
 * 4. Display the result (success or failure).
 * 5. Close all resources safely.
 */
public class InsertApp {

    public static void main(String[] args) {

        // JDBC objects
        Connection connection = null;
        Statement statement = null;
        Scanner scanner = new Scanner(System.in);
        int rowCount = 0; // To store number of rows inserted

        try {
            // 1️ Establish database connection
            connection = DbUtil.getDbConnection();

            if (connection != null) {
                // 2️ Create a Statement object for executing SQL queries
                statement = connection.createStatement();

                // 3️ Take input from the user
                System.out.print("Enter student ID: ");
                int sid = scanner.nextInt();

                System.out.print("Enter student name: ");
                String sname = scanner.next();

                System.out.print("Enter student address: ");
                String saddress = scanner.next();

                // 4️ Build the SQL INSERT query
                // Note: Using String concatenation for simplicity (not recommended for real apps)
                String sqlInsertQuery = "INSERT INTO student VALUES(" + sid + ", '" + sname + "', '" + saddress + "')";

                // 5️ Execute the query
                rowCount = statement.executeUpdate(sqlInsertQuery);

                // 6️ Display the result
                if (rowCount > 0) {
                    System.out.println("\n✅ Record inserted successfully!");
                } else {
                    System.out.println("\n❌ Failed to insert record.");
                }
            }

        } catch (IOException | SQLException e) {
            System.err.println("Error occurred while inserting record:");
            e.printStackTrace();
        } finally {
            // 7️⃣ Always close resources
            scanner.close();
            DbUtil.cleanUpResources(null, statement, connection);
        }
    }
}
