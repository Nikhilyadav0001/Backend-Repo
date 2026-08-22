package nikhil.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDao {
	public int  getEmployeeCount();
	public float getEmployeeSalaryByEno(Integer eid);
	
	public Map<String,Object> getEmployeeByEno(Integer eid);
	
	public List<Map<String,Object>> getEmployeeByDesgn(String desg1 ,String desg2);

	public int insertEmployee(String empName,String job,Float salary,Integer deptNo,Integer mgrNo);
}
