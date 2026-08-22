package nikhil.dao;

public interface IHospitalDao {
	//performing insert operation using parent
	public void saveRecordUsingDoctor();
	public void saveRecordUsingChild();
	
	//performing select operation using parent
	public void loadRecordUsingParent();
	
	
	
	
}
