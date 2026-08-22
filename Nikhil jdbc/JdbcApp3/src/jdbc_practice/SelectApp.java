package jdbc_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public final class SelectApp {

    private static final String SQLSELECTQUERY ="select DATE_FORMAT(from_days(datediff(now(),dob)),'%Y') as AGE from users where id = ?" ;

	public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // Get database connection from DbUtil
            connection = DbUtil.getDbConnection();


            // Create statement object
            if (connection != null) {
            	st = connection.prepareStatement(SQLSELECTQUERY);
            	System.out.println("Statement class: " + st.getClass().getName());
				
			}
            	Scanner sc = new Scanner(System.in);
            	
            	if (sc != null&& st !=null) {
            		
            		System.out.println("enter the user id ");
            		int id = sc.nextInt();	
            		
            		st.setInt(1, id);
            		
            		rs = st.executeQuery();
				}
            	
            	
            // Process the result
            System.out.println("ID\tUserName\tdob");
            System.out.println("--------------------------");

            if (rs.next()) {
				System.out.println("the age is:"+rs.getInt(1));
			} else {
				System.out.println("resoccd not found");
			}
            sc.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
        	
            DbUtil.cleanUpResources(rs, st, connection);
        }
    }

	private static String convertToString(Date date) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    return sdf.format(date);
	}

}
