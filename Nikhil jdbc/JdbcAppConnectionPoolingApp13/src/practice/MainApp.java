package practice;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utility_Classes.DbUtil;

public class MainApp {

	private static final String SQL_SELECT_QUERRY = "select * from employees";

	public static void main(String[] args) {
		try(Connection con = DbUtil.getMySQLConnection()) {
			try(Statement st = con.createStatement()){
				try(ResultSet rs = st.executeQuery(SQL_SELECT_QUERRY)){
					while(rs.next()) {
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4));
					}
				}
			}
			
		}catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
