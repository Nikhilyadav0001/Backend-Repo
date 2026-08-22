package nikhil.dao;

import java.util.List;

import nikhil.beans.EmployeeBO;

public interface IEmployeeDao {
	public String getEmpNameByEno(Integer empNo);
	public List<EmployeeBO> getEmployeeDetailsBasedOnDesg(String desg1,String desg2);
	public int saveEmployee(EmployeeBO bo);
}