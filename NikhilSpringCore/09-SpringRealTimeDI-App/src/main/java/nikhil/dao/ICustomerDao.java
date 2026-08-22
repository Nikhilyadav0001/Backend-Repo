package nikhil.dao;

import nikhil.beans.CustomerBo;

public interface ICustomerDao {
	public int insert(CustomerBo bo) throws Exception;
}
