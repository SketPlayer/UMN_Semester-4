package week06.rio.ac.id.umn.Tugas;

public class Voucher extends Barang{
	private double pajak;
	public static int total;
	
	public Voucher(int id, String nama, double harga, int stok, double pajak) {
		super(id, nama, harga, stok);
		this.pajak = pajak;
	}
	
	public double getPajak() {
		return pajak;
	}
	
	public double gethargaJual() {
		return harga+harga*pajak;
	}
}
