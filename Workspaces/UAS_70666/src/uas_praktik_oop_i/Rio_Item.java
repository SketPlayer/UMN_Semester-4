package uas_praktik_oop_i;

public abstract class Rio_Item {
	private String itemId;
	private String nama;
	private float harga;
	private int stok;
	
	public Rio_Item(String nama, float harga, int stok) {
		this.nama = nama;
		this.harga = harga;
		this.stok = stok;
	}
	
	public String getNama() {
		return nama;
	}

	public float getHarga() {
		return harga;
	}

	public int getStok() {
		return stok;
	}
	
	public void kurangiStok() {
		this.stok = stok-1;
	}
	
	public void kurangiStok(int jumlah) {
		this.stok = stok-jumlah;
	}
	
	public int hitungTotalDariJumlah(int jumlah) {
		return (int) (this.harga*jumlah);
	}

	
}
