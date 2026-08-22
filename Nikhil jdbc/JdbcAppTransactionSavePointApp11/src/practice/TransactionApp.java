package practice;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import Utility_Classes.DbUtil;

public class TransactionApp {

	// Driver code
	public static void main(String[] args) {

		try (Connection connection = DbUtil.getMySQLConnection()) {

			try (Statement statement = connection.createStatement()) {

				// Disabling the autocommit feature
				connection.setAutoCommit(false);

				statement.executeUpdate("insert into politicians(`name`,`party`) values ('rahul','congress')");
				statement.executeUpdate("insert into politicians(`name`,`party`) values ('modi','bjp')");

				Savepoint sp = connection.setSavepoint();

				statement.executeUpdate("insert into politicians(`name`,`party`) values ('siddu','bjp')");
				
				System.out.println("Ooopsss Something went wrong, operations are rolleback to SavePoint");
				connection.rollback(sp);

				connection.commit();

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
