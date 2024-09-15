package uas_praktik_oop_i;

public class Rio_Merchandise extends Rio_Item{
	private String namaMerk;
	private String kategori;
	
	public Rio_Merchandise(String nama, float harga, int stok, String namaMerk, String kategori) {
		super(nama, harga, stok);
		this.namaMerk = namaMerk;
		this.kategori = kategori;
	}
	
	public String getDataMerch() {
		return "Nama: " + getNama() + ", Harga: Rp " + getHarga() + ", Stok: " + getStok();
	}

	public String getNamaMerk() {
		return namaMerk;
	}

	public String getKategori() {
		return kategori;
	}
}
