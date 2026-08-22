package nikhil.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import nikhil.beans.EmployeeBO;

@Repository("dao")
@Profile(value = {"dev","qa"})
public class MySqlEmployeeDaoImpl implements IEmployeeDao {

	
	static {
		System.out.println("MySqlEmployeeDaoImpl.enclosing_method()");
	}
	
	
	private static final String GET_EMP_DESG = "SELECT * FROM employee Where job IN";
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<EmployeeBO> fetchEmpByDesg(String cond) throws Exception {
		
		List<EmployeeBO> listBo =null;
		EmployeeBO bo =null;
		
		try(Connection connection =dataSource.getConnection();
				//USE Connection and perform db operation using plain jdbc
				Statement stmt =connection.createStatement();
				//use result set to pull tthe records
				ResultSet resultSet =stmt.executeQuery(GET_EMP_DESG+cond+ "ORDER BY job")
						){
			
			System.out.println("datasource type is::"+dataSource.getClass().getName());
			
			
			listBo =new ArrayList<>();
			//process resultset
			while (resultSet.next()) {
				//copy record form rs to bo
				bo = new EmployeeBO();
				bo.setEmpNo(resultSet.getInt(1));
				bo.setEmpName(resultSet.getString(2));
				bo.setJob(resultSet.getString(3));
				bo.setSalary(resultSet.getFloat(4));
				bo.setDeptNo(resultSet.getInt(5));
				bo.setMgrNo(resultSet.getInt(6));
				
				listBo.add(bo);
			}
			
			
		}catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		
		return listBo;
	}

}
