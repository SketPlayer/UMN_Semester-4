package week04.rio.ac.id.umn;

public class Order {
	private int id;
	private int jumlah;
	private Barang barang;
	public static int total;
	
	public Order() {}
	public Order(int id, Barang barang, int jumlah) {
		this.id = id;
		this.barang = barang;
		this.jumlah = jumlah;
	}
	
	public int getId() {
		return id;
	}
	
	public int getJumlah() {
		return jumlah;
	}
	
	public Barang getBarang() {
		return barang;
	}
}
