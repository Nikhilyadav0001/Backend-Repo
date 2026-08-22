package nikhil.dao;

import java.util.List;

import nikhil.beans.ProductBO;

public interface IProductDao {
	public List<ProductBO> getProductsByName(String prod1,String prod2);
}