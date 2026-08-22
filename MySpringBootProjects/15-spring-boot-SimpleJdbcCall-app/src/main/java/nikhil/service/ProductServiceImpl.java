package nikhil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nikhil.beans.ProductBO;
import nikhil.beans.ProductDTO;
import nikhil.dao.IProductDao;

@Service("service")
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao dao;

	@Override
	public List<ProductDTO> fetchProductsByName(String prod1, String prod2) {

		List<ProductBO> listBo = dao.getProductsByName(prod1, prod2);

		ArrayList<ProductDTO> listDto = new ArrayList<>();

		listBo.forEach(bo -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(bo, dto);
			listDto.add(dto);
		});

		return listDto;
	}

}