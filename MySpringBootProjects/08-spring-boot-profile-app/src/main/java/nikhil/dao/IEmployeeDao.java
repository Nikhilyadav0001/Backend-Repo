package nikhil.dao;

import java.util.List;

import nikhil.beans.EmployeeBO;

public interface IEmployeeDao {

	public List<EmployeeBO>fetchEmpByDesg(String cond) throws Exception;
}
