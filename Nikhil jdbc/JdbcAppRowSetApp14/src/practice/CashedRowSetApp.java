package practice;

import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utility_Classes.DbUtil;

public class CashedRowSetApp {

	private static final String SQL_SELECT_QUERRY = "select * from employees";

	public static void main(String[] args) {
		CachedRowSet CachedRowSet = null;
		Connection CN = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			CN = DbUtil.getMySQLConnection();
			st=CN.createStatement();
			rs=st.executeQuery(SQL_SELECT_QUERRY);
			
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet = factory.createCachedRowSet();
			
			CachedRowSet.populate(rs);
			
			CN.close();
			System.out.println("Employee Details in Forward Direction...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (CachedRowSet.next()) {
				System.out.println(CachedRowSet.getInt(1) + "\t" + CachedRowSet.getString(2) + "\t" + CachedRowSet.getInt(3)
						+ "\t" + CachedRowSet.getString(4));
			}

			System.out.println();

			System.out.println("Employee Details in Backward Direction...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (CachedRowSet.previous()) {
				System.out.println(CachedRowSet.getInt(1) + "\t" + CachedRowSet.getString(2) + "\t" + CachedRowSet.getInt(3)
						+ "\t" + CachedRowSet.getString(4));
			}

			

			// placing the cursor to the begining of the table
			/*System.in.read();
			  jdbcRowSet.first();
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
			if (CachedRowSet != null) {
				try {
					CachedRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
