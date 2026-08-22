package practice;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import Utility_Classes.DbUtil;

public class ResultsetTypeScrollUPDATABLE {

	// Driver code
	public static void main(String[] args) {

		try (Connection connection = DbUtil.getMySQLConnection()) {
			 try(Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
				 
				 try(ResultSet rs= statement.executeQuery("select eid,ename,esal,eaddress from employees")){
					 
					 while(rs.next()) {
						 //perform update
						 int salary= rs.getInt(3);
						 if (salary<25000) {
							 int incsal=salary+10000;
							 rs.updateInt(3, incsal);
							 rs.updateRow();
						 }
						 
						 System.out.println("record updated");
					 }
				 
				 }
				 
				 
			 }
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
