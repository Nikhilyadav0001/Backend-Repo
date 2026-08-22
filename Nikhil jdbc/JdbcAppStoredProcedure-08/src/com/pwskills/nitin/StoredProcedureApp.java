package com.pwskills.nitin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import com.pwksills.utility.JdbcUtil;

/*
 * 
DELIMITER $$

USE `pwskills_octbatch`$$

DROP PROCEDURE IF EXISTS `GET_PRODUCT_DETAILS_BY_PID`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `GET_PRODUCT_DETAILS_BY_PID`( 
									IN id INT, 
									
									OUT prodName VARCHAR(20),
									OUT rate FLOAT, 
                                    OUT qnt INT)
BEGIN
		SELECT pname,price,quantity 
		       INTO prodName,rate,qnt
			FROM
			  products
				WHERE pid = id;
	END$$

DELIMITER ;

 * 
 * 
 */

public class StoredProcedureApp {

	private static final String CALL_PROCEDURE_QUERY = "{call GET_PRODUCT_DETAILS_BY_PID(?,?,?,?)}";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int id = 0;
		if (scanner != null) {
			System.out.print("Enter the id of the product to be displayed:: ");
			id = scanner.nextInt();
		}

		try (Connection connection = JdbcUtil.getMySQLDBConection()) {
			System.out.println(connection);

			try (CallableStatement cst = connection.prepareCall(CALL_PROCEDURE_QUERY)) {

				// Setting the IN parameter value
				cst.setInt(1, id);
				System.out.println(cst);

				// Registering the OUT Parameter value
				cst.registerOutParameter(2, Types.VARCHAR);
				cst.registerOutParameter(3, Types.FLOAT);
				cst.registerOutParameter(4, Types.INTEGER);

				// running the StoredProcedure
				cst.execute();

				System.out.println(cst);

				// Getting the results from OUT Params
				System.out.println("PNAME :: " + cst.getString(2));
				System.out.println("PRICE :: " + cst.getFloat(3));
				System.out.println("QTY   :: " + cst.getInt(4));

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}
