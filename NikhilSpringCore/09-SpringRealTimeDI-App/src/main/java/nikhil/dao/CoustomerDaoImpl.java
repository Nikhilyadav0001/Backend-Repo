package nikhil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nikhil.beans.CustomerBo;

@Component("dao")
public final class CoustomerDaoImpl implements ICustomerDao {

	private static final String SQL_INSERT_QUERY =
			"insert into customer(`cname`,`caddr`,`pamt`,`rate`,`time`,`si`)"
													+ " values(?,?,?,?,?,?)";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int insert(CustomerBo bo) throws Exception {
		System.out.println(dataSource);
		
		int count =0;
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY);
		
			// set the values to PREPAREDSTATEMENT query
			preparedStatement.setString(1, bo.getCustName());
			preparedStatement.setString(2, bo.getCustAddr());
			preparedStatement.setFloat(3, bo.getPamt());
			preparedStatement.setFloat(4, bo.getRate());
			preparedStatement.setFloat(5, bo.getTime());
			preparedStatement.setFloat(6, bo.getInterestAmount());

			count = preparedStatement.executeUpdate();

			
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception se) {
			se.printStackTrace();
			throw se;
		}
		
		
		return count;
	}

}
