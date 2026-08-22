package nikhil.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="NAUKARI")
public class Naukari implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NAME",length=20)
	private String name;
	@Column(name = "ADDRESS",length=20)
	private String address;
	
	@Lob
	@Column(name = "IMAGE")
	private byte[] image;
	@Lob
	@Column(name = "RESUME")
	private char[] resume;
	
	static {
		System.out.println("hibernate naukari.class file is loading");
	}
	
	
	public Naukari() {
		System.out.println("hibernate ------> naukari object using zero param constructer");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public char[] getResume() {
		return resume;
	}
	public void setResume(char[] resume) {
		this.resume = resume;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Naukari [id=" + id + ", name=" + name + ", address=" + address + ", image=" + Arrays.toString(image)
				+ ", resume=" + Arrays.toString(resume) + "]";
	}
	
}
