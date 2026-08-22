package nikhil.beans;

public class Student {

	public Student() {
		
	}
	private String sname;
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
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
	private String saddress;
	private Integer sage;
	
}
