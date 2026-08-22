package practice;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import Utility_Classes.DbUtil;

public class ResultsetTypeScrollSencitive {

	// Driver code
	public static void main(String[] args) {

		try (Connection connection = DbUtil.getMySQLConnection()) {
			 try(Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
				 
				 try(ResultSet rs= statement.executeQuery("select eid,ename,esal,eaddress from employees")){
					 
					 System.out.println("rescord vefore updating");
					 
					 System.out.println("eid\tename\tesal\teaddress");
					 while(rs.next()) {
						 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
					 }
					
					 System.out.println();
					 
					 System.out.println("applicaion is in pause state ,plesseupdate the database");
					 System.in.read();
					 
					 rs.beforeFirst();
					 System.out.println("rescord after updating");
					 
					 System.out.println("eid\tename\tesal\teaddress");
					 while(rs.next()) {
						 rs.refreshRow();
						 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
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
