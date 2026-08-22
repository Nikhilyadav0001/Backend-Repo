package practice;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Utility_Classes.DbUtil;

public class BatchSUpdateUsingStatementApp {

	public static void main(String[] args) {
		try (Connection cn =DbUtil.getMySQLConnection()){
			
			try (Statement st= cn.createStatement()){
				
				st.addBatch("insert into employees(ename,esal,eaddress) values('amit',34999,'rajisthan')");
				st.addBatch("update employees set esal = esal + 1000 where esal <30000");
				st.addBatch("DELETE FROM employees WHERE esal > 35000");
				
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
