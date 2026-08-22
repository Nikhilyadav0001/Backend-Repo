package jdbc_practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import Utility_Classes.DbUtil;

public final class SelectApp {

	private static final String SQLSELECTQUERY = "SELECT sno,accno, holdername,balance FROM canarabank";


	public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Get database connection from DbUtil
            connection = DbUtil.getMySQLConnection();


            // Create statement object
            if (connection != null) {
            	st = connection.createStatement();
            	System.out.println("Statement class: " + st.getClass().getName());
				
			}
            	
            	if ( st !=null) {
            		
            		
            		rs = st.executeQuery(SQLSELECTQUERY);
				}
            	
            	
            // Process the result
            System.out.println("sno\taccno\tholdername\tbalace");
            System.out.println("--------------------------");

            if (rs.next()) {
            	
            	System.out.println(rs.getInt(1) + "\t" +
            	rs.getInt(2) + "\t" + rs.getString(3)
            	+ "\t" + rs.getFloat(4));
			} else {
				System.out.println("resoccd not found");
				}
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
        	
            DbUtil.cleanUpResources(rs, st, connection);
        }
    }

	
}
