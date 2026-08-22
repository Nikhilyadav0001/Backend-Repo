package practice;

import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utility_Classes.DbUtil;

public class JoinRowSetApp {


	public static void main(String[] args) {
		JdbcRowSet jdbcRowSet = null;
		Connection cn = null;
		try {
			cn = DbUtil.getMySQLConnection();

			RowSetFactory factory = RowSetProvider.newFactory();

			CachedRowSet crs1 = factory.createCachedRowSet();
			crs1.setCommand("select * from student");
			crs1.execute(cn);

			CachedRowSet crs2 = factory.createCachedRowSet();
			crs2.setCommand("select * from course");
			crs2.execute(cn);

			JoinRowSet jrs = factory.createJoinRowSet();
			jrs.addRowSet(crs1, 4);
			jrs.addRowSet(crs2, 1);
			System.out.println("SID\tSNAME\tSADDR\tCID\tCNAME\tCCOST");
			System.out.println("-------------------------------------------------------");
			while (jrs.next()) {
				System.out.println(jrs.getString(1) + "\t" + jrs.getString(2) + "\t" + jrs.getString(3) + "\t"
						+ jrs.getString(4) + "\t" + jrs.getString(5) + "\t" + jrs.getString(6));
			}
			
			
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
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
