package week09.rio.ac.id.umn.Tugas;

public class Karyawan {
	protected String id;
	protected String nama;
	protected int gaji;
	
	public Karyawan() {}
	
	public Karyawan(String id, String nama) {
		this.id = id;
		this.nama = nama;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public int getGaji() {
		return gaji;
	}
}
