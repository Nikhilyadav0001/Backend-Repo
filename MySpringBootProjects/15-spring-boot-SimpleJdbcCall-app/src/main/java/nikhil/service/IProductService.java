package nikhil.service;

import java.util.List;

import nikhil.beans.ProductDTO;

public interface IProductService {
	public List<ProductDTO> fetchProductsByName(String prod1,String prod2);
}