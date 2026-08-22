package practice;


import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import java.io.FileWriter;
import java.io.IOException;

import java.sql.SQLException;


public class WebRowSetApp {

	public static void main(String[] args) {
		WebRowSet webRowSet = null;
		FileWriter fileWriter = null;
		try {
		
			System.out.println("Start");

			RowSetFactory factory = RowSetProvider.newFactory();
			webRowSet = factory.createWebRowSet();

			webRowSet.setUrl("jdbc:mysql:///learn");
			webRowSet.setUsername("root");
			webRowSet.setPassword("nikhilhayatpur@123");

			webRowSet.setCommand("SELECT eid, ename, esal, eaddress FROM employees");

			System.out.println("Before execute()");
			webRowSet.execute();
			System.out.println("After execute()");

			fileWriter = new FileWriter("emp.xml");
			System.out.println("FileWriter created");

			webRowSet.writeXml(fileWriter);
			fileWriter.flush();

			System.out.println("XML written");

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (webRowSet != null) {
				try {
					webRowSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
