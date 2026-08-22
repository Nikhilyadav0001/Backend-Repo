package nikhil.service;

import java.util.ArrayList;
import java.util.List;

import nikhil.dao.InsurancePolicyDao;
import nikhil.dao.InsurancePolicyDaoImpl;
import nikhil.entity.InsurancePolicy;
import nikhil.entity.InsurancePolicyDTO;

public class InsurancePolicyMgmtServiceImpl implements InsurancePolicyManagementService {
	private InsurancePolicyDao dao ;
	
	public InsurancePolicyMgmtServiceImpl() {
		dao = new InsurancePolicyDaoImpl();
	}

	@Override
	public long fetchPagesCount(int pageSize) {
		//get the total no of records
		long recordCount =dao.getTotalrecordsCount();
		
		//calculating no of pages required
		long pagesCount = recordCount /pageSize;
		if (recordCount % pageSize !=0) {
			pagesCount++;
		}
		return pagesCount;
	}

	@Override
	public List<InsurancePolicyDTO> fetchPageDate(int pageSize, int pageNo) {
		//printing the records form starting pos to endpos in a page
		List<InsurancePolicyDTO> listDto =new ArrayList<InsurancePolicyDTO>();
		List<InsurancePolicy> entities =null;
		
		int startPos = 0;
		startPos = (pageNo*pageSize)-pageSize;
		entities =dao.getPageData(pageSize, startPos );//3,0
		
		//convert from bo to dto 
		entities.forEach(entity->{
				InsurancePolicyDTO dto =new InsurancePolicyDTO();
				dto.setPolicyId(entity.getPolicyId());
				dto.setPolicyName(entity.getPolicyName());
				dto.setPolicyType(entity.getPolicyType());
				dto.setTenure(entity.getTenure());
				dto.setCompany(entity.getCompany());
				dto.setSerialno(listDto.size() +1);
				listDto.add(dto);
		});
		return listDto; 
	}

}
