package nikhil.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Dtdc implements iCourier {

	static {
		System.out.println("Dtdc.class file is loading..");
	}

	public Dtdc() {
		System.out.println("Dtdc object created...");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering "+oid + "orderid for your order products using DTDC" ;
	}

}
