package nikhil.beans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Flipkart {
	@Autowired
	@Qualifier("ekart")
	private iCourier courier;
	
	static {
		System.out.println("Flipkart.class file is loading...");
	}

	public Flipkart() {
		System.out.println("Flipkart object is created...");
	}
	
	
	public String shopping (String[] items, float[] prices) {
		System.out.println("Flipkart.shopping()");
		float billamount =0;
		
		for (float data : prices) {
			billamount += data;
		}
		String msg = courier.deliver(new Random().nextInt(1000));
		
		
		return msg+Arrays.toString(items)+
				"with prices"+Arrays.toString(prices)+
				"having bill amount ="+billamount;
	}
	
}
