package nikhil.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishMassageGenerator {
	static {
			System.out.println("WishMessageGenerator.class file is loading...");
		}
	
	public WishMassageGenerator() {
		System.out.println("WishMessageGenerator Object is created...");
	}
	
	@Autowired
	private LocalDateTime ldt;
	
	//bussiness logic
	public String wishMassage(String user) {
		System.out.println("WishMessageGenerator.wishMessage()");
		int hour = ldt.getHour();
		String msg ="";
		if (hour < 12) {
			msg +="good morning::"+ user;
		}else if (hour<16) {
			msg+="Good afternoon"+user;
		}else if (hour<20) {
			msg+="Good evening"+user;
		}else {
			msg+="good night"+user;
		}
		
		
		return msg;
	}
}
