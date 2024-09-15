package week09.rio.ac.id.umn.Tugas;

public class Tetap extends Karyawan{
	public Tetap() {}
	
	public Tetap(String id, String nama) {
		this.id = id;
		this.nama = nama;
	}
	
	public int getGaji() {
		return 3000000;
	}
}