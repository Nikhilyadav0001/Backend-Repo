package nikhil.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.beans.PoliticalParty;
import nikhil.service.IPoliticalMgmtService;


@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IPoliticalMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		PoliticalParty party = service.fetchPoliticalPartyDetailsByPartyId(2);
		System.out.println(party);
		
		System.out.println("************************");
		
		service.fetchPoliticalPartiesByNames("congress", "bjp").forEach(System.out::println);
		
		int count = service.modifyFlagColorsByPartyName("white", "congress");
		System.out.println("No of rows modified are :: "+count);
	
	}
}