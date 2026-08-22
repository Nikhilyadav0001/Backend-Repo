package nikhil.bean;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
	
	@Scheduled(initialDelay = 2000,fixedRate = 3000)
	public void genetareeScaleReport() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//batch processing code 
		System.out.println("sales report on::"+ new Date());
	}

}
