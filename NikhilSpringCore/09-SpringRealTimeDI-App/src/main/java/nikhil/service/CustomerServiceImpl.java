package nikhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nikhil.beans.CustomerBo;
import nikhil.beans.CustomerDTO;
import nikhil.dao.ICustomerDao;

@Component("service")
public final class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;
	
	@Override
	public String calculateSimpleInterest(CustomerDTO dto) throws Exception {
		//calclating the simple intrest for the given dtp 
		float si =(dto.getPamt()*dto.getRate()*dto.getTime())/100;
		
		// Create a business object from DTO
		CustomerBo bo = new CustomerBo();
		bo.setCustAddr(dto.getCustAddr());
		bo.setCustName(dto.getCustName());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		
		// injecting simple-interest amount for BO
		bo.setInterestAmount(si);

		int count = dao.insert(bo);

		return count == 1 ? "Customer registered succesfully with the intereset amount :: " + si
						: "customer registration failed";
	}

}
