package nikhil.service;

import java.util.List;

import nikhil.beans.PoliticalParty;

public interface IPoliticalMgmtService {
	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(Integer partyId);
	public List<PoliticalParty> fetchPoliticalPartiesByNames(String partyName1,String partyName2);
	public int modifyFlagColorsByPartyName(String newColor,String partyName);
}
