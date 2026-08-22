package practice;

import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


import java.sql.SQLException;


class EmployeeSalaryFilter implements Predicate {

	private int high;
	private int low;

	public EmployeeSalaryFilter(int high, int low) {
		this.high = high;//36000
		this.low = low;//0
	}

	@Override
	public boolean evaluate(RowSet rs) {
		// logic for filtering
		boolean eval = false;

		try {
			
			FilteredRowSet frs = (FilteredRowSet) rs;
			
			int salary = frs.getInt(3);//36000
			boolean condition = salary>=high && salary>=low;
			
			if (condition) {
				eval = true;
			} else {
				eval = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eval;
	}

	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// It will be called at the time of RowInsertion
		return false;
	}

	@Override
	public boolean evaluate(Object value, String columnName) throws SQLException {
		// It will be called at the time of RowInsertion
		return false;
	}
}

public class FilterRowSetApp {


	public static void main(String[] args) {
		FilteredRowSet frs = null;

		try {

			RowSetFactory factory = RowSetProvider.newFactory();
			frs = factory.createFilteredRowSet();
			frs.setUrl("jdbc:mysql:///pwskills_octbatch");
			frs.setUsername("root");
			frs.setPassword("root123");
			frs.setCommand("select eid,ename,esal,eaddress from employees");
			frs.execute();

			System.out.println("Employee Details Before Filtering...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (frs.next()) {
				System.out.println(
						frs.getInt(1) + "\t" + frs.getString(2) + "\t" + frs.getInt(3) + "\t" + frs.getString(4));
			}

			EmployeeSalaryFilter filter = new EmployeeSalaryFilter(36000, 0);
			frs.setFilter(filter);

			frs.beforeFirst();

			System.out.println();
			System.out.println("Employee Details After Filtering...");
			System.out.println("EID\tENAME\tESAL\tEADDR");
			while (frs.next()) {
				System.out.println(
						frs.getInt(1) + "\t" + frs.getString(2) + "\t" + frs.getInt(3) + "\t" + frs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (frs != null) {
				try {
					frs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

	}

}
