package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public class TransactionApp {

	private static final String SQL_INSERT_QUERY = "insert into employees(ename,esal,eaddress) values(?,?,?)";

	public static void main(String[] args) {
		try (Connection cn =DbUtil.getMySQLConnection()){
			
			try (PreparedStatement st= cn.prepareStatement(SQL_INSERT_QUERY)){
				
				Scanner scanner =new Scanner(System.in);
				while(true) {
					System.out.println("enter employ name:");
					String ename = scanner.next();
					System.out.println("enter employ esal:");
					int esal = scanner.nextInt();
					System.out.println("enter employ address:");
					String eaddress = scanner.next();
					
					st.setString(1,ename);
					st.setInt(2,esal);
					st.setString(3,eaddress);
					
					st.addBatch();
					
					System.out.println();
					System.out.println("do you want another query yes no ??");
					String option =scanner.next();
					if (option.equalsIgnoreCase("no")) {
						break;
					}
				}
				
				
				int[] count = st.executeBatch();
				int updateCount = 0;
				for (int result : count) {
					 updateCount += result;
					
				}
				
				System.out.println("no of rows affected :"+updateCount);
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
