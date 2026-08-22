package nikhil.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "emp.info")
public class Employee {
	
	private String name;
	private Integer eid;
	
	private String[] nickName;

	private List<String> friendsNames;
	private Set<Long> phoneNumber;
	
	private Map<String, String> bankDetails;
	
	//user defined 
	private Company company;
	
	public void setCompany(Company company) {
		this.company = company;
	}

	public void setFriendsNames(List<String> friendsNames) {
		this.friendsNames = friendsNames;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public void setNickName(String[] nickName) {
		this.nickName = nickName;
	}
	

	public void setPhoneNumber(Set<Long> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setBankDetails(Map<String, String> bankDetails) {
		this.bankDetails = bankDetails;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", nickName=" + Arrays.toString(nickName) + ", friendsNames="
				+ friendsNames + ", phoneNumber=" + phoneNumber + ", bankDetails=" + bankDetails + ", company="
				+ company + "]";
	}

}
