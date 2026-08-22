package practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public class StoredProcedureApp {

	private static final String CALL_PROCEDURE_QUERY ="{call GET_PRODUCT_DETAILS_BY_PID(?,?,?,?)} ";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id = 0;
		if (sc != null) {
			System.out.println("enter the product no:");
			id= sc.nextInt();
		}
		try (Connection cn= DbUtil.getMySQLConnection();){
			try(CallableStatement cst = cn.prepareCall(CALL_PROCEDURE_QUERY) ){
				
				//input for procedure
				cst.setInt(1, id);
				
				//output from procedure
				cst.registerOutParameter(2,Types.VARCHAR);
				cst.registerOutParameter(3,Types.FLOAT);
				cst.registerOutParameter(4,Types.INTEGER);
				
				cst.execute();
				
				System.out.println("pname :"+cst.getString(2)+ "\t "+"price:"+cst.getFloat(3) +"\t "+"quantity:"+cst.getInt(4)); 
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		e.printStackTrace();
	}
		sc.close();
		
	}

}
