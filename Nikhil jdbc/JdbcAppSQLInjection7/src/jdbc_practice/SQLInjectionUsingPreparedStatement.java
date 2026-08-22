package jdbc_practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public class SQLInjectionUsingPreparedStatement {

	private static final String SQL_SELECT_QUERY = "select count(*) from user where name = ? and password = ?";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try(Connection connection =DbUtil.getMySQLConnection()) {
			try(PreparedStatement statement = connection.prepareStatement(SQL_SELECT_QUERY)){
				
				System.out.print("Enter the username :: ");
				String name = scanner.next();
				
				System.out.print("Enter the password :: ");
				String password = scanner.next();
				
				statement.setString(1, name);
				statement.setString(2, password);
				
				System.out.println(SQL_SELECT_QUERY);
				
				try(ResultSet rs = statement.executeQuery()){
					 
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
