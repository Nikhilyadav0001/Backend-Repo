package nikhil.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("info")
public class ItemsInfo {
	
	@Value("${momos.price}")
	public Float momosPrice;
	
	@Value("${roll.price}")
	public Float rollPrice;
	
	@Value("${samosa.price}")
	public Float samosaPrice;
	
	@Override
	public String toString() {
		return "ItemsInfo [momosPrice=" + momosPrice + ", rollPrice=" + rollPrice + ", samosaPrice=" + samosaPrice
				+ "]";
	}
}
