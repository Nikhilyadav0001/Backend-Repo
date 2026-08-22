package nikhil.converter;

import nikhil.bean.StockApi;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.exc.JsonNodeException;

public class JsonUtil {

	public static StockApi convertJsonToObject(String message) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(message, StockApi.class);
		} catch (JsonNodeException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}