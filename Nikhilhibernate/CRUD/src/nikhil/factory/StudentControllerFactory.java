package nikhil.factory;

import nikhil.controller.IStudentController;
import nikhil.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static IStudentController controller = null;

	public static IStudentController getStudentControllerObj() {
		if (controller == null) {
			controller = new StudentControllerImpl();
		}
		return controller;
	}

}
