package nikhil.beans;


public class Student {

	static {
		System.out.println("Student.class file is loading...");
	}

	public Student(String sid, String sname, Integer sage, String saddress) {
		System.out.println("Student:: param constructor...");
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	public Student(String sid, String sname, Integer sage) {
		System.out.println("Student:: param constructor...");
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		//this.saddress = saddress;
	}

	private String sid;
	private String sname;
	private Integer sage;
	private String saddress;

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", saddress=" + saddress + "]\n\n";
	}

	public String getSid() {
		System.out.println("Student.getSid()");
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		System.out.println("Student.getSname()");
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		System.out.println("Student.getSage()");
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSaddress() {
		System.out.println("Student.getSaddress()\n\n");
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

}
