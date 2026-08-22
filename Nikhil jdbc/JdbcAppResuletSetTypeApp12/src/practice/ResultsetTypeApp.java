package practice;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import Utility_Classes.DbUtil;

public class ResultsetTypeApp {

	// Driver code
	public static void main(String[] args) {

		try (Connection connection = DbUtil.getMySQLConnection()) {
			 try(Statement statement =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)){
				 
				 try(ResultSet rs= statement.executeQuery("select eid,ename,esal,eaddress from employees")){
					 System.out.println("resords in forword direction");
					 System.out.println("eid\tename\tesal\teaddress");
					 while(rs.next()) {
						 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
					 }
					 System.out.println("backword");
					 while(rs.previous()) {
						 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
					 }
					 System.out.println();
					 System.out.println("exploring the method of exploration");
					 rs.first();
					 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
				 
					 rs.last();
					 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
					 System.out.println();
					 
					 //working with abslute
					 
					 rs.first();
					 
					 rs.absolute(5);
					 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
				 
					 rs.absolute(-3);
					 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
					 
					 System.out.println();
					 
					 rs.absolute(4);
					 //curser is at 4
					 
					 System.out.println();
					 
					 rs.relative(3);
					 //relateve to curser 4+3=7
					 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
					 rs.relative(-2);
					 //relateve to curser 7-2=5
					 System.out.println(rs.getInt(1)+"\t"+ rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4) );
				 
					 System.out.println();
					 
					 rs.beforeFirst();
					 
					 System.out.println("is curser first:"+rs.isFirst());
					 System.out.println("is curser beforefirst:"+rs.isBeforeFirst());
					 System.out.println("is curser last:"+rs.isLast());
					 System.out.println("set to after last");
					 rs.afterLast();
					 System.out.println("is curser after last:"+rs.isAfterLast());
					 
				 
				 
				 
				 }
				 
				 
			 }
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
