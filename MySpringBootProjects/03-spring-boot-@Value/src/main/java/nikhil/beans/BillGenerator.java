package nikhil.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bill")
public class BillGenerator {
	
	//spel
	@Value("#{info.momosPrice+ info.rollPrice+ info.samosaPrice}")
	private Float billAmount;
	
	@Value("paradise")
	private String hotalName;
	
	@Autowired
	private ItemsInfo items;

	@Override
	public String toString() {
		return "BillGenerator [billAmount=" + billAmount + ", hotalName=" + hotalName + ", items=" + items + "]";
	}
}
