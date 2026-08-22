package nikhil.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMgmtService {

	public int fetchEmployeeCount();
	public float fetchEmployeeSalaryByEno(Integer eid);
	
	public Map<String,Object> fetchEmployeeByEno(Integer eid);
	
	public List<Map<String,Object>> fetchEmployeeByDesgn(String desg1 ,String desg2);
	
	public int registerEmployee(String empName,String job,Float salary,Integer deptNo,Integer mgrNo);
}
