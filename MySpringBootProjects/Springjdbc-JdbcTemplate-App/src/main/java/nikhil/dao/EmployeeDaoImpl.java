package nikhil.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final String GET_SQL_COUNT = "select count(*) from employee";
	private static final String GET_EMP_SAL_BY_ENO = "select salary from employee where empNo=?";
	private static final String GET_EMP_BY_ENO = "select * from employee where empNo =?";
	private static final String GET_EMP_BY_DESG = "select * from employee where job in (?,?) order by job ";
	private static final String INSERT_EMP_QUERY = "INSERT INTO employee (ename, job, salary, deptNo, mgrNo) VALUES (?, ?, ?, ?, ?)";;
	@Autowired
	public JdbcTemplate template;
	
	@Override
	public int getEmployeeCount() {
		
		return template.queryForObject(GET_SQL_COUNT, Integer.class);
	}

	@Override
	public float getEmployeeSalaryByEno(Integer eid) {
		// TODO Auto-generated method stub
		return template.queryForObject(GET_EMP_SAL_BY_ENO, Float.class,eid);
	}

	@Override
	public Map<String, Object> getEmployeeByEno(Integer eid) {
		// TODO Auto-generated method stub
		return template.queryForMap(GET_EMP_BY_ENO,eid);
	}

	@Override
	public List<Map<String, Object>> getEmployeeByDesgn(String desg1, String desg2) {
		// TODO Auto-generated method stub
		return template.queryForList(GET_EMP_BY_DESG,desg1,desg2);
	}

	@Override
	public int insertEmployee(String empName, String job, Float salary, Integer deptNo, Integer mgrNo) {
		
		return template.update(INSERT_EMP_QUERY,empName,job,salary,deptNo,mgrNo);
	}

}
