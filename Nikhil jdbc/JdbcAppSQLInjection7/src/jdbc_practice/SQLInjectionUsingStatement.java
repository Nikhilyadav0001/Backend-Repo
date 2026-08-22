package jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public class SQLInjectionUsingStatement {

	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try(Connection connection =DbUtil.getMySQLConnection()) {
			try(Statement statement = connection.createStatement()){
				
				System.out.print("Enter the username :: ");
				String name = scanner.next();
				//name = "'" + name + "'";
				System.out.print("Enter the password :: ");
				String password = scanner.next();
				//password = "'" + password + "'";
				String sqlSelectQuery = "select count(*) from user where name=" + name + " and password="+ password + " ";
				
				//SELECT count(*) FROM user WHERE name='abc' AND password='' OR '1'='1'
				System.out.println(sqlSelectQuery);
				try(ResultSet rs = statement.executeQuery(sqlSelectQuery)){
					 
					int count =0;
					if (rs.next()) {
						count = rs.getInt(1);
					}
					
					if(count ==1) {
						System.out.println("valid :");
					}else {
						System.out.println("invalid cradiencials");
					}
				}
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		} 
		catch (Exception e) {
		    e.printStackTrace();
		}
	}

}





