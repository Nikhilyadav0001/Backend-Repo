package nikhil.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//see persioninfo.hbm.xml for help

public class PersonInfo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	
	private String pname;
	
	private String paddr;
	
	private LocalDateTime dob;
	private LocalDate dom;
	private LocalTime doj;
	
	static {
		System.out.println("hibernates loads .clsss file");
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPaddr() {
		return paddr;
	}
	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public LocalDate getDom() {
		return dom;
	}
	public void setDom(LocalDate dom) {
		this.dom = dom;
	}
	public LocalTime getDoj() {
		return doj;
	}
	public void setDoj(LocalTime doj) {
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "PersonInfo [id=" + id + ", pname=" + pname + ", paddr=" + paddr + ", dob=" + dob + ", dom=" + dom
				+ ", doj=" + doj + "]";
	}
	
	
	
	
	
}
