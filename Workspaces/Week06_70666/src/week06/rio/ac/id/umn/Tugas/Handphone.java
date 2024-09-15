package week06.rio.ac.id.umn.Tugas;

public class Handphone extends Barang{
	private String warna;
	public static int total;
	
	public Handphone(int id, String nama, double harga, int stok, String warna) {
		super(id, nama, harga, stok);
		this.warna = warna;
	}
	
	public String getWarna() {
		return warna;
	}
}
