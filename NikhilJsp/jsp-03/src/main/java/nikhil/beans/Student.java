package nikhil.beans;

public class Student {
	
	private String name;
	private String address;
	private Integer age;
	
	static {
		System.out.println("student class file loading  ");
	}
	public Student() {
		System.out.println("student object created");
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("Student.setName()"+name);
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		System.out.println("Student.setAddress()"+address);
		this.address = address;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		System.out.println("Student.setAge()"+age);
		this.age = age;
	}
	

}
