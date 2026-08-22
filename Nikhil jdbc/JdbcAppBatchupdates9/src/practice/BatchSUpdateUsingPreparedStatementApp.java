package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public class BatchSUpdateUsingPreparedStatementApp {

	public static void main(String[] args) {
		try (Connection cn =DbUtil.getMySQLConnection()){
			
			try(Statement st = cn.createStatement()){
				try(ResultSet rs =st.executeQuery("select * from accounts")){
					System.out.println("data before transaction::");
					while(rs.next()) {
						System.out.println(rs.getString(1)+" "+ rs.getInt(2));
					}
				}
			
			System.out.println("*********transacltion begin*********");
			cn.setAutoCommit(false);
			
			st.executeUpdate("update accounts set balance = balance - 5000 where name='sachin'");
			st.executeUpdate("update accounts set balance = balance +5000 where name='dhoni'");
			Scanner sc = new Scanner(System.in);
			System.out.println("can u plese confurm the trasaction of 500{yes/no}");
			String option = sc.next();
			
			if (option.equalsIgnoreCase("yes")) {
				cn.commit();
				System.out.println("transtion commeted");
			}else {
				cn.rollback();
				System.out.println("transaction rollback");
			}
			try(ResultSet rs =st.executeQuery("select * from accounts")){
				System.out.println("data after transaction::");
				while(rs.next()) {
					System.out.println(rs.getString(1)+" "+ rs.getInt(2));
				}
			}
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
