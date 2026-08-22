package com.pwskills.nitin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pwksills.utility.JdbcUtil;

/*
 * 

Step1: Create a Storedprocedure to retrieve all the records with a particular name.

DELIMITER $$

CREATE
    PROCEDURE `pwskills_octbatch`.`GET_PRODUCT_DETAILS_BY_NAME`
   		(
			IN name1 VARCHAR(20),
			IN name2 VARCHAR(20)
		)
    
	BEGIN
	   SELECT pid,pname,price,quantity
	       FROM
	          products
	            WHERE pname IN (name1,name2);

	END$$

DELIMITER ;

Step2: CALL `GET_PRODUCT_DETAILS_BY_NAME`('fossil','armani');

 * 
 * 
 * 
 */

public class StoredProcedureApp02 {

	private static final String CALL_PROCEDURE_QUERY = "{call GET_PRODUCT_DETAILS_BY_NAME(?,?)}";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String prodName1 = null;
		String prodName2 = null;
		boolean flag = false;

		if (scanner != null) {
			System.out.print("Enter the name of the first Product:: ");
			prodName1 = scanner.next();

			System.out.print("Enter the name of the second Product:: ");
			prodName2 = scanner.next();

		}

		try (Connection connection = JdbcUtil.getMySQLDBConection()) {
			System.out.println(connection);

			try (CallableStatement cst = connection.prepareCall(CALL_PROCEDURE_QUERY)) {

				// Setting the IN parameter value
				cst.setString(1, prodName1);
				cst.setString(2, prodName2);
				System.out.println(cst);

				// running the StoredProcedure
				cst.execute();

				// Getting the result from CallableStatement
				try (ResultSet resultSet = cst.getResultSet()) {
					System.out.println("PID\tPNAME\tPRICE\tQTY");
					while (resultSet.next()) {
						System.out.print(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t"
								+ resultSet.getFloat(3) + "\t" + resultSet.getInt(4));
						flag = true;
						System.out.println();
					}
					if (flag) {
						System.out.println("Record found and displayed....");
					} else {
						System.out.println("Record not available to display...");
					}
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}
