package uts_praktik_oop_i;

public class Rio_Buku extends Rio_Publikasi{
	private String penerbit;
	private int jumlahHalaman;
	
	public Rio_Buku(String judul, String penulis, int tahunTerbit, String kategori
			, String penerbit, int jumlahHalaman) {
		super(judul, penulis, tahunTerbit, kategori);
		this.penerbit = penerbit;
		this.jumlahHalaman = jumlahHalaman;
	}
	
	// Getter
	public String getPenerbit() {
		return penerbit;
	}
	
	public int getJumlahHalaman() {
		return jumlahHalaman;
	}
	
	// Setter
	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}
	
	public void setJumlahHalaman(int jumlahHalaman) {
		this.jumlahHalaman = jumlahHalaman;
	}
}
