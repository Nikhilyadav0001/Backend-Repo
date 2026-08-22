package nikhil.service;

import nikhil.beans.CustomerDTO;


public interface ICustomerService {

	public String calculateSimpleInterest(CustomerDTO dto) throws Exception;
}