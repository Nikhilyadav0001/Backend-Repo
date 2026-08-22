package nikhil.converter;

import nikhil.bean.StockApi;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.JsonNodeException;

public class JsonUtil {

	public static String convertObjectToJson(StockApi stock) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(stock);
		} catch (JsonNodeException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}