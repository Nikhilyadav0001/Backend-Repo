package practice;

import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utility_Classes.DbUtil;

public class JdbcRowSetApp {

	private static final String SQL_SELECT_QUERRY = "select * from employees";

	public static void main(String[] args) {
		JdbcRowSet jdbcRowSet = null;
		try {
			RowSetFactory factory = RowSetProvider.newFactory();

			// Connection based rowSet
			jdbcRowSet = factory.createJdbcRowSet();
			jdbcRowSet.setUrl("jdbc:mysql:///learn");
			jdbcRowSet.setUsername("root");
			jdbcRowSet.setPassword("nikhilhayatpur@123");

			jdbcRowSet.setCommand("select eid,ename,esal,eaddress from employees");
			jdbcRowSet.execute();

			System.out.println("Employee Details in Forward Direction...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (jdbcRowSet.next()) {
				System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getInt(3)
						+ "\t" + jdbcRowSet.getString(4));
			}

			System.out.println();

			System.out.println("Employee Details in Backward Direction...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (jdbcRowSet.previous()) {
				System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getInt(3)
						+ "\t" + jdbcRowSet.getString(4));
			}

			System.in.read();

			// placing the cursor to the begining of the table
			/*jdbcRowSet.first();
			while (jdbcRowSet.next()) {

				int dbEsal = jdbcRowSet.getInt(3);
				if (dbEsal < 32000) {
					jdbcRowSet.deleteRow();
				}
			}*/
			System.out.println("Records deleted succesfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (jdbcRowSet != null) {
				try {
					jdbcRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
