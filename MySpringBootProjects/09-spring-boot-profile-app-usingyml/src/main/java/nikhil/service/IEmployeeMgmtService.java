package nikhil.service;

import java.util.List;

import nikhil.beans.EmployeeDTO;

public interface IEmployeeMgmtService {

	public List<EmployeeDTO>fetchEmpByDesg(String desg []) throws Exception;
}
