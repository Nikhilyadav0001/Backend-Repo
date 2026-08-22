package nikhil.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Flipcart {

	@Autowired
	//@Qualifier(value= "ekart")
	private ICourier courier;

	@Override
	public String toString() {
		return "Flipcart [courier=" + courier + "]";
	}
	
}
