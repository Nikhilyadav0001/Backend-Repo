package nikhil.bean;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String aname;
	private Float avg;
	@Embedded
	private Address address;
	
	
	

	public StudentInfo(String aname, Float avg, Address address) {
		super();
		this.aname = aname;
		this.avg = avg;
		this.address = address;
	}

	static {
		System.out.println("loading the .class file of student info");
	}
	
	public StudentInfo() {
		System.out.println("zero param constructer of  studentInfo");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Float getAvg() {
		return avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "StudentInfo [sid=" + sid + ", aname=" + aname + ", avg=" + avg + ", address=" + address + "]";
	}

	

	
}
