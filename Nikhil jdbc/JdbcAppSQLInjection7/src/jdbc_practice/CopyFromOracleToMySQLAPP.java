package jdbc_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utility_Classes.DbUtil;

public class CopyFromOracleToMySQLAPP {

    private static final String SQL_INSERT_QUERY =
        "INSERT INTO canarabank (accno, holdername, balance) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_QUERY =
        "SELECT accno, holdername, balance FROM syndicatebank";

    public static void main(String[] args) {

        Connection mysqlconnection = null;
        Connection oracleconnection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1️⃣ Establish database connections
            mysqlconnection = DbUtil.getMySQLConnection();
            oracleconnection = DbUtil.getOracleConnection();

            // 2️⃣ Create statement for Oracle
            if (oracleconnection != null) {
                statement = oracleconnection.createStatement();
            }

            // 3️⃣ Create prepared statement for MySQL
            if (mysqlconnection != null) {
                preparedStatement = mysqlconnection.prepareStatement(SQL_INSERT_QUERY);
            }

            // 4️⃣ Execute select query on Oracle
            if (statement != null) {
                resultSet = statement.executeQuery(SQL_SELECT_QUERY);
            }

            // 5️⃣ Copy data from Oracle → MySQL
            if (preparedStatement != null && resultSet != null) {

                while (resultSet.next()) {
                    preparedStatement.setInt(1, resultSet.getInt(1));
                    preparedStatement.setString(2, resultSet.getString(2));
                    preparedStatement.setFloat(3, resultSet.getFloat(3));

                    preparedStatement.executeUpdate();
                }

                System.out.println("Record(s) copied from Oracle to MySQL successfully.");
            }

        } catch (IOException | SQLException e) {
            System.err.println("Error occurred while copying record:");
            e.printStackTrace();
        } finally {
            // 6️⃣ Cleanup resources
            DbUtil.cleanUpResources(resultSet, statement, oracleconnection);
            DbUtil.cleanUpResources(null, preparedStatement, mysqlconnection);
        }
    }
}
