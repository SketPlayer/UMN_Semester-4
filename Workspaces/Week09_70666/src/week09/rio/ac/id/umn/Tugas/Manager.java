package week09.rio.ac.id.umn.Tugas;

public class Manager extends Karyawan{
	public Manager() {}
	
	public Manager(String id, String nama) {
		this.id = id;
		this.nama = nama;
	}
	
	public int getGaji() {
		return 10000000;
	}
}
