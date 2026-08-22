package practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public class StoredProcedureApp2 {

	private static final String CALL_PROCEDURE_QUERY ="{call GET_PRODUCT_DETAILS_BY_NAME(?,?)} ";
	private static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = null;
		String s2 = null;
		
		if (sc != null) {
			System.out.println("enter the first product no:");
			s1= sc.next();
			System.out.println("enter the second product no:");
			s2= sc.next();
		}
		try (Connection cn= DbUtil.getMySQLConnection();){
			try(CallableStatement cst = cn.prepareCall(CALL_PROCEDURE_QUERY) ){
				cst.setString(1, s1);
				cst.setString(2, s2);
				
				cst.execute();
				System.out.println(cst);
				try(ResultSet rs = cst.getResultSet()){
					
					
					while (rs.next()) {
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
						flag = true;
					}
					System.out.println();
					if (flag) {
						System.out.println("record displayed;;");
					} else {
						System.out.println("no record");
					}
				}
				}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		e.printStackTrace();
	}
		sc.close();
		
	}

}
