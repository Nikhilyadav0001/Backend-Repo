package nikhil.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "MOBILE_COUNSTOMERS")
public class MoibileCustomer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "MoibileCustomer [cno=" + cno + ", name=" + name + ", mobileNo=" + mobileNo + ", callerTune="
				+ callerTune + ", versionCount=" + versionCount + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	@Column(name = "cname",length =20)
	private String name;
	@Column(name = "mobileNo")
	private long mobileNo;
	
	@Column(name = "callerTune",length =20)
	private String callerTune;
	@Version
	private Integer versionCount;

	static {
		System.out.println("HIBERNATE --> loading .class of mobie costomer");
	}
	public MoibileCustomer() {
		System.out.println("HIBERNATE --> mobilecustomer zero param constructor");
		
	}
	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCallerTune() {
		return callerTune;
	}

	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	
}
