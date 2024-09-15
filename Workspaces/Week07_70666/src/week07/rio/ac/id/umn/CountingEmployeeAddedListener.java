package week07.rio.ac.id.umn;

public class CountingEmployeeAddedListener implements EmployeeAddedListener{
	private static int employeesAddedCount = 0;
	
	@Override
	public void onEmployeeAdded (Employee employee) {
		// Inkremen jumlah karyawan
		employeesAddedCount++;
		
		// Print jumlah karyawan
		System.out.println("Total karayawan : " + employeesAddedCount);
	}
}
