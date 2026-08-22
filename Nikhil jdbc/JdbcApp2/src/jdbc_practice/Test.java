package jdbc_practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Test {
	public static void main(String[] args) throws ParseException {
		String userInput="02-11-2025";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date utilDate=sdf.parse(userInput);
		long inputms = utilDate.getTime();
		java.sql.Date sqldate = new java.sql.Date(inputms);
		System.out.println(sqldate);
	}
}
