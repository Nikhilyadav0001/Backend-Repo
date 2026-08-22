package nikhil.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import nikhil.service.ProducerService;

@Component
public class ProducerTest {
	
	@Autowired
	private ProducerService service;
	
	@Scheduled(cron="*/10 * * * * *")
	public void sendMessage() {
		service.sendData("hello:: "+new Date());
		System.out.println("producer sent the massage..");
	}

}
