package jdbc_practice;

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

    private static final String SQL_INSERT_QUERY = "INSERT INTO users (username,dob) VALUES (?, ?)";

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
				
                System.out.print("Enter student user name: ");
                String username = scanner.next();

                System.out.print("Enter the dob: DD-mm-yyyy");
                String dob = scanner.next();
                
                preparedStatement.setString(1,username);
                preparedStatement.setDate(2,convertToSQLDate(dob));
                
                rowCount = preparedStatement.executeUpdate();
                
                if (rowCount == 0) {
					System.out.println("insersionfail");
				}else {
					System.out.println("no of rescord inserted is "+ rowCount);
				}
            }

        } catch (IOException | SQLException | ParseException e) {
            System.err.println("Error occurred while inserting record:");
            e.printStackTrace();
        } finally {
    
            scanner.close();
            DbUtil.cleanUpResources(null, preparedStatement, connection);
        }
    }

	private static Date convertToSQLDate(String dob) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date utilDate=sdf.parse(dob);
		long inputms = utilDate.getTime();
		java.sql.Date sqldate = new java.sql.Date(inputms);
		return sqldate;
	}
}
