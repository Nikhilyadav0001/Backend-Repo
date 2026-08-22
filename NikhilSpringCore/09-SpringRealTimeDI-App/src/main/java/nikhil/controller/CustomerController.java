package nikhil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nikhil.beans.CustomerDTO;
import nikhil.beans.CustomerVo;
import nikhil.service.ICustomerService;

@Component("controller")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	
	public String processesCustomer(CustomerVo vo) throws Exception {
		
		// converting VO to DTO for service layer
		CustomerDTO dto = new CustomerDTO();
		dto.setCustName(vo.getCustName());
		dto.setCustAddr(vo.getCustAddr());

		// converting String to float data
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));

		return service.calculateSimpleInterest(dto);
		
	}
}
