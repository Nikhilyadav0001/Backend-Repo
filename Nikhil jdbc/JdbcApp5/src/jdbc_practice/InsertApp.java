package jdbc_practice;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Utility_Classes.DbUtil;


public class InsertApp {

    private static final String SQL_INSERT_QUERY = "INSERT INTO employee (ename,eaddress,resume) VALUES (?, ?, ?)";

	public static void main(String[] args) {

  
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Scanner scanner = new Scanner(System.in);
        int rowCount = 0; 

        try {
            // 1️⃣ Establish database connection
            connection = DbUtil.getDbConnection();

            if (connection != null) {
           
               preparedStatement =connection.prepareStatement(SQL_INSERT_QUERY);
            }
            if (preparedStatement!=null && scanner != null) {
				
                System.out.print("Enter emp name: ");
                String ename = scanner.next();
                System.out.print("Enter emp address: ");
                String eaddress = scanner.next();
                

                
                preparedStatement.setString(1,ename);
                preparedStatement.setString(2,eaddress);
                String location = "C:/Users/nikhi/Downloads/change.txt";
				preparedStatement.setCharacterStream(3,new FileReader(location));
                
                rowCount = preparedStatement.executeUpdate();
                
                if (rowCount == 0) {
					System.out.println("insersionfail");
				}else {
					System.out.println("no of rescord inserted is "+ rowCount);
				}
            }

        } catch (IOException | SQLException e) {
            System.err.println("Error occurred while inserting record:");
            e.printStackTrace();
        } finally {
    
            scanner.close();
            DbUtil.cleanUpResources(null, preparedStatement, connection);
        }
    }
}
