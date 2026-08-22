package nikhil.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nikhil.consumer.CartConsumer;

@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {

	/*
	 * METHOD  : GET
	 * PATH    : /place
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/order/place
	 * 
	 */
	
	@Autowired
	private CartConsumer consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder() {
		String cartResponse = consumer.getCartService();
		return ResponseEntity.ok("ORDER PLACED WITH => "+cartResponse);
	}

}