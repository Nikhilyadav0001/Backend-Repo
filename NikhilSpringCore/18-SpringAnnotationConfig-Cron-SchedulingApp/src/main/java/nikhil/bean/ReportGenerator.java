package nikhil.bean;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
	
	@Scheduled(cron = "6/5 0/2 * * * *")
	public void genetareeScaleReport() {
	
		//batch processing code 
		System.out.println("sales report on::"+ new Date());
	}

}
