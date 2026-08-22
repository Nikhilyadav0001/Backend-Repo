package nikhil.bean;

import org.springframework.stereotype.Component;

@Component
public class FedEx implements ICourier {

	@Override
	public String deliverOrder(Integer oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "FedEx []";
	}

	
}
