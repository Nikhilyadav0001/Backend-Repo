package nikhil.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@NonNull
	private Integer eid;
	@NonNull
	private String sname;
	@NonNull
	@ToString.Exclude
	private String saddress;
	private Float esalary;
	
}
