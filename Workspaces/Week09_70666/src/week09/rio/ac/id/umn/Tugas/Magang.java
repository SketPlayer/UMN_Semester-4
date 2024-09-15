package week09.rio.ac.id.umn.Tugas;

public class Magang extends Karyawan{
	public Magang() {}
	
	public Magang(String id, String nama) {
		this.id = id;
		this.nama = nama;
	}
	
	public int getGaji() {
		return 1500000;
	}
}
