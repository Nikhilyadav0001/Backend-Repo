package nikhil.beans;

public class Company {
	
	static {
		System.out.println("Company.enclosing_method()");
	}
	public Company() {
		System.out.println("Company.Company()");
	}
	
	
	private String title;
	private String location;
	private Integer size;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Company [title=" + title + ", location=" + location + ", size=" + size + "]";
	}
	
	

}
