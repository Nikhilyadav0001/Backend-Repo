package nikhil.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nikhil.dao.IEmployeeDao;

@Service("service")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public int fetchEmployeeCount() {
		
		return dao.getEmployeeCount();
	}

	@Override
	public float fetchEmployeeSalaryByEno(Integer eid) {
		
		return dao.getEmployeeSalaryByEno(eid);
	}

	@Override
	public Map<String, Object> fetchEmployeeByEno(Integer eid) {
		return dao.getEmployeeByEno(eid);
	}

	@Override
	public List<Map<String, Object>> fetchEmployeeByDesgn(String desg1, String desg2) {
		// TODO Auto-generated method stub
		return dao.getEmployeeByDesgn(desg1, desg2);
	}

	@Override
	public int registerEmployee(String empName, String job, Float salary, Integer deptNo, Integer mgrNo) {
		// TODO Auto-generated method stub
		return dao.insertEmployee(empName, job, salary, deptNo, mgrNo);
	}

}
