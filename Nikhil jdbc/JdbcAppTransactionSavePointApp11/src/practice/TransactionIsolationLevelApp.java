package practice;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import Utility_Classes.DbUtil;

public class TransactionIsolationLevelApp {

	// Driver code
	public static void main(String[] args) {

		try (Connection connection = DbUtil.getMySQLConnection()) {
			System.out.println(connection.getTransactionIsolation());
			connection.setTransactionIsolation(8);
			System.out.println(connection.getTransactionIsolation());

			
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
