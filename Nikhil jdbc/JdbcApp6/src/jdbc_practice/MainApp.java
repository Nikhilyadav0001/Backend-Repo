package jdbc_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Utility_Classes.DbUtil;

public final class MainApp {

    private static final String SQL_UPDATE_QUERY =
        "UPDATE employee SET ename = ?, eaddress = ? WHERE eid = ?";
    private static final String SQL_SELECT_QUERY =
        "SELECT ename, eaddress FROM employee WHERE eid = ?";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement updateStmt = null;
        PreparedStatement selectStmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            connection = DbUtil.getMySQLConnection();

            if (connection != null) {
                selectStmt = connection.prepareStatement(SQL_SELECT_QUERY);
                updateStmt = connection.prepareStatement(SQL_UPDATE_QUERY);
            }

            System.out.print("Enter the employee ID you want to update: ");
            int id = sc.nextInt();

            // ✅ Step 1: Show existing data
            selectStmt.setInt(1, id);
            rs = selectStmt.executeQuery();

            if (rs.next()) {
                String oldName = rs.getString("ename");
                String oldAddress = rs.getString("eaddress");

                System.out.println("Old Name: " + oldName);
                System.out.println("Old Address: " + oldAddress);

                // ✅ Step 2: Take new values
                System.out.print("Enter new name: ");
                String newName = sc.next();

                System.out.print("Enter new address: ");
                String newAddress = sc.next();

                // ✅ Step 3: Perform the update
                updateStmt.setString(1, newName);
                updateStmt.setString(2, newAddress);
                updateStmt.setInt(3, id);

                int rows = updateStmt.executeUpdate();

                if (rows > 0) {
                    System.out.println("✅ Record updated successfully!");
                } else {
                    System.out.println("⚠️ No record found with ID: " + id);
                }
            } else {
                System.out.println("⚠️ No record found with ID: " + id);
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.cleanUpResources(rs, selectStmt, connection);
            DbUtil.cleanUpResources(null, updateStmt, null);
            sc.close();
        }
    }
}
