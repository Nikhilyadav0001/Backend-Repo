package nikhil.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	private String doorNo;
	private String streetName;
	private String areaCode;
	private String cityname;
	private String country;
	private long pinCode;
	
	static {
		System.out.println("loading the address.class file");
	}
	
	
	
	public Address(String doorNo, String streetName, String areaCode, String cityname, String country, long pinCode) {
		super();
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.areaCode = areaCode;
		this.cityname = cityname;
		this.country = country;
		this.pinCode = pinCode;
	}


	public Address() {
		System.out.println("zero param cosntructer of adress class");
	}


	public String getDoorNo() {
		return doorNo;
	}


	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getAreaCode() {
		return areaCode;
	}


	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}


	public String getCityname() {
		return cityname;
	}


	public void setCityname(String cityname) {
		this.cityname = cityname;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public long getPinCode() {
		return pinCode;
	}


	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}


	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", streetName=" + streetName + ", areaCode=" + areaCode + ", cityname="
				+ cityname + ", country=" + country + ", pinCode=" + pinCode + "]";
	}
	
	  

}
