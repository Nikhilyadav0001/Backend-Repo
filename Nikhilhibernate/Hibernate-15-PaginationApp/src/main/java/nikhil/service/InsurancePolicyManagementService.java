package nikhil.service;

import java.util.List;

import nikhil.entity.InsurancePolicyDTO;

public interface InsurancePolicyManagementService {
	
	public long fetchPagesCount(int pageSize);
	public List<InsurancePolicyDTO> fetchPageDate(int pageSize,int pageNo);
	
}
