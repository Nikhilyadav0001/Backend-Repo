package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPConfigrationApp {

	private static final String SQL_SELECT_QUERRY = "select * from employees";

	public static void main(String[] args) {
		//reusable connections using hikari cp
		HikariConfig config =  new HikariConfig("D:\\java files\\Nikhil jdbc\\JdbcAppConnectionPoolingApp13\\src\\Properties_Files\\HikariCp.properties");
		try(HikariDataSource dataSource =new HikariDataSource(config)){
			try(Connection connection =dataSource.getConnection()){
				try(Statement st = connection.createStatement()){
					try(ResultSet rs = st.executeQuery(SQL_SELECT_QUERRY)){
						while(rs.next()) {
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2) +"\t"+rs.getInt(3) +"\t"+rs.getString(4));
						}
					}
				}
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	

}
