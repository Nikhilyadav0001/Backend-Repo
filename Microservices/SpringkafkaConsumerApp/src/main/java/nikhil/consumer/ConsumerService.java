package nikhil.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import nikhil.db.MessageStore;

@Component
public class ConsumerService {
	
	@Autowired
	private MessageStore store;
	
	@KafkaListener(topics = "${my.topic.name}",groupId = "NK")
	public void readData(String message) {
		
		//ues massage for internal usage
		
		System.out.println("CONSUMER IS READING THE DATA");
		System.out.println(message);
	
		//saving the results
		store.add(message);
	}

}
