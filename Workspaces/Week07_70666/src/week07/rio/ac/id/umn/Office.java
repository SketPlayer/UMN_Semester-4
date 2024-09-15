package week07.rio.ac.id.umn;

import java.util.ArrayList;
import java.util.List;

public class Office {
	private List<Employee> employees = new ArrayList<>();
	private List<EmployeeAddedListener> listeners = new ArrayList<>();
	
	public void addEmployee (Employee employee) {
		// Tambah karyawan ke daftar karyawan
		this.employees.add(employee);
		// beritahu daftar listener
		this.notifyEmployeeAddedListeners(employee);
	}
	
	public void registerEmployeeAddedListener (EmployeeAddedListener listener) {
		// tambah listener ke daftar listener
		this.listeners.add(listener);
	}
	
	public void unregisterEmployeeAddedListener (EmployeeAddedListener listener) {
		// menghilangkan listener ke daftar listener
		this.listeners.remove(listener);
	}
	
	public void notifyEmployeeAddedListeners (Employee employee) {
		// beritahu setiap listener dalam daftar listener
		this.listeners.forEach(listener -> listener.onEmployeeAdded(employee));
	}
}
