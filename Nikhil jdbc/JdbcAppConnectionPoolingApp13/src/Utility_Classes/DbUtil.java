package Utility_Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class DbUtil {

    static Properties p = null;
    static  MysqlConnectionPoolDataSource dataSource = null;

    static {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream("D:\\java files\\Nikhil jdbc\\JdbcAppConnectionPoolingApp13\\src\\Properties_Files\\database.properties");
            p = new Properties(); // ✅ assign to class-level variable
            p.load(fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fs != null)
                    fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    
    
    dataSource = new MysqlConnectionPoolDataSource ();
    dataSource.setURL(p.getProperty("mysqlurl"));
    dataSource.setUser(p.getProperty("mysqluser"));
    dataSource.setPassword(p.getProperty("mysqlpassword"));
    }
    public static Connection getMySQLConnection() throws IOException, SQLException {
        if (p == null) {
            throw new IOException("Database properties not loaded properly.");
        }
        //working with connection pooling
        
        
        
        
        return dataSource.getConnection();
    }
    

    public static void cleanUpResources(ResultSet rs, Statement st, Connection connection) {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
