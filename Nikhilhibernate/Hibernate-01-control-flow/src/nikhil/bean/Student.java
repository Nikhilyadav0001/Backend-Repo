package nikhil.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Student")
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="sid")
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer sid;
	@Column(name="sname",length =20)
	private String sname;
	@Column(name="saddress",length =20)
	private String saddress;
	@Column(name="sage")
	private Integer sage;
	
	static {
		System.out.println("student.class file is loading...");
	}
	public Student() {
		System.out.println("student object :: zero param cinstructor");
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
}
