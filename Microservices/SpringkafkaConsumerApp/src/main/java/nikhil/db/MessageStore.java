package nikhil.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nikhil.bean.StockApi;
import nikhil.converter.JsonUtil;
import nikhil.repo.IStockRepository;

@Component
public class MessageStore {

	@Autowired
	private IStockRepository repo;
	
	public void add(String message) {
		//JSON TO Object
		StockApi si = JsonUtil.convertJsonToObject(message);
		repo.save(si);
	}

	public List<StockApi> getAll() {
		return repo.findAll();
	}	
}