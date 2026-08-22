package nikhil.dao;

import java.util.List;

import nikhil.entity.InsurancePolicy;

public interface InsurancePolicyDao {

	public long getTotalrecordsCount();
	public List<InsurancePolicy> getPageData(int pageSize, int startPos);
}
